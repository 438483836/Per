
package com.wl.dao;

import com.wl.entity.ExpressGroup;

/**
 * Created by Administrator on 2017/5/20.
 */
public interface IExpressGroupDAO {

    public ExpressGroup getOneBarCode();

    public void update(ExpressGroup group);


}
