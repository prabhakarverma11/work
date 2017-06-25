package org.ht.tweet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ht.tweet.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by cgfu on 10/2/16.
 */
@Repository
public class SearchDaoImpl implements SearchDao {

    @Autowired
    SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


    public void updateSearch(Search search) {
        getCurrentSession().update(search);
    }

    public void deleteSearch(Search search) {
        getCurrentSession().delete(search);
    }

    public void saveSearch(Search search) {
        getCurrentSession().save(search);
    }

    public Search findSearchBySearch(String search) {
        Search search1 = (Search) getCurrentSession().createCriteria(Search.class).add(Restrictions.eq("query",search)).uniqueResult();
        return search1;
    }
}
