package org.ht.tweet.service;

import org.ht.tweet.model.Search;

/**
 * Created by cgfu on 10/2/16.
 */
public interface SearchService {
    void updateSearch(Search search);
    void deleteSearch(Search search);
    void saveSearch(Search search);
    Search findSearchBySearch(String search);

}
