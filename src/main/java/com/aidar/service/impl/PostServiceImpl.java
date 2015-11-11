package com.aidar.service.impl;

import com.aidar.model.Comment;
import com.aidar.model.Like;
import com.aidar.model.Post;
import com.aidar.model.User;
import com.aidar.repository.CommentRepository;
import com.aidar.repository.LikeRepository;
import com.aidar.repository.PostRepository;
import com.aidar.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    @Qualifier("postRepository")
    private PostRepository postRepository;

    @Autowired
    @Qualifier("commentRepository")
    private CommentRepository commentRepository;

    @Autowired
    @Qualifier("likeRepository")
    private LikeRepository likeRepository;

    @Override
    public Post getPost(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public List<Post> getPosts(User user) {
        List<Post> posts = (List<Post>) postRepository.findAll();
        Collections.sort(posts, (Object o1, Object o2) -> {
            Post post1 = (Post) o1;
            Post post2 = (Post) o2;
            int res = post1.getDate().compareTo(post2.getDate());
            return -res;
        });
        return posts;
    }

    @Override
    public Post addPost(User user, String text) {
        Post post = new Post(text, new Date(), user);
        postRepository.save(post);
        return post;
    }

    @Override
    public void removePost(String id) {
        postRepository.delete(Long.parseLong(id));
    }

    @Override
    public void addComment(User user, String text, Post post) {
        commentRepository.save(new Comment(text, new Date(), user, post));
    }

    @Override
    public Integer toggleLike(User user, Post post) {
        if (likeRepository.findByUserAndPost(user, post) != null) {
            likeRepository.removeLike(user, post);
            postRepository.removeLike(post);
            return post.getRating();
        } else {
            likeRepository.save(new Like(post, user));
            postRepository.addLike(post);
            return post.getRating();
        }
    }

}
