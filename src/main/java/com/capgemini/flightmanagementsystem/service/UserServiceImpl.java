package com.capgemini.flightmanagementsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightmanagementsystem.bean.UserBean;
import com.capgemini.flightmanagementsystem.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public boolean userRegister(UserBean userBean) {
		
		return dao.userRegister(userBean);
	}

	@Override
	public UserBean login(int userId, String userPassword) {
	
		return dao.login(userId, userPassword);
	}

	

}
