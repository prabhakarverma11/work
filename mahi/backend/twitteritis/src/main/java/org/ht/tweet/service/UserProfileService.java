package org.ht.tweet.service;

import org.ht.tweet.model.UserProfile;

/**
 * Created by cgfu on 9/29/16.
 */
public interface UserProfileService {

    UserProfile getUserProfileByUserName(String userName);
    UserProfile getUserProfileByScreenName(String screenName);
    void saveUserProfile(UserProfile userProfile);
    void updateUserProfile(UserProfile userProfile);
    void deleteUserProfile(UserProfile userProfile);
}
