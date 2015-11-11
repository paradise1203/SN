package com.aidar.util;

import com.aidar.model.Message;
import com.aidar.model.User;

public class FriendsWithLastMessage {

    private User friend;

    private Message message;

    public FriendsWithLastMessage() {
    }

    public FriendsWithLastMessage(User friend, Message message) {
        this.friend = friend;
        this.message = message;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
