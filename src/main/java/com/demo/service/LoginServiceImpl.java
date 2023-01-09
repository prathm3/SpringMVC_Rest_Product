package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.User;

//import com.demo.beans.User;

import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao loginDao;
	public LoginServiceImpl() {
	    loginDao=new LoginDaoImpl();
	}
	//@Override
	public User validateUser(String uname, String pass) {
		return loginDao.validateUser(uname,pass);
}
}