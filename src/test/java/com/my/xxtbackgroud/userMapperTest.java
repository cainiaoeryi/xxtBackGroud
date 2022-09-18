package com.my.xxtbackgroud;

import com.my.xxtbackgroud.mapper.UserMapper;
import com.my.xxtbackgroud.pojo.userBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class userMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getAllUserTest(){
        List<userBean> list=userMapper.getAllUser();
        for (com.my.xxtbackgroud.pojo.userBean userBean : list) {
            System.out.println(userBean.toString());
        }
    }
    @Test
    void checkUserTest(){
        System.out.println(userMapper.checkUser("201910201016"));
    }
}
