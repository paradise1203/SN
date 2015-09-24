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
    private VkOAuthService vkOAuthService;

    @Override
    public Integer addUserAndGetId(String code) {
        return userRepository.addUser(vkOAuthService.processUser(code));
    }

    @Override
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

    @Override
    public List<User> getOtherUsers(Integer id, List<User> friends) {
        List<User> users = userRepository.getUsers(id);
        users.removeAll(friends);
        return users;
    }

    @Override
    public User getCurrentUser(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void makeFriends(Integer senderId, Integer recipientId) {
        friendsDAO.addFriends(senderId, recipientId);
    }

    @Override
    public void removeFriends(Integer senderId, Integer recipientId) {
        friendsDAO.removeFriends(senderId, recipientId);
    }

    @Override
    public List<Message> getDialog(Integer senderId, Integer recipientId) {
        return messageDAO.getMessages(senderId, recipientId);
    }

    @Override
    public void sendMessage(Integer sender, Integer recipient, String message) {
        messageDAO.addMessage(sender, recipient, message);
    }

    @Override
    public List<Message> getNewMessages(Integer senderId, Integer recipientId) {
        return messageDAO.getNewMessages(senderId, recipientId);
    }

}
