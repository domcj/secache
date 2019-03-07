package com.domcj.seccache.seccache.entity;

import java.io.Serializable;

/**
 * @description: This is a class!
 * @author: chenjian
 * @date: 2019/03/07 11:21
 */
public class User implements Serializable {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
