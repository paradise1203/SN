package com.aidar.util;

import com.aidar.model.Message;
import com.aidar.model.User;
import com.aidar.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToFriendsWithLastMessageTransformer {

    @Autowired
    private MessageService messageService;

    public List<FriendsWithLastMessage> transform(User user, List<User> friends) {
        List<FriendsWithLastMessage> friendsWithLastMessages = new ArrayList<>();
        for (User f : friends) {
            List<Message> messages = messageService.getMessages(user, f);
            friendsWithLastMessages.add(new FriendsWithLastMessage(f, messages.size()>0? messages.get(messages.size() -1) : null));
        }
        return friendsWithLastMessages;
    }

}
