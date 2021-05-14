package com.travel.model;

public class jwtReponseModel {
String token;

public jwtReponseModel(String token) {
	super();
	this.token = token;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public jwtReponseModel() {
	super();
}
}
