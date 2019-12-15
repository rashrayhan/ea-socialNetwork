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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@PropertySource("classpath:application.properties")
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

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public boolean delete(Post post) {


        postRepository.delete(post);

        return true;


    }

    @Override
    public Post findById(Long id) {
        return null;
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

    @Override
    public List<Post> getTimelinePosts(User user) {
        List<User> followings = followRepository.peopleIFollow(user);
        return recentPostsByFollowings(followings);
    }

    @Override
    public List<Post> recentPostsByFollowings(List<User> followings) {
        List<Post> posts = postRepository.findAllByActivityTimeDesc();
        return posts.stream()
                .filter(post -> followings.stream().anyMatch(user -> user.getUsername().equals(post.getUser().getUsername())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> recentPostsByUser(User user) {
        return postRepository.findAllByUserOrderByActivityTimeDesc(user);
    }
}
