package org.ht.tweet.model;

import lombok.Getter;
import lombok.Setter;
import twitter4j.*;
//import org.hibernate.annotations.*;
//import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by cgfu on 9/22/16.
 */
@Getter
@Setter
@Entity
@Table(name="UserProfile")
public class UserProfile {

    public UserProfile(){

    }

    public UserProfile(twitter4j.User user, Account account){
//        this.setIdUserProfile(account.getAccountId());
        this.setDescription(user.getDescription());
        this.setEmail(user.getEmail());
        this.setFollowersCount(user.getFollowersCount());
        this.setGetCreatedAt(user.getCreatedAt());
        this.setGetFavouritesCount(user.getFavouritesCount());
        this.setScreenName(user.getScreenName());
        this.setGetStatusesCount(user.getStatusesCount());
        this.setLocation(user.getLocation());
        this.setGetTimeZone(user.getTimeZone());
        this.setUserUrl(user.getURL());
        this.setProfileImageUrl(user.getProfileImageURL());
        this.setName(user.getName());
//        this.setFollowersCount(user.getFollowersCount());
        this.setGetFriendsCount(user.getFriendsCount());
        this.setTwitterId(user.getId());
        this.setAccount(account);
        account.setUserProfile(this);
    }

    @Id @GeneratedValue
    private int idUserProfile;
    private long twitterId;
    private String name;
    private String email;
    private String screenName;
    private String location;
    private String description;
//    private boolean contributors;
    private String profileImageUrl;
//    private String miniProfileImageUrl;
//    private String biggerProfileImageUrl;
//    private String originalProfileImageUrl;
//    private boolean defaultProfileImage;
    private String userUrl;
//    private boolean statusProtected;
    private int followersCount;
//    private String profileBackgroundColor;
//    private String profileTextColor;
//    private String profileLinkColor;
//    private String profileSidebarFillColor;
//    private String profileSidebarBorderColor;
//    boolean isProfileUseBackgroundImage;
//    private boolean isDefaultProfile;
//    private boolean isShowAllInlineMedia;
    private int getFriendsCount;
    private int getFavouritesCount;
//    private int getUtcOffset;
    private String getTimeZone;
//    private String getProfileBackgroundImageURL;
//    private String getProfileBannerURL;
//    private String getProfileBannerRetinaURL;
//    private String getProfileBannerIPadURL;
//    private String getProfileBannerIPadRetinaURL;
//    private String getProfileBannerMobileURL;
//    private String getProfileBannerMobileRetinaURL;
//    private boolean isProfileBackgroundTiled;
//    private String getLang;
    private int getStatusesCount;
//    private boolean isGeoEnabled;
//    private boolean isVerifiedCelebrity;
//    boolean isTranslator;
//    private int getListedCount;
//    private boolean isFollowRequestSent;
    private Date getCreatedAt;

    @OneToOne @JoinColumn(name = "accountForeign")
    Account account;

    @Override
    public String toString() {
        return "UserProfile{" +
                "idUserProfile=" + idUserProfile +
                ", twitterId=" + twitterId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", screenName='" + screenName + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", followersCount=" + followersCount +
                ", getFriendsCount=" + getFriendsCount +
                ", getFavouritesCount=" + getFavouritesCount +
                ", getTimeZone='" + getTimeZone + '\'' +
                ", getStatusesCount=" + getStatusesCount +
                ", getCreatedAt=" + getCreatedAt +
                '}';
    }


    //status field  s
//    private Date getCreatedAt;
//    private long getId;
//    private String getText;
//    private String getInReplyToScreenName;
//    private double getGeoLocationlatitude;
//    private String getPlaceName;
//    private String getPlaceStreetAddress;
//    private int getFavoriteCount;
//    private int getRetweetCount;


    //todo add table link for url entity
//    URLEntity[] getDescriptionURLEntities();
//    URLEntity getURLEntity();
//    //todo : remember to convert it to string in the controller as it is a string list otherwise will have to make table
//    private String getWithheldInCountries;



}
