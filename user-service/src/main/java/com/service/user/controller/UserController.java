/**
 * 
 */
package com.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.user.dto.Userdata;
import com.service.user.entity.Message;
import com.service.user.service.UserService;

/**
 * @author danielf
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public Userdata saveOrUpdate(@RequestBody Userdata user) {
		return userService.saveOrUpdate(user);
	}

	@GetMapping("/get/{username}")
	public Userdata getById(@PathVariable String username) {
		return userService.getById(username);
	}

	@GetMapping("/all")
	public List<Userdata> getAll() {
		return userService.getAll();
	}
	
	@PostMapping("/message/send")
	public void sendMessage(@RequestBody Message message) {
		userService.sendMessage(message);
	}

}
