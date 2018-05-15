package com.wql.controller;

import com.wql.entity.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld test = (HelloWorld) applicationContext.getBean("HelloWorld");
        System.out.println(test.getMessage());
    }
}
