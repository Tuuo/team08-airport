package com.isoft.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//工具类，可以在项目的其他类中方便地获取和使用Spring容器中的Bean实例
@Component
public class BeanContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
     //设置应用程序上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanContext.applicationContext=applicationContext;
    }
      //获取应用程序上下文
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
     //根据名称获取Bean实例
    public static <T> T getBean(String name) throws BeansException{
        return (T) applicationContext.getBean(name);
    }
     //根据类型获取Bean实例
    public static <T> T getBean(Class<T> clz) throws BeansException{
        return (T) applicationContext.getBean(clz);
    }
}
