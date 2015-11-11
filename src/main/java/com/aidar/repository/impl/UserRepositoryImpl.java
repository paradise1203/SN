package com.aidar.repository.impl;

import com.aidar.model.User;
import com.aidar.model.enums.Sex;
import com.aidar.repository.UserRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateUser(User user, String fName, String lName, Integer sex, String city, String mobile) {
        user = entityManager.merge(user);
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setSex(Sex.getSex(sex));
        user.setCity(city);
        user.setMobilePhone(mobile);
    }

}
