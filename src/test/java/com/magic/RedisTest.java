package com.magic;

import com.magic.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName RedisTest
 * @date 2020/1/17 19:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){
        User user = new User(1,"magic","1997-08-21","男","西安");
        redisTemplate.opsForValue().set("magic",user.toString());
        String  magic = (String) redisTemplate.opsForValue().get("magic");
        System.out.println(magic);
    }
}
