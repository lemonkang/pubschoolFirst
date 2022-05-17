package com.kanghao.eduservice;




import com.kanghao.eduservice.entity.User;
import com.kanghao.eduservice.mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@SpringBootTest
public class EduApplicationTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired(required = false)
    UserMapper userMapper;
    /*
    测试插入方法
     */
    @Test
    public  void testOracleConnect(){
        User user = new User();

        int insert = userMapper.insert(user);

    }
     /*
     LocalDateTime练习
      */
      @Test
    public void testLocalDateTime(){
          //获取当前时间
          System.out.println();

     }

}
