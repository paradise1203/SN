package com.aidar.repository;

import com.aidar.model.Message;
import com.aidar.model.User;

import java.util.List;

public interface MessageRepositoryCustom {

    public List<Message> getMessages(User user1, User user2);

    public void updateMessages(User user1, User user2);

}
