package com.aidar.service;

import com.aidar.model.Message;
import com.aidar.model.User;

import java.util.List;

public interface MessageService {

    public List<Message> getMessages(User user1, User user2);

    public List<Message> getNewMessages(User user1, User user2);

    public void addMessage(User user1, User user2, String text);

}
