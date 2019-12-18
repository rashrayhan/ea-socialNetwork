package edu.mum.ea.services.impl;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.util.NotificationTemplate;
import edu.mum.ea.services.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessagingService {

    private SimpMessageSendingOperations messaging;

    @Autowired
    public MessageServiceImpl(SimpMessageSendingOperations messaging) {
        this.messaging = messaging;
    }

    @Override
    public void notifyFollowers(Post post, List<String> users) {
        System.out.println("\n\n\n\n+++++++++++++++++++++" + users + "\n\n\n");
        if(users != null) {
            NotificationTemplate template = new NotificationTemplate();
            template.setMessage(post.getUser().getUsername() + " has a new post!");
            for(String username : users) {
                messaging.convertAndSendToUser(username,"/queue/post-notification", template);
            }
        }
    }
}
