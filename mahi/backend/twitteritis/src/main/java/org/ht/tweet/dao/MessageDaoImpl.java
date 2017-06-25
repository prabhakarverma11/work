package org.ht.tweet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ht.tweet.model.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by cgfu on 10/3/16.
 */
@Repository
public class MessageDaoImpl implements MessageDao {
    @Autowired
    SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    public void deleteMessage(message message) {
        getCurrentSession().delete(message);

    }

    public void updateMessage(message message) {
        getCurrentSession().update(message);
    }

    public void saveMessage(message message) {
        getCurrentSession().save(message);
    }

    public message findMessageByMessage(String mess) {
        message message = (org.ht.tweet.model.message) getCurrentSession().createCriteria(org.ht.tweet.model.message.class).add(Restrictions.eq("mes",mess)).uniqueResult();
        return message;
    }
}
