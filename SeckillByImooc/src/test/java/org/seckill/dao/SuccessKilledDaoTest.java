package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        /**
         * 第一次：insertCount = 1
         * 第二次：insertCount = 0
         */
        long id = 1003L;
        long phone = 12315489615L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount = " + insertCount);

    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        /**
         * SuccessKilled{
         * seckillId=1002,
         * userPhone=22215489615,
         * state=0,
         * createTime=Sun May 27 16:02:17 CST 2018}
         *Seckill{
         * seckillId=1002,
         * name='300元秒杀小米4',
         * number=300,
         * startTime=Sun May 27 14:26:31 CST 2018,
         * endTime=Mon Nov 02 00:00:00 CST 2015,
         * createTime=Fri May 25 14:26:28 CST 2018}

         */
        long id = 1002L;
        long phone = 22215489615L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}