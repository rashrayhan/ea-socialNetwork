package edu.mum.ea.repos;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByUserOrderByActivityTimeDesc(User user);

    @Query("select p from Post p order by p.activityTime desc")
    List<Post> findAllByActivityTimeDesc();

    List<Post> findAllByHasFilthyWordTrue();

}
