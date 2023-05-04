package org.jsp.usermvcapp.service;

import java.util.List;

import org.jsp.usermvcapp.dao.UserDao;
import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	
	@Autowired
	private UserDao Dao;
	
	public User saveuser(User u1)
	{
		return Dao.saveuser(u1);
	}
	public User updateuser(User u)
	{
		return Dao.updateuser(u);
	}
	public User getuserbyid(int id)
	{
		return Dao.getuserbyid(id);
	}
	public boolean deleteuser(int id)
	{
		return Dao.deleteuser(id);
	}
	public List<User> findalluser()
	{
		return Dao.findallusers();
	}
	public User verifyuser(long phone,String password)
	{
		return Dao.verifyuser(phone, password);
	}
}

