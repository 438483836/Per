package com.wl.service;

import com.wl.dao.DeskBackMessDAO;
import com.wl.entity.DeskBackMess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vincent on 2018-06-26.
 */
@Service("deskBackMessService")
@Transactional
public class DeskBackMessServiceImpl implements DeskBackMessService{

    @Autowired
    private DeskBackMessDAO deskBackMessDAO;

    public int save(DeskBackMess deskBackMess) {
        return deskBackMessDAO.save(deskBackMess);
    }
}
