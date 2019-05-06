package com.itheima.web;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends BaseServlet{

    private UserService userService = BeanFactory.newInstance(UserService.class);

    public void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {



        Map<String, String[]> map = request.getParameterMap();

        User user = new User();

        try {
            BeanUtils.populate(user,map);

        }catch (Exception e){
            e.printStackTrace();
        }
        user.setUid(UUIDUtils.getUUID());
        user.setState(1);
        userService.register(user);
        Result result = new Result(Result.SUCCESS,"注册成功");

        response.getWriter().print(JSONObject.fromObject(result));

    }


    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");

        String password = request.getParameter("password");

        User user = userService.login(username, password);

        if(user!=null){

            request.getSession().setAttribute("user",user);
            //创建一个cookie对象
            Cookie cookie = new Cookie("username",username);
            //设置cookiecanshu
            cookie.setMaxAge(60*10);
            cookie.setPath(request.getContextPath());
            //设置cookie携带的域名
            cookie.setDomain("itheima331.com");
            response.addCookie(cookie);

            Result result = new Result(Result.SUCCESS,"登录成功");
            response.getWriter().print(JSONObject.fromObject(result));
        }else{
            Result result = new Result(Result.FAILS,"登录失败,请检查用户名和密码");
            response.getWriter().print(JSONObject.fromObject(result));
        }

    }




}
