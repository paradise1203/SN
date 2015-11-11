package com.aidar.service;

import com.aidar.model.Post;
import com.aidar.model.User;

import java.util.List;

public interface PostService {

    public Post getPost(Long id);

    public List<Post> getPosts(User user);

    public Post addPost(User user, String text);

    public void removePost(String id);

    public void addComment(User user, String text, Post post);

    public Integer toggleLike(User user, Post post);

}
