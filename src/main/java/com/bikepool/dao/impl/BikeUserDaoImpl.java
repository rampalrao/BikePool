package com.bikepool.dao.impl;

import com.bikepool.dao.BikeUserDao;
import com.bikepool.dto.BikeUser;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by rampal on 5/11/17.
 */
@Repository("bikeUserDao")
public class BikeUserDaoImpl implements BikeUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public BikeUser getBikeUser(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("from BikeUser where name = :username");
        query.setParameter("username", username);
        return (BikeUser)query.uniqueResult();
    }
}
