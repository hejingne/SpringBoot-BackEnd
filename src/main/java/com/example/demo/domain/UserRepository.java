package com.example.demo.domain;

import java.util.List;

public interface UserRepository {
	User createUser(User user);
	List<User> findAll();
}
