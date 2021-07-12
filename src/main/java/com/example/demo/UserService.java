package com.example.demo;

import java.util.List;

public interface UserService {

	List<User> getUsers() throws DomainException;

	User createUser(User user) throws DomainException;

}
