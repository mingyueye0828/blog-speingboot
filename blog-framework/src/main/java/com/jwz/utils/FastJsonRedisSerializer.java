package com.jwz.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/13
 * @annotation 支持序列化和反序列化的FastJsonRedisSerializer
 * 这个配置类主要配置是object在redis中序列化时的value
 * 用于将对象序列化为 JSON 字符串，并将 JSON 字符串反序列化为对象
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz; //用于存储序列化对象的类型信息

    static  //静态代码块，在类加载时执行
    {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        //如果遇到反序列化autoType is not support错误，请添加并修改一下包名到bean文件路径
        // ParserConfig.getGlobalInstance().addAccept("com.xxxxx.xxx");
    }

    public FastJsonRedisSerializer(Class<T> clazz)
    {
        super();
        this.clazz = clazz;
    }

    /**
     * @description: 这是实现了 RedisSerializer 接口的 serialize 方法，
     * 用于将对象序列化为字节数组。
     * 它使用 FastJSON 将对象转换为 JSON 字符串，然后将字符串转换为字节数组
     * @param t
     * @return:
     */
    @Override
    public byte[] serialize(T t) throws SerializationException
    {
        if (t == null)
        {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    /**
     * @description: 用于将字节数组反序列化为对象。它首先将字节数组转换为字符串，
     * 然后使用 FastJSON 将字符串转换为指定类型的对象
     * @param bytes
     * @return:
     */
    @Override
    public T deserialize(byte[] bytes) throws SerializationException
    {
        if (bytes == null || bytes.length <= 0)
        {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);

        return JSON.parseObject(str, clazz);
    }



    protected JavaType getJavaType(Class<?> clazz)
    {
        return TypeFactory.defaultInstance().constructType(clazz);
    }

}
