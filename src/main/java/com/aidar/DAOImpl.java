package com.aidar;

import com.aidar.data.*;
import com.aidar.vkapi.VkOAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DAOImpl implements DAO {

    @Autowired
    private FriendsDAO friendsDAO;

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    VkOAuthService vkOAuthService;

    public Integer addUserAndGetId(String code) {
        return userRepository.addUser(vkOAuthService.processUser(code));
    }

    public List<User> getFriends(Integer id) {
        List<Friends> friendsList = friendsDAO.getFriends(id);
        List<Integer> ids = new LinkedList<>();
        friendsList.stream().forEach(friend -> {
            Integer firstId = friend.getFirstId();
            if (id.equals(firstId))
                ids.add(friend.getSecondId());
            else
                ids.add(firstId);
        });
        List<User> friends = new LinkedList<>();
        ids.stream().forEach(userId -> {
            friends.add(userRepository.findById(userId));
        });
        return friends;
    }

    public List<User> getOtherUsers(Integer id, List<User> friends) {
        List<User> users = userRepository.getUsers(id);
        users.removeAll(friends);
        return users;
    }

    public User getCurrentUser(Integer id) {
        return userRepository.findById(id);
    }

    public void makeFriends(Integer senderId, Integer recipientId) {
        friendsDAO.addFriends(senderId, recipientId);
    }

    public void removeFriends(Integer senderId, Integer recipientId) {
        friendsDAO.removeFriends(senderId, recipientId);
    }

    public List<Message> getDialog(Integer senderId, Integer recipientId) {
        return messageDAO.getMessages(senderId, recipientId);
    }

    public void sendMessage(Integer sender, Integer recipient, String message) {
        messageDAO.addMessage(sender, recipient, message);
    }

}
