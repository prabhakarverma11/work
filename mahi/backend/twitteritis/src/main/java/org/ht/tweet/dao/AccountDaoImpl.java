package org.ht.tweet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ht.tweet.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 9/22/16.
 */
@Repository
public class AccountDaoImpl implements AccountDao {


    @Autowired
    private SessionFactory sessionFactory;



    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Account findAccountByAccessToken(String accessToken) {

        Account account = (Account) getCurrentSession().get(Account.class, accessToken);
        return account;
    }

    public void saveAccount(Account account) {
        getCurrentSession().save(account);

    }


    public void deleteAccount(Account account) {
        if(account != null)
            getCurrentSession().delete(account);


    }

    public void updateAccount(Account account) {
        getCurrentSession().update(account);
    }

    public Account findAccountById(int id) {
        Account account = (Account) getCurrentSession().get(Account.class, id);
        return account;
    }
}
