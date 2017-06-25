package org.ht.tweet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by cgfu on 10/2/16.
 */
@Getter
@Setter
@Entity
@Table(name = "Search")
public class Search {

    @Id
    @GeneratedValue
    private int idSearch;


    String query;

    @ManyToOne
    @JoinColumn(name = "accountForeign")
    Account account;

    public Search(){

    }

    public Search(Account account, String string){
        this.query = string;
        this.account = account;
        account.getSearches().add(this);
    }
}
