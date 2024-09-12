package com.zayaan_parak.springcoredemo.config;

import com.zayaan_parak.springcoredemo.common.Developer;
import com.zayaan_parak.springcoredemo.common.DeveloperBusiness;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperConfig {

    @Bean("efficient")
    public Developer businessDeveloper(){
        return new DeveloperBusiness();
    }
}
