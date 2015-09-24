package com.aidar.data;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class FriendsDAOImpl implements FriendsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Friends> getFriends(Integer id) {
        Query query = entityManager.createQuery("select f from Friends f where f.firstId= :id or f.secondId= :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void addFriends(Integer sId, Integer rId) {
        entityManager.persist(new Friends(sId, rId));
    }

    @Override
    public void removeFriends(Integer sId, Integer rId) {
        Query query = entityManager.createQuery("delete from Friends f where f.firstId= :sId and f.secondId= :rId or f.firstId= :rId and f.secondId= :sId");
        query.setParameter("sId", sId);
        query.setParameter("rId", rId);
        query.executeUpdate();
    }

}
