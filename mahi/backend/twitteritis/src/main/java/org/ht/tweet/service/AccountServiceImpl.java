package org.ht.tweet.service;

import org.ht.tweet.dao.AccountDao;
import org.ht.tweet.dao.AccountDaoImpl;
import org.ht.tweet.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 9/29/16.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    public Account findAccountByAccessToken(String accessToken) {
        return accountDao.findAccountByAccessToken(accessToken);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);

    }

    public void deleteAccount(Account account) {

        accountDao.deleteAccount(account);
    }

    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }
}
