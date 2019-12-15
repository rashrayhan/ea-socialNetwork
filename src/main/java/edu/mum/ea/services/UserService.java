package edu.mum.ea.services;


import edu.mum.ea.models.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService extends GenericService<User> {

public String editProfilePicture(MultipartFile file);
}
