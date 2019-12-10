package edu.mum.ea.services.impl;

import edu.mum.ea.models.User;
import edu.mum.ea.repos.UserRepository;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

     @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user != null) {
            return user;
        }
        throw new UsernameNotFoundException("Invalid User details!");
    }

    @Override
    public Object save(Object object) {
        User user = (User)object;
        return userRepository.save(user);
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }
}
