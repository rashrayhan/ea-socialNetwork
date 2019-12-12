package edu.mum.ea.services.impl;

import edu.mum.ea.models.Post;
import edu.mum.ea.repos.PostRepository;
import edu.mum.ea.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
 public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
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



//
//    @Override
//    public List<Post> allpost() {
//        return postRepository.allpost();
//    }
}
