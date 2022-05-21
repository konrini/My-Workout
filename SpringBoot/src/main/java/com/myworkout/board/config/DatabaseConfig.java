package com.myworkout.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// 데이터베이스 연관 환경 설정
@Configuration
@MapperScan(basePackages = "com.myworkout.board.model.dao")
public class DatabaseConfig {}