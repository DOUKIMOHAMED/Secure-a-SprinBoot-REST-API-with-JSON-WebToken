package com.clubproject.demo.controller;

import com.clubproject.demo.config.JwtResponse;
import com.clubproject.demo.config.JwtTokenUtil;
import com.clubproject.demo.entities.User;
import com.clubproject.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userservice;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public void saveUser(@RequestBody User user) {
		userservice.saveUser(user);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User credentials) throws Exception {
		final User user = userservice.loadByUsername(credentials.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/connectedUser/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> getConnectedUser(@PathVariable("username") String username) throws Exception {
		return ResponseEntity.ok(userservice.getConnectedUser(username));
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() throws Exception {
		return ResponseEntity.ok(userservice.getAllUsers());
	}
	

}
