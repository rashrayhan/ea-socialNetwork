package edu.mum.ea.services;

import edu.mum.ea.models.Follow;
import edu.mum.ea.models.User;

import java.util.List;

public interface FollowService extends GenericService<Follow> {

    List<User> whoToFollow(User user);

    List<User> whoFollowsMe(User user);

    List<User> whoIFollow(User user);

    List<String>stringListOfMyFollowers(User user);

    Follow findByFollowingUserAndUser(User followingUser, User user);

    Follow findByUserAndFollowingUser(User user, User followingUser);

}
