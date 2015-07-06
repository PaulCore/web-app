package com.zhi.controller;

import com.zhi.dao.UserDao;
import com.zhi.dao.jdbcImp.UserDaoJdbcImp;
import com.zhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by paul on 2015/6/29.
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, String repassword){
        System.out.println(user);
        if (user.getUsername()!=null&&
                repassword!=null&&repassword.equals(user.getPassword())){
            userDao.register(user);
            return "success";
        }
       return "error";
    }

    @RequestMapping("login")
    public String login(User user,HttpSession session){
        int id = userDao.login(user);
        if (id == -1)
            return "error";
        user.setId(id);
        session.setAttribute("user",user);
        return "forward:index.jsp";
    }


}
