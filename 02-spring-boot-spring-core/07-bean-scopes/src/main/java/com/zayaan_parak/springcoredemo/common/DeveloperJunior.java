package com.zayaan_parak.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DeveloperJunior implements Developer{

    public DeveloperJunior() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyTask() {
        return "Download all the essential software";
    }
}
