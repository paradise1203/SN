package com.aidar.repository;

import com.aidar.model.Friendship;
import com.aidar.model.User;

public interface FriendshipRepositoryCustom {

    public void updateFriendship(Friendship friendship);

    public void removeFriendship(User user1, User user2);

}
