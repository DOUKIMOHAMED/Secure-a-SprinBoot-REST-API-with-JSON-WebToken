package com.clubproject.demo.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.clubproject.demo.dao.MessageRepository;
import com.clubproject.demo.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("messageservice")
public class MessageServiceImpl implements MessageService{
	@Autowired
	MessageRepository messagerepository;
	
	@PersistenceContext
	EntityManager em;
	@Override
	public void sendMessage(Message message) {
		messagerepository.save(message);
	}

}
