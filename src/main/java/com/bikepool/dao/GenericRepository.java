package com.bikepool.dao;

import java.util.List;

/**
 * Created by rampal on 13/11/17.
 */
public interface GenericRepository<T extends Identifiable> {
    List<T> findAll();
    List<T> findBySqlQuery(String sqlQuery);
    T save(T entity);
    List<T> save(Iterable<T> entities);
    void delete (Iterable<T> entities);

}
