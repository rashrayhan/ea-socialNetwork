package edu.mum.ea.services;

import java.util.List;

public interface GeneralService {

    Object save(Object object);

    Object update(Object object);

    boolean delete(Object object);

    Object findById(Long id);

    List<Object> findAll();

}
