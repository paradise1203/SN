package com.aidar.data;

import java.util.List;

public interface FriendsDAO {

    public List<Friends> getFriends(Integer id);

    public void addFriends(Integer sId, Integer rId);

    public void removeFriends(Integer sId, Integer rId);

}
