package org.ht.tweet.dao;

import org.ht.tweet.model.Account;

/**
 * Created by cgfu on 9/22/16.
 */
public interface AccountDao {

//    Account findAccountByUserName(String userName);
    Account findAccountByAccessToken(String accessToken);
    void saveAccount(Account account);
    void deleteAccount(Account account);
    void updateAccount(Account account);
    Account findAccountById(int id);
}