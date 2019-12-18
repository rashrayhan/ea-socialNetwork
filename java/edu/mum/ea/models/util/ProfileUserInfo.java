package edu.mum.ea.models.util;

import edu.mum.ea.models.User;

public class ProfileUserInfo {
    private User user;
    private int followings;
    private int followers;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFollowings() {
        return followings;
    }

    public void setFollowings(int followings) {
        this.followings = followings;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
