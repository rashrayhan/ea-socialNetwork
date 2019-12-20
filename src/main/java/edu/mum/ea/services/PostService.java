package edu.mum.ea.services;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;

import java.util.List;

public interface PostService extends GenericService<Post> {
    List<Post> getTimelinePosts(User user, int startElement);
    List<Post> recentPostsByFollowings(List<User> followings, int startElement);
    List<Post> recentPostsByUser(User user, int startElement);
    List<Post> findAllByHasFilthyWordTrue();

}
