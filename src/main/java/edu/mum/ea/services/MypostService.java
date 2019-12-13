package edu.mum.ea.services;

import edu.mum.ea.models.Post;

public interface MypostService {

    public Iterable<Post> getAll();



    public Post save(Post post);

    public Post find(Long id);
}
