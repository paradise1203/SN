package com.aidar.repository.impl;

import com.aidar.model.Post;
import com.aidar.repository.PostRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class PostRepositoryImpl implements PostRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addLike(Post post) {
        post.setRating(post.getRating() + 1);
        post = entityManager.merge(post);
        post.setRating(post.getRating() + 1);
    }

    @Override
    public void removeLike(Post post) {
        post.setRating(post.getRating() - 1);
        post = entityManager.merge(post);
        post.setRating(post.getRating() - 1);
    }

}
