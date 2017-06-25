package org.ht.tweet.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ht.tweet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 9/29/16.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getCurrentSession(){
            return sessionFactory.getCurrentSession();
    }


    public User findUserByUsername(String username) {
        User user = (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
        return user;
    }


    public void saveUser(User user) {
        getCurrentSession().save(user);
    }

    public void deleteUser(User user) {
        if(user != null)
            getCurrentSession().delete(user);
    }

    public void updateUser(User user) {
        getCurrentSession().update(user);

    }
}
