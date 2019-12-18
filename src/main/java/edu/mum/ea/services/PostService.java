package edu.mum.ea.services;

import edu.mum.ea.models.FilthyWord;
import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;

import java.util.List;

public interface PostService extends GenericService<Post> {

    List<Post> getTimelinePosts(User user);
    List<Post> recentPostsByFollowings(List<User> followings);
    List<Post> recentPostsByUser(User user);
    List<Post> findAllByHasFilthyWordTrue();


}
