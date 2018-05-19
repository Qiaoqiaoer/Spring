package com.wql.controller;

import com.wql.entity.SpringLifeTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifeTest.xml");

        SpringLifeTest obj = (SpringLifeTest) context.getBean("lifeTest");

        obj.getMessage();
        context.registerShutdownHook();

    }
}
