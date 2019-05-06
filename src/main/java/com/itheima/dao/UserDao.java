package com.itheima.dao;

import com.itheima.domain.User;

import java.sql.SQLException;

public interface UserDao {
    public  void register(User user) throws SQLException;


    public User login(String username,String password) throws SQLException;
}
