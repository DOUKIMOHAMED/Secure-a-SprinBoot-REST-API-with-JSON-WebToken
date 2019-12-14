package com.clubproject.demo.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.clubproject.demo.dao.UserRepository;

import com.clubproject.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("userservice")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userrepository;
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void saveUser(User user) {
		userrepository.save(user);	
	}

	@Override
	public User loadByUsername(String username) {
		TypedQuery<User> query = (TypedQuery<User>) em.createQuery("SELECT u FROM User u WHERE u.username = :username" ,User.class);
		User u = query.setParameter("username", username).getSingleResult();
		return u;
	}


	@Override
	public User getConnectedUser(String username) {
		TypedQuery<User> query = (TypedQuery<User>) em.createQuery("SELECT u FROM User u WHERE u.username = :username" ,User.class);
		User u = query.setParameter("username", username).getSingleResult();	
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		return userrepository.findAll();
	}


}
