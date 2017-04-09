package com.userdata.dataobject;

import java.util.List;

import com.userdata.pojo.User;

public class ServiceController {

	public void insertUser(User user) {
		UserOperationsDAO userOperationsDAO = null;
		// System.out.println("Inside service");
		try {
			userOperationsDAO = new UserOperationsDAO(MyBatisConnectionFactory.getSqlSessionFactory());
			userOperationsDAO.insertUser(user);
		} catch (Exception ex) {
			// System.out.println("Exception found");
			ex.printStackTrace();
		}

	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> usersList = null;

		UserOperationsDAO userOperationsDAO = null;
		try {
			userOperationsDAO = new UserOperationsDAO(MyBatisConnectionFactory.getSqlSessionFactory());
			usersList = userOperationsDAO.getUsers();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return usersList;
	}

}
