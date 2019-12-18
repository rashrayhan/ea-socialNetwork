package edu.mum.ea.services.impl;

import edu.mum.ea.models.Media;
import edu.mum.ea.models.MediaType;
import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;
import edu.mum.ea.repos.FilthyRepository;
import edu.mum.ea.repos.FollowRepository;
import edu.mum.ea.repos.PostRepository;
import edu.mum.ea.services.PostService;
import edu.mum.ea.services.util.MediaUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@PropertySource("classpath:application.properties")
@PreAuthorize("isAuthenticated()")
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private FilthyRepository filthyRepository;
    private FollowRepository followRepository;
    private ServletContext servletContext;
    @Value("${url.pictures}")
    private String pictureUploadSubFolder;
    @Value("${url.videos}")
    private String videoUploadSubFolder;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ServletContext servletContext,
                           FilthyRepository filthyRepository, FollowRepository followRepository) {
        this.postRepository = postRepository;
        this.servletContext = servletContext;
        this.filthyRepository = filthyRepository;
        this.followRepository = followRepository;
    }

    @Secured("ROLE_POST_PRIVILEGE")
    @Override
    public Post save(Post post) {
        StringBuilder fileNames = new StringBuilder();
        post.setActivityTime(LocalDateTime.now());
        post.setHasFilthyWord(containsFilthyWord(post.getContent(), fileNames.toString(), filthyRepository.getAllAsListOfNames()));
        post = postRepository.save(post);
        if (post.getPicture() != null && !post.getPicture().isEmpty()) {
            Media media = new Media();
            fileNames.append(" ").append(post.getPicture().getOriginalFilename());
            media.setPost(post);
            media.setFilePath(post.getPicture().getOriginalFilename());
            post.getMediaItems().add(media);
            media.setMediaType(MediaType.Image);
            addMediaFile(post.getPicture(), MediaType.Image);
        }
        if (post.getVideo() != null && !post.getVideo().isEmpty()) {
            Media media = new Media();
            media.setPost(post);
            fileNames.append(" ").append(post.getVideo().getOriginalFilename());
            media.setFilePath(post.getVideo().getOriginalFilename());
            post.getMediaItems().add(media);
            media.setMediaType(MediaType.Video);
            addMediaFile(post.getVideo(), MediaType.Video);
        }
        return post;
    }

    @Secured("ROLE_POST_PRIVILEGE")
    private void addMediaFile(MultipartFile media, MediaType mediaType) {
        File folder;
        if (mediaType.equals(MediaType.Image)) {
            folder = new File(servletContext.getRealPath("/") + pictureUploadSubFolder);
        } else {
            folder = new File(servletContext.getRealPath("/") + videoUploadSubFolder);
        }

        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(folder.getPath() + "/" + media.getOriginalFilename()));
            bos.write(media.getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
            throw new MediaUploadException(e.getMessage());
        }
    }

    @Secured("ROLE_POST_PRIVILEGE")
    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Secured({"ROLE_POST_PRIVILEGE", "ROLE_USER_MANAGEMENT_PRIVILEGE"})
    @Override
    public boolean delete(Post post) {
        postRepository.delete(post);
        return true;
    }

    @Override
    public Post findById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    private boolean containsFilthyWord(String content, String fileNames, List<String> words) {
        if (words != null) {
            return words.stream().
                    anyMatch(w -> (content != null && content.contains(w)) || (fileNames != null && fileNames.contains(w)));
        }
        return false;
    }

    @Secured("ROLE_TIMELINE_PRIVILEGE")
    @Override
    public List<Post> getTimelinePosts(User user, int pageNumber) {
        List<User> followings = followRepository.peopleIFollow(user);
        return recentPostsByFollowings(followings, pageNumber);
    }

    @Secured("ROLE_TIMELINE_PRIVILEGE")
    @Override
    public List<Post> recentPostsByFollowings(List<User> followings, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return postRepository.findAllByUserInOrderByActivityTimeDesc(followings, pageable);
    }

    @Secured("ROLE_PROFILE_PRIVILEGE")
    @Override
    public List<Post> recentPostsByUser(User user, int pageNumber)
    {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return postRepository.findAllByUserOrderByActivityTimeDesc(user, pageable);
    }

    @Override
    public List<Post> findAllByHasFilthyWordTrue() {
        return postRepository.findAllByHasFilthyWordTrue();
    }
}
