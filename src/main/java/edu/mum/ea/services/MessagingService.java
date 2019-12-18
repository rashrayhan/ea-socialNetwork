package edu.mum.ea.services;

import edu.mum.ea.models.Post;

import java.util.List;

public interface MessagingService {

    void notifyFollowers(Post post, List<String> users);

}
