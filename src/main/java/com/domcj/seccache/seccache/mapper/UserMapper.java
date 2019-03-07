package com.domcj.seccache.seccache.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.domcj.seccache.seccache.entity.User;

/**
 * @description: This is a class!
 * @author: chenjian
 * @date: 2019/03/07 11:23
 */
@Mapper
public interface UserMapper {
	User getUserById(Long id);
}
