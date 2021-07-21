package com.example.demo.application;

import com.example.demo.domain.DomainException;
import com.example.demo.domain.User;
import com.example.demo.domain.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userServiceImpl) {
		this.userService = userServiceImpl;
	}

	@GetMapping
	public List<User> getUsers() throws DomainException {
			return userService.getUsers();
	}

	@PostMapping
	public User createUser(@RequestBody UserDTO userDTO) {
			return userService.createUser(userDTO.getId(), userDTO.getName());	// hexagonal clean design

	}

}
