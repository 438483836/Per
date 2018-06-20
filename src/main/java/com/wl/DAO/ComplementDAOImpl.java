package com.wl.DAO;

import com.wl.entity.Complement;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vincent on 2018-06-19.
 */
@Repository
public class ComplementDAOImpl implements ComplementDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public int save(Complement complement) {

        return (Integer) sessionFactory.getCurrentSession().save(complement);
    }
}
