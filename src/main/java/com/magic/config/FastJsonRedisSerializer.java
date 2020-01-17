package com.magic.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO Redis使用fastjson序列化反序列化
 * @version 1.0
 * @ClassName FastJsonRedisSerializer
 * @date 2020/1/17 17:22
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private Class<T> tClass;

    public FastJsonRedisSerializer(Class<T> tClass){
        super();
        this.tClass = tClass;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if(null == t){
            return new byte[0];
        }
        return JSON.toJSONString(t,SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if(null == bytes || bytes.length <= 0){
            return null;
        }
        String str = new String(bytes,StandardCharsets.UTF_8);
        return (T) JSON.parseObject(str,tClass);
    }
}
