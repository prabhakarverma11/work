package org.ht.tweet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import twitter4j.auth.AccessToken;

import javax.persistence.*;

/**
 * Created by cgfu on 9/28/16.
 */
@Getter
@Setter
@Entity
@Table(name="User")
public class User {

    @Id @GeneratedValue
    private int id;

    private String username;
    private String password;

    @OneToOne( mappedBy = "user" ,cascade = CascadeType.ALL)
    Account account;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                '}';
    }
}
