package com.yiguy.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	@Column
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
