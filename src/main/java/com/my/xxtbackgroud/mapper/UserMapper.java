package com.my.xxtbackgroud.mapper;

import com.my.xxtbackgroud.pojo.userBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<userBean> getAllUser();

    @Select("select * from user where stuid=#{stuId}")
    userBean checkUser(String stuId);
}
