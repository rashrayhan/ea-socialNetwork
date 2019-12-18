package edu.mum.ea.services.impl;

import edu.mum.ea.models.AccountStatus;
import edu.mum.ea.models.User;
import edu.mum.ea.models.util.UserPrincipal;
import edu.mum.ea.repos.UserRepository;
import edu.mum.ea.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@Service
@Transactional
@PropertySource("classpath:application.properties")
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${url.profilepictures}")
    private String profilePictureSubFolder;

    @Autowired
    private ServletContext servletContext;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid user!");
        }
        return new UserPrincipal(user);
    }

    @Override
    public User save(User user) {
        user.setAccountStatus(AccountStatus.Active);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User editUser = userRepository.findById(user.getId()).get();
        if(user.getBiography() != null) {
            editUser.setBiography(user.getBiography());
        }

        if(user.getDateOfBirth() != null) {
            editUser.setDateOfBirth(user.getDateOfBirth());
        }

        if(user.getEmail() != null) {
            editUser.setEmail(user.getEmail());
        }

        if(user.getAddress().getCountry()!= null && user.getAddress().getCity()!= null  && user.getAddress().getZipCode()!= null && user.getAddress().getState()!= null )  {
            editUser.setAddress(user.getAddress());
        }

        if(user.getProfilePhoto() != null) {
            editUser.setProfilePhoto(user.getProfilePhoto());
        }
        return editUser;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public String editProfilePicture(MultipartFile file){
        String fileName = null;
        try {
            File folder = new File(servletContext.getRealPath("/") + profilePictureSubFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            fileName = UUID.randomUUID()+file.getOriginalFilename();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(folder.getPath() + "/" + fileName));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            //throw new MediaUploadException(e.getMessage());
        }
        return fileName;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}


