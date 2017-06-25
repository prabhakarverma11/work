package org.ht.tweet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by cgfu on 9/28/16.
 */
@Getter
@Setter
@Entity
@Table(name = "Tweets")
public class                Tweet {

    @Id
    @GeneratedValue
    private int idTweet;

    String tweet;

    @ManyToOne
    @JoinColumn(name = "accountForeign")
    Account account;

    public Tweet(Account account, String str){
        this.tweet = str;
        this.account = account;
        account.getTweets().add(this);

    }

    public  Tweet(){

    }

}

