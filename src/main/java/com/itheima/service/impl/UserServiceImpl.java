package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{

   private UserDao userDao = BeanFactory.newInstance(UserDao.class);

    @Override
    public void register(User user) throws SQLException {
        userDao.register(user);
    }

    @Override
    public User login(String username, String password){

        User user = null;
        try {
            user = userDao.login(username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
