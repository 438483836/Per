package com.wl.dao;

import com.wl.entity.Complement;
import org.hibernate.Query;
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

    public int saveSlogan(String barCode, String slogan) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Complement set slogan =:slogan where barCode =:barCode");
        query.setParameter("barCode",barCode);
        query.setParameter("slogan",slogan);
        return query.executeUpdate();
    }

    public Complement getByBarcode(String barCode) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Complement where barCode =:barCode");
        query.setParameter("barCode",barCode);
        return (Complement)query.uniqueResult();
    }
}
