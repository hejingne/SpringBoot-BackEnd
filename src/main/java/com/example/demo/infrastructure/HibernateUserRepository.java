package com.example.demo.infrastructure;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HibernateUserRepository implements UserRepository {
	private final SpringDataHibernateUserRepository springDataHibernateUserRepository;

	@Override
	public User createUser(User user) {
		UserEntity userEntity = springDataHibernateUserRepository.save(new UserEntity(user));
		return new User(userEntity.getId(), userEntity.getName());
	}

	// find all
}
