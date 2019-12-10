package edu.mum.ea.repos;

import edu.mum.ea.models.Post;
import edu.mum.ea.models.PostItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostItemRepository extends CrudRepository<PostItem,Long> {


}
