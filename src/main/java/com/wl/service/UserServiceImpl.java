package com.wl.service;

import com.wl.dao.UserDAO;
import com.wl.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDao;

    public void saveUsers(List<User> us) {
        for (User u : us) {
            userDao.save(u);
        }
    }

    public List<User> getAllUsernames() {
        return userDao.findAll();
    }

    public User getByNameAndPwd(String user, String pwd) {
        User u =userDao.getByNameAndPwd(user,pwd);
        return u;
    }

    public Map<String, Object> loginVaData(String userName, String pwd){
        Map<String, Object> result = new HashMap<String, Object>();
        User user = userDao.getByNameAndPwd(userName,pwd);
        result.put("code", "0001");
        result.put("codeDesc", "用户不存在");
        result.put("data", false);
        if (user != null){
            String userPwdDB = user.getPassword();
            if (pwd.equals(userPwdDB)){
                result.put("data", true);
                result.put("code", "0000");
                result.put("codeDesc", "成功");
                logger.info("Login Success");
            }else {
                result.put("code", "0002");
                result.put("codeDesc", "密码错误");
                logger.error("Login Error");
            }
        }

        return result;
    }
}
