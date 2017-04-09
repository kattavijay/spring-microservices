package com.userdata.dataobject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.userdata.pojo.User;

public class UserOperationsDAO {

	 private SqlSessionFactory sqlSessionFactory = null;
	 
		
	 public UserOperationsDAO(SqlSessionFactory sqlSessionFactory)
	 {
		 this.sqlSessionFactory = sqlSessionFactory;
	 }

	 
	 public void insertUser(User user)
	 {
		 SqlSession session = sqlSessionFactory.openSession();
		 try
		 {
			 System.out.println("Inside DAO");
			 //UserDataMapper
			session.insert("UserDataMapper.insertUser", user);	 
			 
			 
		 }catch(Exception ex)
		 {			 
			 ex.printStackTrace();
		 }finally
		 {
			 session.commit();
			 session.close();
			 System.out.println("Session commited and closed");
		 }
	 }


	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> usersList = null;
		SqlSession session = sqlSessionFactory.openSession();
		 try
		 {
			 System.out.println("Inside DAO");
			 //UserDataMapper
			usersList = session.selectList("UserDataMapper.getusers"); 
			 
			 
		 }catch(Exception ex)
		 {			 
			 ex.printStackTrace();
		 }finally
		 {
			 session.commit();
			 session.close();
			 System.out.println("Session commited and closed");
		 }
		 
		 return usersList;
	}
}
