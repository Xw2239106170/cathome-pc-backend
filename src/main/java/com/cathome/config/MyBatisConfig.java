package com.cathome.config;

import org.apache.ibatis.type.EnumTypeHandler;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            configuration.setDefaultEnumTypeHandler(EnumTypeHandler.class);
        };
    }
}