package com.example.mpdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MpdemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MpdemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MpdemoApplication.class, args);
        LOGGER.info("ヾ(◍°∇°◍)ﾉﾞ    EurekaApplication server 启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }

}
