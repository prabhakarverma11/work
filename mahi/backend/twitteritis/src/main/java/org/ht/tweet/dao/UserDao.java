package org.ht.tweet.dao;

import org.ht.tweet.model.User;

/**
 * Created by cgfu on 9/29/16.
 */
public interface UserDao {


    User findUserByUsername(String username);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
