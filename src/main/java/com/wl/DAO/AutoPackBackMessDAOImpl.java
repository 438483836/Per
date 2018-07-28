package com.wl.DAO;

import com.wl.entity.AutoPackBackMess;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vincent on 2018-07-18.
 */
@Repository
public class AutoPackBackMessDAOImpl implements AutoPackBackMessDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public int save(AutoPackBackMess autoPackBackMess) {

        return (Integer) sessionFactory.getCurrentSession().save(autoPackBackMess);
    }
}
