package com.example.demo.domain;

import com.example.demo.infrastructure.UserEntity;
import com.example.demo.infrastructure.SpringDataHibernateUserRepository;
import java.util.ArrayList;
import java.util.List;
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
		return userRepository.createUser(new User(id, name)); // save -> create a new entry if it can't find the id specified /
																					// update otherwise
	}

}
