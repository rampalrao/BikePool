package com.bikepool.dao.impl;

import com.bikepool.dao.GenericRepository;
import com.bikepool.dao.Identifiable;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by rampal on 13/11/17.
 */
public class SimpleGenericRepository<T extends Identifiable> implements GenericRepository<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findBySqlQuery(String sqlQuery) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
        List<T> result = query.list();
        return result;
    }

    @Override
    public T save(T entity) {
        return (T)sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public List save(Iterable entities) {
        return null;
    }

    @Override
    public void delete(Iterable entities) {

    }
}
