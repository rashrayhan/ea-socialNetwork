package edu.mum.ea.repos;

import edu.mum.ea.models.Follow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends CrudRepository<Follow, Long> {

}
