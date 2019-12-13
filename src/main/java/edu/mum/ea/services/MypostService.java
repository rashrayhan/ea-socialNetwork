package edu.mum.ea.services;

import edu.mum.ea.models.Post;

import java.util.List;

public interface MypostService {

    public List<Post> getAll();



    public Post save(Post post);

    public Post find(Long id);
}
