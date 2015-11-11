package com.aidar.repository.impl;

import com.aidar.model.Message;
import com.aidar.model.User;
import com.aidar.repository.MessageRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
public class MessageRepositoryImpl implements MessageRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Message> getMessages(User user1, User user2) {
        Query query = entityManager.createQuery("select m from Message m where m.user1= :user1 and m.user2= :user2 or m.user1= :user2 and m.user2= :user1 order by m.date");
        query.setParameter("user1", user1);
        query.setParameter("user2", user2);
        return query.getResultList();
    }

    @Override
    public void updateMessages(User user1, User user2) {
        Query query = entityManager.createQuery("update Message m set m.isNew= :isNew where m.user1= :user1 and m.user2= :user2 and m.isNew= :isOld");
        query.setParameter("user1", user1);
        query.setParameter("user2", user2);
        query.setParameter("isNew", false);
        query.setParameter("isOld", true);
        query.executeUpdate();
    }

}
