package org.ht.tweet.service;

import org.ht.tweet.dao.MessageDao;
import org.ht.tweet.model.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 10/3/16.
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;


    public void deleteMessage(message message) {
        messageDao.deleteMessage(message);
    }

    public void updateMessage(message message) {
        messageDao.updateMessage(message);
    }

    public void saveMessage(message message) {
        messageDao.saveMessage(message);
    }

    public message findMessageByMessage(String mess) {

        return messageDao.findMessageByMessage(mess);
    }
}
