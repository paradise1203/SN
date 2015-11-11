package com.aidar.repository;

import com.aidar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {

    public User findByLogin(String login);

}
