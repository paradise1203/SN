package com.aidar.repository;

import com.aidar.model.Message;
import com.aidar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>, MessageRepositoryCustom {

    public List<Message> findByUser1AndUser2AndIsNew(User user1, User user2, boolean isNew);

}
