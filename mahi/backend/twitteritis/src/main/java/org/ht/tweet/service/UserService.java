package org.ht.tweet.service;

import org.ht.tweet.model.User;

/**
 * Created by cgfu on 9/29/16.
 */
public interface UserService {
    User findUserByUsername(String username);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
