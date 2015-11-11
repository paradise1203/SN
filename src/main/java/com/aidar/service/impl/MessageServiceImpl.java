package com.aidar.service.impl;

import com.aidar.model.Message;
import com.aidar.model.User;
import com.aidar.repository.MessageRepository;
import com.aidar.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    @Qualifier("messageRepository")
    private MessageRepository messageRepository;

    @Override
    public List<Message> getMessages(User user1, User user2) {
        List<Message> messages = messageRepository.getMessages(user1, user2);
        messageRepository.updateMessages(user2, user1);
        return messages;
    }

    @Override
    public List<Message> getNewMessages(User user1, User user2) {
        List<Message> messages = messageRepository.findByUser1AndUser2AndIsNew(user2, user1, true);
        messageRepository.updateMessages(user2, user1);
        return messages;
    }

    @Override
    public void addMessage(User user1, User user2, String text) {
        messageRepository.save(new Message(text, new Date(), user1, user2));
    }

}
