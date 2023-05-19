package com.yohane.test.dao.redis;

import com.yohane.test.Utils.spring.ApplicationContextHolder;
import org.apache.ibatis.cache.Cache;
import org.omg.CORBA.TIMEOUT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 2023/4/10
 *
 * @Time 11:12
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
public class RedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static final long EXPIRE_TIME_IN_MINUTES = 360;

    private final String id;

    private RedisTemplate redisTemplate;

    public RedisCache(String id) {
        if(id == null)
            throw new IllegalArgumentException("Cache instances require an ID");
        this.id = id;
    }

    private RedisTemplate getRedisTemplate(){
        if(redisTemplate == null)
            redisTemplate = (RedisTemplate) ApplicationContextHolder.getBean("redisTemplate");
        return redisTemplate;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * 将内容塞入缓存 / put query result to redis
     *
     * @param key key
     * @param value value
     */
    @SuppressWarnings("all")
    @Override
    public void putObject(Object key, Object value) {
        System.out.println("key=" + key + "  value=" + value);
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key,value,EXPIRE_TIME_IN_MINUTES,TimeUnit.SECONDS);
        logger.debug("Put query result to redis");
    }

    /**
     * 从缓存里面获取内容 / Get cache query result from redis
     * @param key key
     * @return value
     */
    @SuppressWarnings("all")
    @Override
    public Object getObject(Object key) {
        System.out.println("key=" + key);
        RedisTemplate redisTemplate = getRedisTemplate();
        ValueOperations opsForValue = redisTemplate.opsForValue();
        logger.debug("Get cache query result from redis");
        return opsForValue.get(key);
    }

    /**
     * 将内容从缓存删除 / Remove cache query result from redis
     * @param key
     * @return
     */
    @Override
    public Object removeObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.delete(key);
        logger.debug("Remove cache query result from redis");
        return null;

    }

    /**
     * 清除缓存 / Clear cache from redis
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.execute((RedisCallback) connection ->{
            connection.flushDb();
            return null;
        });
        logger.debug("Clear all the cached query result from redis");
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
