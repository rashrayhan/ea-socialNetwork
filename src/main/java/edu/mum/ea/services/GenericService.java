package edu.mum.ea.services;

import java.util.List;

public interface GenericService<T> {

    T save(T t);

    T update(T t);

    boolean delete(T t);

    T findById(Long id);

    List<T> findAll();

}
