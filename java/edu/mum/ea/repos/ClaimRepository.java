package edu.mum.ea.repos;

import edu.mum.ea.models.Advert;
import edu.mum.ea.models.Claim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Long> {


}
