package edu.mum.ea.repos;

import edu.mum.ea.models.Follow;
import edu.mum.ea.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends CrudRepository<Follow, Long> {


    @Query("select f.followingUser from Follow f where" +
            " f.user = ?1")
    List<User> peopleIFollow(User user);

    @Query("select f.user from Follow f where" +
            " f.followingUser = ?1")
    List<User> peopleWhoFollowMe(User user);

}