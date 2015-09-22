package com.aidar;

import com.aidar.data.Message;
import com.aidar.data.User;

import java.util.List;

public interface DAO {

    public Integer addUserAndGetId(String code);

    public List<User> getFriends(Integer id);

    public List<User> getOtherUsers(Integer id, List<User> friends);

    public User getCurrentUser(Integer id);

    public void makeFriends(Integer senderId, Integer recipientId);

    public void removeFriends(Integer senderId, Integer recipientId);

    public List<Message> getDialog(Integer senderId, Integer recipientId);

    public void sendMessage(Integer sender, Integer recipient, String message);

}
