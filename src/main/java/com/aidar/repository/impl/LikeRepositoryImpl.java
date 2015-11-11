package com.aidar.repository.impl;

import com.aidar.model.Post;
import com.aidar.model.User;
import com.aidar.repository.LikeRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
public class LikeRepositoryImpl implements LikeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void removeLike(User user, Post post) {
        Query query = entityManager.createQuery("delete from Like l where l.user= :user and l.post= :post");
        query.setParameter("user", user);
        query.setParameter("post", post);
        query.executeUpdate();
    }

}
