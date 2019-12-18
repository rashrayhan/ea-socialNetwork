package edu.mum.ea.services;

import edu.mum.ea.models.User;

public interface UserService extends GenericService<User> {

    public User findByUsername(String username);

}
