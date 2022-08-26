package com.example.mpdemo.controller;

import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    public UserMapper userMapper;

    @RequestMapping("test")
    public List<User> test (){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }
}
