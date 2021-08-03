package com.example.demo.domain;

import java.util.List;

public interface UserService {

	List<User> getUsers();

	User createUser(Long id, String name);

}
