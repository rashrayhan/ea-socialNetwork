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
    public Object save(Object object) {
        Post post = (Post) object;
        return postRepository.save(post);
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
