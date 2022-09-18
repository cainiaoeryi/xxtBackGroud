package com.my.xxtbackgroud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XxtBackGroudApplication {


    static {
        System.setProperty("druid.mysql.usePingMethod", "false");
    }
    public static void main(String[] args) {
        SpringApplication.run(XxtBackGroudApplication.class, args);
    }

}
