package com.young;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class Redis02ApplicationTests {

    @Resource(name = "myRedisTemplate")
    private RedisTemplate redisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
        User user = new User();
        user.setName("young");
        user.setAge(24);

        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    void calTest() {
        int a = 10;
        System.out.println(a >> 2);
    }

}
