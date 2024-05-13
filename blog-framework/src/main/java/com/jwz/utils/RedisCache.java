package com.jwz.utils;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author JWZ
 * @version 1.0
 * @date 2024/5/11
 * @annotation Redis缓存
 */

@Component
public class RedisCache {

    @Resource
    public RedisTemplate redisTemplate;

    /**
     * @description: 缓存基本的对象，Integer、String、实体类等
     * @param key 缓存的键值
     * @param value  缓存的值
     * @return:
     */
    public <T> void setCacheObject(final String key, final T value){
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> T getCacheObject(final String key){
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * @description: 缓存map
     * @param key
     * @param dataMap
     * @return:
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap){
        if(dataMap != null){
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    public <T> Map<String, T> getCacheMap(final String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * @description: 往Hash中存入数据
     * @param key Redis键
     * @param hKey Hash键
     * @param hValue 值
     * @return:
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T hValue){
        redisTemplate.opsForHash().put(key, hKey, hValue);
    }

    public <T> T getCacheMapValue(final String key, final String hKey){
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * @description: 缓存List数据
     * @param key 缓存的键值
     * @param dataList 待缓存的List数据
     * @return:  缓存的对象
     */
    public <T> Long setCacheList(final String key, final List<T> dataList){
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    public <T> List<T> getCacheList(final String key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }


    /**
     * @description: 处理hash数据，根据key和文章id增加ViewCount
     * @param key
     * @param hashKey
     * @param step
     * @return:
     */
    public void incrementCacheMapValue(String key, String hashKey, int step){
        redisTemplate.opsForHash().increment(key, hashKey, step);
    }


    /**
     * @description:  设置有效时间
     * @param key Redis键
     * @param timeout  超时时间
     * @param unit 时间单位
     * @return:  true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final Long timeout, final TimeUnit unit){
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * @description: 删除单个对象
     * @param key Redis键
     * @return:
     */
    public boolean deleteObject(final String key){
        return redisTemplate.delete(key);
    }

    /**
     * @description: 删除集合对象
     * @param collection 多个对象
     * @return
     */
    public long deleteObject(final Collection collection) {
        return redisTemplate.delete(collection);
    }



}
