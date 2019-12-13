package edu.mum.ea.repos;

import edu.mum.ea.models.FilthyWord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilthyRepository extends CrudRepository<FilthyWord, Long> {

    @Query(value = "select f.name from FilthyWord f")
    List<String> getAllAsListOfNames();

}
