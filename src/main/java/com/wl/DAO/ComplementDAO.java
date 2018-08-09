package com.wl.dao;

import com.wl.entity.Complement;

/**
 * Created by Vincent on 2018-06-19.
 */
public interface ComplementDAO {

    public int save(Complement complement);

    public int saveSlogan(String barCode, String slogan);

    public Complement getByBarcode(String barCode);
}
