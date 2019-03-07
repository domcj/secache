package com.domcj.seccache.seccache.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @description: This is a class!
 * @author: chenjian
 * @date: 2019/03/07 11:45
 */
public class RedisCache implements Cache {

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private String id; // cache instance id
	private RedisTemplate redisTemplate;
	private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis过期时间

	public RedisCache(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void putObject(Object key, Object value) {
		RedisTemplate redisTemplate = getRedisTemplate();
		ValueOperations opsForValue = redisTemplate.opsForValue();
		opsForValue.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.SECONDS);
	}

	@Override
	public Object getObject(Object key) {
		RedisTemplate redisTemplate = getRedisTemplate();
		ValueOperations opsForValue = redisTemplate.opsForValue();
		Object obj = opsForValue.get(key);
		return obj;
	}

	@Override
	public Object removeObject(Object key) {
		RedisTemplate redisTemplate = getRedisTemplate();
		redisTemplate.delete(key);
		return null;
	}

	@Override
	public void clear() {
		RedisTemplate redisTemplate = getRedisTemplate();
		redisTemplate.execute((RedisCallback) connection -> {
			connection.flushDb();
			return null;
		});
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	private RedisTemplate getRedisTemplate() {
		if (redisTemplate == null) {
			redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
		}
		return redisTemplate;
	}
}
