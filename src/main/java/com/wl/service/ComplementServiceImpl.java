package com.wl.service;

import com.wl.dao.ComplementDAO;
import com.wl.entity.Complement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vincent on 2018-06-19.
 */
@Service("complementService")
@Transactional
public class ComplementServiceImpl implements ComplementService{

    @Autowired
    private ComplementDAO complementDAO;

    public int save(Complement complement) {
        return complementDAO.save(complement);
    }

    public int saveSlogan(String barCode, String slogan) {
        return complementDAO.saveSlogan(barCode, slogan);
    }

    public Complement getByBarcode(String barCode) {
        return complementDAO.getByBarcode(barCode);
    }
}
