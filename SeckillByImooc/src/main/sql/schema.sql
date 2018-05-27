CREATE DATABASE seckill;

-- 创建秒杀库存表
CREATE TABLE seckill(
  'seckill_id' BIGINT NOT NULL auto_increment comment '商品库存id',
  'name' VARCHAR (120) NOT NULL comment '商品名称',
  'number' INT NOT NULL comment '库存数量'
  'start_time' TIMESTAMP NOT NULL comment '秒杀开启时间',
  'end_time' TIMESTAMP NOT NULL comment '秒杀结束时间',
  'create_time' TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET =utf-8 COMMENT='秒杀库存表'

-- 初始化数据
INSERT INTO seckill(name,number,start_time,end_time)
VALUES
('1000元秒杀iPhone6',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('500元秒杀ipad2',200,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('300元秒杀小米4',300,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
('200元秒杀红米note',400,'2015-11-01 00:00:00','2015-11-02 00:00:00');


-- 秒杀成功明细表
-- 用户登录认证相关信息
CREATE TABLE success_killed(
  'seckill_id' bigint NOT NULL comment '秒杀商品id',
  'user_phone' bitint NOT NULL comment '用户手机号',
  'state' tinyint NOT NULL DELETE -1 comment '状态标识：-1：无效，0：成功，1：已付款'
  PRIMARY KEY (seckill_id,user_phone),/* 联合主键*/
  KEY idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET =utf8 COMMENT='秒杀成功明细表'

