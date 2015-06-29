package com.zhi.controller;

import com.zhi.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by paul on 2015/6/29.
 */
@Controller
public class UserController {
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, String repassword){
        System.out.println("hell world");
        System.out.println(user);
        System.out.println(repassword);
        return "success";
    }
    @RequestMapping("hello")
    public void hello(){
        System.out.println("hello");
    }


}
