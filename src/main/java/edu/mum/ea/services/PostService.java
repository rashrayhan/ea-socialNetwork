package edu.mum.ea.services;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;

import java.util.List;

public interface PostService extends GenericService<Post> {

    public List<Post> getTimelinePosts(User user);

}
