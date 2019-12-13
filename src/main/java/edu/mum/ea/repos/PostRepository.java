package edu.mum.ea.repos;

import edu.mum.ea.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

//
//          @Query("select p from Post ")
//         List<Post>allpost();
//
//          @Query("select p from Post where id=id")
//          Post findbyid(long id);


}
