package com.domcj.seccache.seccache.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.domcj.seccache.seccache.entity.User;
import com.domcj.seccache.seccache.mapper.UserMapper;

/**
 * @description: This is a class!
 * @author: chenjian
 * @date: 2019/03/07 12:27
 */
@RestController
public class TestController {

	@Resource
	private UserMapper userMapper;

	@GetMapping("/findUser/{id}")
	public User getUserById(@PathVariable Long id) {
		User user = userMapper.getUserById(id);
		return user;
	}
}
