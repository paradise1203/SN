package com.aidar.service.impl;

import com.aidar.model.Friendship;
import com.aidar.model.User;
import com.aidar.repository.FriendshipRepository;
import com.aidar.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipService {

    @Autowired
    @Qualifier("friendshipRepository")
    private FriendshipRepository friendshipRepository;

    @Override
    public List<User>[] getFriends(User user) {
        List<Friendship> friendships = friendshipRepository.findByUser1OrUser2(user, user);
        List<User> friends = new ArrayList<>();
        List<User> usersToApprove = new ArrayList<>();
        List<User> usersToBeApproved = new ArrayList<>();
        for (Friendship f : friendships) {
            if (f.isNew()) {
                if (f.getUser2().equals(user)) {
                    usersToApprove.add(f.getUser1());
                } else {
                    usersToBeApproved.add(f.getUser2());
                }
            } else {
                friends.add(f.getUser1().equals(user) ? f.getUser2() : f.getUser1());
            }
        }
        return new List[]{friends, usersToApprove, usersToBeApproved};
    }

    @Override
    public void addFriendship(User user1, User user2) {
        friendshipRepository.save(new Friendship(user1, user2));
    }

    @Override
    public void approveFriendship(User user1, User user2) {
        Friendship friendship = friendshipRepository.findByUser1AndUser2(user2, user1);
        friendshipRepository.updateFriendship(friendship);
    }

    @Override
    public void removeFriendship(User user1, User user2) {
        friendshipRepository.removeFriendship(user1, user2);
    }

}
