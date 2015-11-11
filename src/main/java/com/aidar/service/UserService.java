package com.aidar.service;

import com.aidar.model.User;

import java.util.List;

public interface UserService {

    public User getUser(Long id);

    public void updateUser(Long id, String fName, String lName, Integer sex, String city, String mobile);

    public List<User> getUsers(User user, List<User>[] lists);

}
