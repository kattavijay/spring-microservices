package com.userdata.dataobject;

import java.util.List;

import com.userdata.pojo.User;

public interface UserDataMapper {
	
	public void insertUser(User user);
	
	public List<User> getusers();

}
