package edu.mum.ea.services.impl;

import edu.mum.ea.models.Media;
import edu.mum.ea.models.Post;
import edu.mum.ea.repos.FilthyRepository;
import edu.mum.ea.repos.PostRepository;
import edu.mum.ea.services.PostService;
import edu.mum.ea.services.util.MediaUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private FilthyRepository filthyRepository;
    private ServletContext servletContext;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ServletContext servletContext, FilthyRepository filthyRepository) {
        this.postRepository = postRepository;
        this.servletContext = servletContext;
        this.filthyRepository = filthyRepository;
    }

    @Override
    public Post save(Post post) {
        StringBuilder fileNames = new StringBuilder();
        if(post.getMediaItems() != null) {
            File folder = new File(servletContext.getRealPath("/") + "/media/");
            if(!folder.exists()) {
                folder.mkdirs();
            }
            for(Media media : post.getMediaItems()) {
                fileNames.append(" ").append(media.getMultipartFile().getOriginalFilename());
                media.setFilePath(folder.getPath() + media.getMultipartFile().getOriginalFilename());
                addMediaFile(media);
            }
        }
        post.setActivityTime(LocalDateTime.now());
        post.setHasFilthyWord(containsFilthyWord(post.getContent(), fileNames.toString(), filthyRepository.getAllAsListOfNames()));
        return postRepository.save(post);
    }

    private void addMediaFile(Media media) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(media.getFilePath()));
            bos.write(media.getMultipartFile().getBytes());
            bos.flush();
            bos.close();
        } catch (Exception e) {
            throw new MediaUploadException(e.getMessage());
        }
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public boolean delete(Post post) {
        return false;
    }

    @Override
    public Post findById(Long id) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    private boolean containsFilthyWord(String content, String fileNames, List<String>words) {
        if(words != null) {
            return words.stream().
                    anyMatch(w -> (content != null && content.contains(w)) || (fileNames != null && fileNames.contains(w)));
        }
        return false;
    }
}
