package edu.mum.ea.services.impl;

import edu.mum.ea.models.Post;
import edu.mum.ea.repos.MYPostRepository;
import edu.mum.ea.services.MypostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class MypostserviceImp implements MypostService {

                @Autowired
            MYPostRepository myPostRepository;

    @Override
    public List<Post> getAll() {
        return (List<Post>) myPostRepository.findAll();
    }



    @Override
    public Post save(Post post) {
        return myPostRepository.save(post);
    }

    @Override
    public Post find(Long id) {
        return null;
    }
}
