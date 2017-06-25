package org.ht.tweet.service;

import org.ht.tweet.dao.UserDao;
import org.ht.tweet.dao.UserDaoImpl;
import org.ht.tweet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 9/29/16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public void saveUser(User user) {
         userDao.saveUser(user);

    }

    public void deleteUser(User user) {

        userDao.deleteUser(user);
    }

    public void updateUser(User user) {

        userDao.updateUser(user);
    }
}
