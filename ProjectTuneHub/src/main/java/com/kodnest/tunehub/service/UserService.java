package com.kodnest.tunehub.service;

import com.kodnest.tunehub.entity.User;

public interface UserService {
	
	public boolean validateUser(String email, String password);
	public String addUser(User user) ;
	public boolean emailExists(String email);
	public String getRole(String email);
	
	public User getUser (String email);
	public void updateUser (User user);

}
