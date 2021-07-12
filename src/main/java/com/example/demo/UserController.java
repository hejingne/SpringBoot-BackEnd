package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

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
	public User createUser(@RequestBody UserDTO userDTO) throws DomainException{
			return userService.createUser(new User(userDTO.getId(), userDTO.getName()));

	}

}
