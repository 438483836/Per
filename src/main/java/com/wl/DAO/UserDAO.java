package com.wl.dao;

import com.wl.entity.User;

import java.util.List;

public interface UserDAO {
    public int save(User u);
    public List<User> findAll();
    public User getByNameAndPwd(String user,String pwd);

}
