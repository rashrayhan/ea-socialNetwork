package edu.mum.ea.services.impl;

import edu.mum.ea.models.Post;
import edu.mum.ea.services.AsyncMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
//import static edu.mum.ea.config.ArtemisConfig.TOPICS;

@Service
public class AsyncMessagingServiceImpl implements AsyncMessagingService {

    private JmsTemplate jms;

    @Autowired
    public AsyncMessagingServiceImpl(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void notifyFollowersAboutNewPost(Post post) {
        //jms.convertAndSend(TOPICS[0], post);
    }
}
