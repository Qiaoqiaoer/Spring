package com.wql.controller;

import com.wql.entity.HelloWorld;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //1.读取配置文件实例换一个IoC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");


        /**
         * Singleton是单例类型，
         * 就是在创建起容器时就同时自动创建了一个bean的对象，
         * 不管你是否使用，他都存在了，每次获取到的对象都是同一个对象。
         * 注意，Singleton作用域是Spring中的缺省作用域。
         */
        //2.从容器中获取bean，注意此处完全“面向接口编程，而不是面向实现”
        /*HelloWorld objA = (HelloWorld) applicationContext.getBean("HelloWorld");

        objA.setMessage("I'm abject A");
        System.out.println(objA.getMessage());

        HelloWorld objB = (HelloWorld) applicationContext.getBean("HelloWorld");
        System.out.println(objB.getMessage());*/

        /**
         * Prototype是原型类型，
         * 它在我们创建容器的时候并没有实例化，
         * 而是当我们获取bean的时候才会去创建一个对象，
         * 而且我们每次获取到的对象都不是同一个对象
         */

        HelloWorld objA = (HelloWorld) applicationContext.getBean("HelloWorld");

        objA.setMessage("I'm object A");
        System.out.println(objA.getMessage());

        HelloWorld objB = (HelloWorld) applicationContext.getBean("HelloWorld");
        System.out.println(objB.getMessage());

    }
}
