package com.aidar.repository;

import com.aidar.model.Like;
import com.aidar.model.Post;
import com.aidar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long>, LikeRepositoryCustom {

    public Like findByUserAndPost(User user, Post post);

}
