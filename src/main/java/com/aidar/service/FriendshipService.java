package com.aidar.service;

import com.aidar.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendshipService {

    public List<User>[] getFriends(User user);

    public void addFriendship(User user1, User user2);

    public void approveFriendship(User user1, User user2);

    public void removeFriendship(User user1, User user2);

}
