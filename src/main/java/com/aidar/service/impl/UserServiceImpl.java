package com.aidar.service.impl;

import com.aidar.repository.UserRepository;
import com.aidar.model.User;
import com.aidar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void updateUser(Long id, String fName, String lName, Integer sex, String city, String mobile) {
        User user = getUser(id);
        userRepository.updateUser(user, fName, lName, sex, city, mobile);
    }

    @Override
    public List<User> getUsers(User user, List<User>[] lists) {
        List<User> allUsers = (List<User>) userRepository.findAll();
        allUsers.remove(user);
        for (List<User> l : lists) {
            allUsers.removeAll(l);
        }
        return allUsers;
    }

}
