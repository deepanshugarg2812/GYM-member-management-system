package com.main;

import java.sql.Date;

public class Member {
	//Defining the class instance variables
	int id;

	//Name of the member need not be unique
	String name; 
	
	//Age of the member
	int age;
	
	//Date of joining of the member
	Date doj;
	
	//Date of ending of the membership
	Date doe;
	
	//Height of the member
	double height;
	
	//Weight of the member
	double weight;
	
	//Default constructor
	public Member() {
		super();
	}
	
	//Pataretrised constructor
	public Member(String name, int age, Date doj, Date doe, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.doj = doj;
		this.doe = doe;
		this.height = height;
		this.weight = weight;
	}
	
	//Constructor with id
	public Member(int id, String name, int age, Date doj, Date doe, double height, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.doj = doj;
		this.doe = doe;
		this.height = height;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//Getters and setters
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

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", doj=" + doj + ", doe=" + doe + ", height=" + height
				+ ", weight=" + weight + "]";
	}
	
	
	
}
