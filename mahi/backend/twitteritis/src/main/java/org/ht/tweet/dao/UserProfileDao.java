package org.ht.tweet.dao;

import org.ht.tweet.model.Account;
import org.ht.tweet.model.User;
import org.ht.tweet.model.UserProfile;

/**
 * Created by cgfu on 9/22/16.
 */
public interface UserProfileDao {

    UserProfile getUserProfileByUserName(String userName);
    UserProfile getUserProfileByScreenName(String screenName);
    void saveUserProfile(UserProfile userProfile);
    void updateUserProfile(UserProfile userProfile);
    void deleteUserProfile(UserProfile userProfile);

}
