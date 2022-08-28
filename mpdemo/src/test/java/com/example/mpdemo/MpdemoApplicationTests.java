package com.example.mpdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import lombok.val;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class MpdemoApplicationTests {
    @Autowired
    public UserMapper userMapper;


    @Test
    public void findAll(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
    }

    @Test
    public void insertTest() {

        User user = new User();
        user.setName("mary");
        user.setAge(35);
        user.setEmail("1057584587@qq.com");
        userMapper.insert(user);
    }
    @Test
    public void updateTest(){
        User user = new User();
        user.setId(1562976244906180613L);
        user.setAge(60);
        int i = userMapper.updateById(user);
        System.out.println(i);

    }
    @Test
    public void optimisticLockerTest(){
        User user = userMapper.selectById(1L);
        user.setAge(60);
        userMapper.updateById(user);
    }

    //多个id批量查询
    @Test
    public void testSelectDemo1(){
        List<User> list = userMapper.selectBatchIds(Arrays.asList(1L,2L));
        System.out.println("输出："+list);
    }

    //通过map封装查询条件
    @Test
    public void testSelectByMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","lucy");
        map.put("age","60");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void testSelectPage(){
        //1.创建page对象
        //传入两个参数：当前页和每页显示记录数
        Page<User> page = new Page<>(1,2);
        //调用mp分页查询的方法
        //调用mp分页查询过程中，底层封装
        //把分页所有数据封装到page对象里面
        userMapper.selectPage(page,null);

        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//总页数

        System.out.println(page.hasNext());//是否有下一页
        System.out.println(page.hasPrevious());//是否有上一页
    }

    //根据id删除
    @Test
    public void testDeleteById(){
        User user = new User();
        user.setId(4l);
        val i = userMapper.deleteById(user);
        System.out.println(i);
    }
    //批量删除
    @Test
    public void testBatchDelete(){
        val users = userMapper.deleteBatchIds(Arrays.asList(5L, 6L));
        System.out.println(users);
    }


















}
