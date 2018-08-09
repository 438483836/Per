package com.wl.service;

import com.wl.dao.AutoPackBackMessDAO;
import com.wl.entity.AutoPackBackMess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vincent on 2018-07-18.
 */
@Service("autoPackBackMessServiceImpl")
@Transactional
public class AutoPackBackMessServiceImpl implements AutoPackBackMessService{

    @Autowired
    private AutoPackBackMessDAO autoPackBackMessDAO;

    public int save(AutoPackBackMess autoPackBackMess) {

        return autoPackBackMessDAO.save(autoPackBackMess);

    }
}
