package com.capgemini.flightmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
// org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagementsystem.bean.UserBean;
import com.capgemini.flightmanagementsystem.response.UserResponse;
import com.capgemini.flightmanagementsystem.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserController {
	
	@Autowired
	private UserService service;
	
	UserResponse response = new UserResponse();
	
	//@PostMapping("/userRegister")
	@PostMapping(path = "/userRegister", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse registerUser(@RequestBody UserBean userBean) {
		boolean isAdded = service.userRegister(userBean);
		if(isAdded) {
			response.setStatus(200);
			response.setMessage("Data is added successfully..");
		} else {
			response.setStatus(400);
			response.setMessage("Failed to add the data..");
		}
		return response;
	}//end of register
	
//	@PostMapping("/login")
//	public UserResponse login(@RequestBody UserBean userBean) {
//		int userId = userBean.getUserId();
//		String userPassword = userBean.getUserPassword();			
//		String type = service.login(userId, userPassword);
//		if(type.equals("user")) {
//			response.setStatus(200);
//			response.setMessage("Success");
//			response.setType(type);			
//		}else {
//			response.setStatus(400);
//			response.setMessage("Failed");
//		}
//		return response;
//	}// end of userLogin()
	
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserBean login(@RequestBody UserBean user) {
		UserBean resultuser = service.login(user.getUserId(), user.getUserPassword());
		if (resultuser != null) {
			return resultuser;
		} else {
			return null;
		}
	}
	
	
	
	
	

}
