package edu.mum.ea.services;

import edu.mum.ea.models.Post;

public interface AsyncMessagingService {

    void notifyFollowersAboutNewPost(Post post);

}
