package com.aidar.data;

import com.aidar.vkapi.UserInf;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private boolean isNewUser(UserInf userInf) {
        Query query = entityManager.createQuery("select u from User u where u.id= :id");
        query.setParameter("id", userInf.getId());
        List<User> users = query.getResultList();
        return users.isEmpty();
    }

    @Override
    public Integer addUser(UserInf userInf) {
        String sex = null;
        if (isNewUser(userInf)) {
            if (userInf.getSex() == 2)
                sex = "male";
            else
                sex = "female";
            entityManager.persist(new User(userInf.getId(), userInf.getFirstName(), userInf.getLastName(),
                    sex, userInf.getCity().getTitle(), userInf.getMobilePhone()));
        }
        return userInf.getId();
    }

    @Override
    public List<User> getUsers(Integer id) {
        Query query = entityManager.createQuery("select u from User u where u.id not like :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

}
