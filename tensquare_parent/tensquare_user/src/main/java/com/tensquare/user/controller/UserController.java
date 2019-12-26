package com.tensquare.user.controller;

import com.tensquare.common.entity.Result;
import com.tensquare.user.po.User;
import com.tensquare.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author nieyifan
 * @createTime 2019/12/26 11:52
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/send-sms/{mobile}")
    public Result sendSms(@PathVariable(name = "mobile")String mobile){
        userService.sendSms(mobile);
        return Result.susccess();
    }

    @PostMapping("/register/{code}")
    public Result registerUser(@PathVariable(name = "code") String code, @RequestBody User user){
        userService.addUser(user,code);
        return Result.susccess();
    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map){
        User user = userService.login(map);
        if(user != null){
            return Result.susccess();
        }
        return Result.error();
    }

}
