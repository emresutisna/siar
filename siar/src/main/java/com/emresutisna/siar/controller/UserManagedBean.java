package com.emresutisna.siar.controller;

import java.io.Serializable;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.emresutisna.siar.model.UserEntity;
import com.emresutisna.siar.services.UserService;

@Controller("userMB")
@Scope("request")
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = 3701454384507876992L;
	
	private UserEntity loggedinUser;
//	private String tahun;

	//@ManagedProperty(value="#{userService}")
	@Autowired
	private UserService userService;
	
	public UserEntity loadUserByUsername(String username){
		return userService.getByUsername(username);
	}
	
/*	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}
*/
	public UserEntity getLoggedinUser() {
		this.loggedinUser = userService.getLoggedinUser();
		return loggedinUser;
	}
/*
	public void setLoggedinUser(UserEntity loggedinUser) {
		this.loggedinUser = loggedinUser;
	}
*/
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
