package com.domcj.seccache.seccache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.domcj.seccache.seccache.entity.User;
import com.domcj.seccache.seccache.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecacheApplicationTests {

	private UserMapper userMapper;

	@Test
	public void testSecCache() {
		User user = userMapper.getUserById(1L);
		User userById = userMapper.getUserById(1L);

	}
}
