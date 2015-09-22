package com.aidar.data;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class MessageDAOImpl implements MessageDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Message> getMessages(Integer sId, Integer rId) {
        Query query = entityManager.createQuery("select m from Message m where m.senderId= :sId and m.recipientId= :rId or m.senderId= :rId and m.recipientId= :sId order by m.date");
        query.setParameter("sId", sId);
        query.setParameter("rId", rId);
        return query.getResultList();
    }

    public void addMessage(Integer sId, Integer rId, String message) {
        entityManager.persist(new Message(sId, rId, message, new Date()));
    }

}
