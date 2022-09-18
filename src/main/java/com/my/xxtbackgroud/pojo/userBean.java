package com.my.xxtbackgroud.pojo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class userBean {
    private int uid;
    private String userName;
    private String passWord;
    private String email;
    private String school;
    private String major;
    private String stuId;
}
