package com.aidar.repository;

import com.aidar.model.Post;

public interface PostRepositoryCustom {

    public void addLike(Post post);

    public void removeLike(Post post);

}
