package com.aidar.repository.impl;

import com.aidar.model.Friendship;
import com.aidar.model.User;
import com.aidar.repository.FriendshipRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
public class FriendshipRepositoryImpl implements FriendshipRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateFriendship(Friendship friendship) {
        friendship = entityManager.merge(friendship);
        friendship.setNew(false);
    }

    @Override
    public void removeFriendship(User user1, User user2) {
        Query query = entityManager.createQuery("delete from Friendship f where " +
                "f.user1= :user1 and f.user2= :user2 or f.user1= :user2 and f.user2= :user1");
        query.setParameter("user1", user1);
        query.setParameter("user2", user2);
        query.executeUpdate();
    }

}
