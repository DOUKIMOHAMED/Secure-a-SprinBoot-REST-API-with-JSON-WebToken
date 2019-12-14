package com.clubproject.demo.controller;

import com.clubproject.demo.dao.ConversationRepository;
import com.clubproject.demo.dao.UserRepository;
import com.clubproject.demo.entities.Conversation;
import com.clubproject.demo.entities.Message;
import com.clubproject.demo.entities.User;
import com.clubproject.demo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
    private SimpMessagingTemplate template;
	@Autowired
	MessageService messageservice;
	@Autowired
	ConversationRepository conversationrepository;
	@Autowired
	UserRepository userrepository;
	@RequestMapping(value = "/sendMessage/{idUser}/{idConv}", method = RequestMethod.POST)
	public ResponseEntity<?> sendMessage(@PathVariable("idUser") Integer idUser, @PathVariable("idConv") Integer idConv, @RequestBody String obj ) throws Exception {
		Message message = new Message();
		User user = new User();
		user.setId(idUser);
		Conversation conv = conversationrepository.getOne(idConv);
		message.setUser(user);
		message.setConversation(conv);
		message.setContent(obj);
		messageservice.sendMessage(message);
		template.convertAndSend("/chat/sendDone", message);
		return ResponseEntity.ok("done");
	}
}
