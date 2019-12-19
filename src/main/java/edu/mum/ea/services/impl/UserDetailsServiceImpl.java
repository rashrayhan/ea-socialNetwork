package edu.mum.ea.services.impl;

import edu.mum.ea.models.*;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.repos.RoleRepository;
import edu.mum.ea.repos.UserRepository;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid user!");
        }
        return new UserPrincipal(user);
    }

    @PreAuthorize("isAnonymous()")
    @Override
    public User save(User user) {
        user.setAccountStatus(AccountStatus.Active);
        user = userRepository.save(user);
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return user;
    }

    @PreAuthorize("isAuthenticated()")
    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        userRepository.delete(user);
        return true;
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}


