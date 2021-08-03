package com.example.demo.infrastructure;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
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

	@Override
	public List<User> findAll() {
		return springDataHibernateUserRepository.findAll().stream().map(userEntity -> new User(userEntity.getId(), userEntity.getName())).collect(Collectors.toList());
	}
}
