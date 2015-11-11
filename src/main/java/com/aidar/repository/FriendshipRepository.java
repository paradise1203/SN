package com.aidar.repository;

import com.aidar.model.Friendship;
import com.aidar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepository extends CrudRepository<Friendship, Long>, FriendshipRepositoryCustom {

    public List<Friendship> findByUser1OrUser2(User user1, User user2);

    public Friendship findByUser1AndUser2(User user1, User user2);

}
