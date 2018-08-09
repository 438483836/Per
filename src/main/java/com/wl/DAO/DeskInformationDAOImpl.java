package com.wl.dao;

import com.wl.entity.DeskInformation;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vincent on 2018-06-25.
 */
@Repository
public class DeskInformationDAOImpl implements DeskInformationDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public DeskInformation getByBarcode(String barcode) {

        Query query = sessionFactory.getCurrentSession().createQuery("from DeskInformation where barcode =:barcode");

        query.setParameter("barcode",barcode);

        return (DeskInformation)query.uniqueResult();
    }

    public int save(DeskInformation deskInformation) {

        return (Integer) sessionFactory.getCurrentSession().save(deskInformation);

    }
}
