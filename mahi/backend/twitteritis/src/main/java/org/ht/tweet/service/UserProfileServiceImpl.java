package org.ht.tweet.service;

import org.ht.tweet.dao.UserProfileDao;
import org.ht.tweet.dao.UserProfileDaoImpl;
import org.ht.tweet.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 9/29/16.
 */
@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileDao userProfileDao;

    public UserProfile getUserProfileByUserName(String userName) {
        return userProfileDao.getUserProfileByUserName(userName);
    }

    public UserProfile getUserProfileByScreenName(String screenName) {
        return userProfileDao.getUserProfileByScreenName(screenName);

    }

    public void saveUserProfile(UserProfile userProfile) {

        userProfileDao.saveUserProfile(userProfile);
    }

    public void updateUserProfile(UserProfile userProfile) {

        userProfileDao.updateUserProfile(userProfile);
    }

    public void deleteUserProfile(UserProfile userProfile) {

        userProfileDao.deleteUserProfile(userProfile);
    }
}
