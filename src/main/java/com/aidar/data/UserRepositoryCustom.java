package com.aidar.data;

import com.aidar.vkapi.UserInf;

import java.util.List;

public interface UserRepositoryCustom {

    public Integer addUser(UserInf userInf);

    public List<User> getUsers(Integer id);

}
