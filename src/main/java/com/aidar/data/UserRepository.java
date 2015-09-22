package com.aidar.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>, UserRepositoryCustom {

    public User findById(Integer id);

}
