package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合,junit启东市加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入DAO实现类依赖
    @Resource
    private  SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L,killTime);
        System.out.println("updateCount = " + updateCount);
        System.out.println("");

    }

    @Test
    public void queryById() throws Exception {
        long id = 1003;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println();
        System.out.print(seckill.getName());
        System.out.print(seckill);
        System.out.println();
    }

    @Test
    public void queryAll() throws Exception {
    /**Caused by: org.apache.ibatis.binding.BindingException:
     *  Parameter 'offset' not found. Available parameters are [arg1, arg0, param1, param2
     * java 没有保存形参的记录
    */
       List<Seckill> seckills = seckillDao.queryAll(0,100);
       for (Seckill seckill : seckills){
            System.out.println("");
            System.out.println(seckill);
            System.out.println("");
       }
    }
}