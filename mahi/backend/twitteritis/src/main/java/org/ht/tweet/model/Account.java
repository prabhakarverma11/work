package org.ht.tweet.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import org.hibernate.mapping.List;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.ht.tweet.enums.AccountType;
import twitter4j.auth.AccessToken;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cgfu on 9/22/16.
 */
@Getter
@Setter
@Entity
@Table(name="Account")
public class Account {

    @Id
    @GeneratedValue
    private Integer accountId;

    private String accessToken;

    private String accessTokenSecret;


    @Enumerated(EnumType.STRING)
    private AccountType type;


    @OneToOne
    @JoinColumn(name = "userForeign")
    User user;

    @OneToOne(mappedBy = "account" ,cascade = CascadeType.ALL)
    UserProfile userProfile;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account", cascade = CascadeType.ALL)
//    @Fetch(value = FetchMode.SUBSELECT)
    private List<Tweet> tweets;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account", cascade = CascadeType.ALL)
//    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Search> searches;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account", cascade = CascadeType.ALL)
    private Set<message> messages;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenSecret='" + accessTokenSecret + '\'' +
                ", type=" + type +
//                ", user=" + user +
                ", userProfile=" + userProfile +
                ", tweets=" + tweets +
                ", searches=" + searches +
                '}';
    }

    public  Account(){

    }

    public Account(User user, AccessToken accessToken){
//        this.setAccountId(user.getId());
        this.setAccessToken(accessToken.getToken());
        this.setAccessTokenSecret(accessToken.getTokenSecret());
        this.setUser(user);
        this.tweets = new ArrayList<Tweet>();
        this.searches = new HashSet<Search>();
        this.messages = new HashSet<message>();
        user.setAccount(this);


    }

}
