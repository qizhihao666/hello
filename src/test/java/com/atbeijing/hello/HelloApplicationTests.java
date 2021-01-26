package com.atbeijing.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class HelloApplicationTests {

	@Autowired
	private RedisTemplate<String,String> redisTemplate;
//	@Autowired
//	private JedisPool jedisPool;


	@Test
	public void set(){
		redisTemplate.opsForValue().set("myRedis","helloRedis");
		System.out.println(redisTemplate.opsForValue().get("myRedis"));
	}


//	@Test
//	public void testJedis(){
//		Jedis jedis = jedisPool.getResource();
//		System.out.println(jedis.get("myRedis"));
//	}
}
