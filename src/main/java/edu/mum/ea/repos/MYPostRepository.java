package edu.mum.ea.repos;

import edu.mum.ea.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MYPostRepository extends CrudRepository<Post,Long> {

//
//    @Query("SELECT p FROM Post p")
//    public List<Post> getAll();
//
//    // if using this INSTEAD of findAll ... selects Phone...based on Join Fetch
//
//    @Query("select p from Post e where p_id = :id")
//    Post findPostBy(@Param("id") long id);

}
