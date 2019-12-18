package edu.mum.ea.repos;

import edu.mum.ea.models.Advert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends CrudRepository<Advert, Long> {


}
