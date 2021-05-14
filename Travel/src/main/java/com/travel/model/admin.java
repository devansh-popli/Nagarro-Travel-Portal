package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class admin {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int uid;
private String username;
private String password;
private String name;
private String title;

public admin() {
	super();
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public admin(String username, String password, String name, String title) {
	super();
	this.username = username;
	this.password = password;
	this.name = name;
	this.title = title;
}
}
