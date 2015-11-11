package com.aidar.repository;

import com.aidar.model.User;

public interface UserRepositoryCustom {

    public void updateUser(User user, String fName, String lName, Integer sex, String city, String mobile);

}
