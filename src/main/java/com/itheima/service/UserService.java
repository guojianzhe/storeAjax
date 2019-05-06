package com.itheima.service;

import com.itheima.domain.User;

import java.sql.SQLException;

public interface UserService {
    void register(User user) throws SQLException;

    User login(String username,String password);
}
