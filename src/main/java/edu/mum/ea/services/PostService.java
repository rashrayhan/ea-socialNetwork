package edu.mum.ea.services;

import edu.mum.ea.models.FilthyWord;
import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;

import java.util.List;

public interface PostService extends GenericService<Post> {

<<<<<<< HEAD
    List<Post> getTimelinePosts(User user);
    List<Post> recentPostsByFollowings(List<User> followings);
    List<Post> recentPostsByUser(User user);
    List<Post> findAllByHasFilthyWordTrue();

=======
    List<Post> getTimelinePosts(User user, int startElement);
    List<Post> recentPostsByFollowings(List<User> followings, int startElement);
    List<Post> recentPostsByUser(User user, int startElement);
    List<Post> findAllByHasFilthyWordTrue();
>>>>>>> 73b8fb914823120babe0685d92a792cc1cc4ecd7

}
