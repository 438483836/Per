package com.wl.dao;

import com.wl.entity.DeskBackMess;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vincent on 2018-06-26.
 */
@Repository
public class DeskBackMessDAOImpl implements DeskBackMessDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public int save(DeskBackMess deskBackMess) {
        return (Integer) sessionFactory.getCurrentSession().save(deskBackMess);
    }
}
