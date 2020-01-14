package com.stackroute.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.demo.model.User;
import com.stackroute.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/user")
@Api
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation("value = Get All Users")
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@ApiOperation("value = Add User")
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

}
