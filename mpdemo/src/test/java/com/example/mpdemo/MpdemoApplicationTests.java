package com.example.mpdemo;

import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MpdemoApplicationTests {
    @Autowired
    public UserMapper userMapper;

    @Test
    public void contextLoads() {
//        List<User> list = userMapper.selectList(null);
//        System.out.println(list);
        User user = new User();
        user.setName("lucy");
        user.setAge(35);
        user.setEmail("1057584587@qq.com");
        userMapper.insert(user);
    }
    @Test
    public void update(){
        User user = new User();
        user.setId(1562976244906180613L);
        user.setAge(60);
        int i = userMapper.updateById(user);
        System.out.println(i);

    }

}
