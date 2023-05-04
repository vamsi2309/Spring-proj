package org.jsp.usermvcapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao 
{
	@Autowired
	EntityManager manager;
	
	
	public User saveuser(User u)
	{
		EntityTransaction t=manager.getTransaction();
		manager.persist(u);
		t.begin();
		t.commit();
		return u;
	}
	public User updateuser(User u)
	{
		EntityTransaction t=manager.getTransaction();
		manager.merge(u);
		t.commit();
		t.begin();
		return u;
	}
	public User getuserbyid(int id)
	{
		return manager.find(User.class, id);
	}
	
	public User verifyuser(long phone,String password)
	{
		Query q=manager.createQuery("select u from user u where u.phone=?1 and password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<User> users=q.getResultList();
		if(users.size()>0)
			return users.get(0);
		return null;
	}
	public boolean deleteuser(int id)
	{
		EntityTransaction t=manager.getTransaction();
		User u=manager.find(User.class, id);
		if(u!=null)
		{
			manager.remove(u);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}
	public List<User> findallusers()
	{
		Query q=manager.createQuery("select u from user u");
		return q.getResultList();
	}
}
