package com.wl.service;

import com.wl.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {
    public void saveUsers(List<User> us);
    public List<User> getAllUsernames();
    public User getByNameAndPwd(String user,String pwd);
    public Map<String, Object> loginVaData(String user,String pwd);
    public Map<String, Object> registeredData(String firstName,String lastName,String email,String password,String introduction);
}
