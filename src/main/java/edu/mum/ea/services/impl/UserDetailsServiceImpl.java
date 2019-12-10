package edu.mum.ea.services.impl;

import edu.mum.ea.models.Privilege;
import edu.mum.ea.models.Role;
import edu.mum.ea.models.User;
import edu.mum.ea.repos.RoleRepository;
import edu.mum.ea.repos.UserRepository;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), user.isEnabled(),
                    user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                    user.isAccountNonLocked(), getUserAuthorities(user.getRoles())
            );
        } else {
            return new org.springframework.security.core.userdetails.User(
                    "", "", true,
                    true, true, true,
                    getUserAuthorities(Collections.singletonList(roleRepository.findByName("ROLE_USER")))
            );
        }
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    private Collection<? extends GrantedAuthority> getUserAuthorities(List<Role>roles) {
        return getUserGrantedAuthorities(privileges(roles));
    }

    public List<String> privileges(List<Role>roles) {
        return roles.stream()
                .flatMap(role -> role.getPrivileges().stream())
                .map(Privilege::getName)
                .collect(Collectors.toList());
    }

    private Collection<GrantedAuthority> getUserGrantedAuthorities(List<String> privileges) {
        return privileges.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
