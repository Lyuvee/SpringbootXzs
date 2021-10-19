package com.mindskip.xzs.controller;

import com.mindskip.xzs.domain.User;
import com.mindskip.xzs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/filter")
public class test2 {

    @Autowired
    private UserService userService;
    @GetMapping("hangzhou")
    public List<User> test() {
        return userService.getUsers();
    }
    @GetMapping("xiaoshan")
    public List<User> test1() {
        return userService.getUsers();
    }
    @GetMapping("shaoxing")
    public List<User> test2() {
        return userService.getUsers();
    }

}
