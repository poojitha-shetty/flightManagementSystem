package com.capgemini.flightmanagementsystem.service;

import com.capgemini.flightmanagementsystem.bean.UserBean;

public interface UserService {

	public boolean userRegister(UserBean userBean);
	
	public UserBean login(int userId,String userPassword);

}
