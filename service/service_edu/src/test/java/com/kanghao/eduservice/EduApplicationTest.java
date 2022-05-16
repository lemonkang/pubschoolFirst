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
        user.setTestId("1111");
        user.setPriceempty(true);
        user.setTestPrice(new BigDecimal(12.123));
        user.setTestFood("菠萝");
        user.setGmtCreate(LocalDateTime.now());
        user.setGmtModified(LocalDateTime.now());
        int insert = userMapper.insert(user);

    }


}
