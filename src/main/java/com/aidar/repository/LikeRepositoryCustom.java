package com.aidar.repository;

import com.aidar.model.Post;
import com.aidar.model.User;

public interface LikeRepositoryCustom {

    public void removeLike(User user, Post post);

}
