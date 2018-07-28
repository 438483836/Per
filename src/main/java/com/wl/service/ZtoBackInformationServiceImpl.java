package com.wl.service;

import com.wl.DAO.ZtoBackInformationDAO;
import com.wl.entity.ZtoResponseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vincent on 2018-07-13.
 */
@Service("ztoBackInformationServiceImpl")
@Transactional
public class ZtoBackInformationServiceImpl implements ZtoBackInformationService{

    @Autowired
    private ZtoBackInformationDAO ztoBackInformationDAO;

    public int save(ZtoResponseTO ztoResponseTO) {
        return ztoBackInformationDAO.save(ztoResponseTO);
    }
}
