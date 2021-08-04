package com.example.demo.domain;

import com.example.demo.infrastructure.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class UserServiceImpl implements UserService {	// Business Logic Layer
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	@Override
	public User createUser(Long id, String name){
		if (userRepository.findById(id).isPresent()) {
			throw new UserAlreadyExistsException("User with Id " + id + " already exists.");
		}
		return userRepository.save(new User(id, name)); // save -> create a new entry if it can't find the id specified /
																					// update otherwise
	}

	@Override
	public User updateUser(Long id, String name) {
		userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with Id " + id + " does not exist."));
		return userRepository.save(new User(id, name));
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with Id " + id + " does not exist."));
		userRepository.delete(userRepository.findById(id).get());
	}
}
