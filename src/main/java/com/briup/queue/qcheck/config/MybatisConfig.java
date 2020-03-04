package com.briup.queue.qcheck.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.queue.qcheck.dao")
public class MybatisConfig {

}
