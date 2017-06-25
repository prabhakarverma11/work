package org.ht.tweet.service;

import org.ht.tweet.dao.SearchDao;
import org.ht.tweet.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 10/2/16.
 */
@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchDao searchDao;


    public void updateSearch(Search search) {
        searchDao.updateSearch(search);
    }

    public void deleteSearch(Search search) {
        searchDao.deleteSearch(search);
    }

    public void saveSearch(Search search) {
        searchDao.saveSearch(search);
    }

    public Search findSearchBySearch(String search) {
        return searchDao.findSearchBySearch(search);
    }
}
