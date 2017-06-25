package org.ht.tweet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by cgfu on 10/3/16.
 */
@Getter
@Setter
@Entity
@Table(name = "Message")
public class message {

    @Id @GeneratedValue
    private int messageId;

    private String sentToHandle;

    private String mes;

    @ManyToOne
    @JoinColumn(name = "accountForeign")
    Account account;

    public message(){

    }

    public message(Account account, String handle, String mes){
        this.account = account;
        this.mes = mes;
        this.sentToHandle = handle;
        account.getMessages().add(this);
    }
}
