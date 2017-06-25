package org.ht.tweet.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ht.tweet.model.Account;
import org.ht.tweet.model.User;
import org.ht.tweet.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by cgfu on 9/22/16.
 */
@Repository
public class UserProfileDaoImpl implements UserProfileDao {


    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {



        return sessionFactory.getCurrentSession();

    }

    public UserProfile getUserProfileByUserName(String userName) {
        UserProfile userProfile = (UserProfile) getCurrentSession().createCriteria(UserProfile.class).add(Restrictions.eq("name", userName)).uniqueResult();
        return userProfile;
    }

    public UserProfile getUserProfileByScreenName(String screenName) {
        UserProfile userProfile = (UserProfile) getCurrentSession().createCriteria(UserProfile.class).add(Restrictions.eq("screenName", screenName)).uniqueResult();
        return userProfile;
    }

    public void saveUserProfile(UserProfile userProfile) {
        getCurrentSession().save(userProfile);

    }

    public void updateUserProfile(UserProfile userProfile) {

        getCurrentSession().update(userProfile);
    }

    public void deleteUserProfile(UserProfile userProfile) {
        if(userProfile != null)
        getCurrentSession().delete(userProfile);

    }

}
