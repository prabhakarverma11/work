package org.ht.tweet.dao;

import org.ht.tweet.model.Search;

/**
 * Created by cgfu on 10/2/16.
 */
public interface SearchDao {
    void updateSearch(Search search);
    void deleteSearch(Search search);
    void saveSearch(Search search);
    Search findSearchBySearch(String search);
}
