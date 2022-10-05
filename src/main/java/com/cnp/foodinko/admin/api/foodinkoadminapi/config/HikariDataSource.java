package com.cnp.foodinko.admin.api.foodinkoadminapi.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class HikariDataSource {


    // yml 파일에 있는 spring.datasource.hikari 속성을 자동으로 가져와서 hikaridatasource 객체 생성 및 bean 등록
    @Primary
    @Bean(name = "datasource", destroyMethod = "")
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(com.zaxxer.hikari.HikariDataSource.class).build();
    }

}
