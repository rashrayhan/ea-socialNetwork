package edu.mum.ea.services.impl;

import edu.mum.ea.models.Follow;
import edu.mum.ea.models.User;
import edu.mum.ea.repos.FollowRepository;
import edu.mum.ea.repos.UserRepository;
import edu.mum.ea.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@PreAuthorize("isAuthenticated()")
public class FollowServiceImpl implements FollowService {

    private FollowRepository followRepository;
    private UserRepository userRepository;

    @Autowired
    public FollowServiceImpl(FollowRepository followRepository, UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    @Secured("ROLE_FOLLOW_PRIVILEGE")
    @Override
    public Follow save(Follow follow) {
        follow.setActivityTime(LocalDateTime.now());
        return followRepository.save(follow);
    }

    @Override
    public Follow update(Follow follow) {
        return null;
    }

    @Secured("ROLE_FOLLOW_PRIVILEGE")
    @Override
    public boolean delete(Follow follow) {
        followRepository.delete(follow);
        return true;
    }

    @Override
    public Follow findById(Long id) {
        return null;
    }

    @Override
    public List<Follow> findAll() {
        return null;
    }

    @Override
    public List<User> whoToFollow(User user) {
        List<User> users = (List<User>) userRepository.findAll();
        List<User> followings = whoIFollow(user);
        return users.stream()
                .filter(u -> followings.stream().noneMatch(f -> f.getUsername().equals(u.getUsername())) &&
                        !u.getUsername().equals(user.getUsername()) &&
                        u.getRoles().stream().noneMatch(r -> r.getName().equalsIgnoreCase("ROLE_ADMIN")))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> whoFollowsMe(User user) {
        return followRepository.peopleWhoFollowMe(user);
    }

    @Override
    public List<User> whoIFollow(User user) {
        return followRepository.peopleIFollow(user);
    }

    @Override
    public List<String> stringListOfMyFollowers(User user) {
        return followRepository.stringListOfMyFollowers(user);
    }

    @Override
    public Follow findByFollowingUserAndUser(User followingUser, User user) {
        return followRepository.findByFollowingUserAndUser(followingUser, user);
    }

    @Override
    public Follow findByUserAndFollowingUser(User user, User followingUser) {
        return followRepository.findByUserAndFollowingUser(user, followingUser);
    }
}
