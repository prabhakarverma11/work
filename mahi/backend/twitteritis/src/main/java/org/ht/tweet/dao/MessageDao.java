package org.ht.tweet.dao;

import org.ht.tweet.model.message;

/**
 * Created by cgfu on 10/3/16.
 */
public interface MessageDao {
    void deleteMessage(message message);
    void updateMessage(message message);
    void saveMessage(message message);
    message findMessageByMessage(String mess);
}
