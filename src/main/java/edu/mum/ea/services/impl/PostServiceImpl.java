package edu.mum.ea.services.impl;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.PostItem;
import edu.mum.ea.repos.PostItemRepository;

import edu.mum.ea.services.PostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostItemService {

         @Autowired
             PostItemRepository postItemRepository;



    @Override
    public PostItem savepost(PostItem posts) {
        return postItemRepository.save(posts);
    }
}

