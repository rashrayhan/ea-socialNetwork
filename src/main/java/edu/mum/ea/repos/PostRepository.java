package edu.mum.ea.repos;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByUserOrderByActivityTimeDesc(User user, Pageable pageable);

    List<Post> findAllByUserInOrderByActivityTimeDesc(List<User>followings, Pageable pageable);

}
