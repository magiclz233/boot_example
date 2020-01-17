package com.magic.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName RedisConfig
 * @date 2020/1/17 17:21
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    /**
     * 自定义缓存生成key规则
     */
    @Bean("myKeyGenerator")
    @Override
    public KeyGenerator keyGenerator(){

        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder str = new StringBuilder();
                str.append(o.getClass().getSimpleName());
                str.append(".");
                str.append(method.getName());
                str.append(".");
                for (Object object :
                        objects) {
                    str.append(object.toString());
                }
                System.out.println("调用redis缓存key："+str.toString());
                return str.toString();
            }
        };
    }

    @Bean
    @Primary
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        RedisSerializationContext.SerializationPair<Object> objectSerializationPair =
                RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer);
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
//        //设置默认超过期时间是30秒
        cacheConfiguration.entryTtl(Duration.ofDays(30));

        //初始化RedisCacheManager
        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter,cacheConfiguration);


        //设置白名单---非常重要********
        /*
        使用fastjson的时候：序列化时将class信息写入，反解析的时候，
        fastjson默认情况下会开启autoType的检查，相当于一个白名单检查，
        如果序列化信息中的类路径不在autoType中，
        反解析就会报com.alibaba.fastjson.JSONException: autoType is not support的异常
        可参考 https://blog.csdn.net/u012240455/article/details/80538540
         */
        ParserConfig.getGlobalInstance().addAccept("com.magic.dto.");
        return cacheManager;
    }


    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        cacheConfiguration = cacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.
                fromSerializer(fastJsonRedisSerializer)).entryTtl(Duration.ofDays(30));
        return cacheConfiguration;
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();

        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);

        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
