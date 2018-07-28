package com.wl.DAO;

import com.wl.entity.ZtoResponseTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vincent on 2018-07-13.
 */
@Repository
public class ZtoBackInformationDAOImpl implements ZtoBackInformationDAO{

    private static Logger logger = LogManager.getLogger(ZtoBackInformationDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public int save(ZtoResponseTO ztoResponseTO) {

        logger.info(ztoResponseTO.toString());

        return (Integer) sessionFactory.getCurrentSession().save(ztoResponseTO);
    }
}
