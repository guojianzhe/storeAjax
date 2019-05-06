package com.heima.itheima;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;
import org.junit.Test;

import java.sql.SQLException;

public class UserTest {


    @Test
    public void test() throws SQLException {

        UserService userService = BeanFactory.newInstance(UserService.class);
        User user = new User();
        user.setUid("1111");
        user.setUsername("guo");

        userService.register(user);
    }
}
