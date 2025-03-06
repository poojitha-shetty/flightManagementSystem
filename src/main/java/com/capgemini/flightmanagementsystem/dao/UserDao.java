package com.capgemini.flightmanagementsystem.dao;

import com.capgemini.flightmanagementsystem.bean.UserBean;

public interface UserDao {
	
	public boolean userRegister(UserBean userBean);
	
	public UserBean login(int userId,String userPassword);

}
