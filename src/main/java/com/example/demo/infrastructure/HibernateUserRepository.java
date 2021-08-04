package com.example.demo.infrastructure;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HibernateUserRepository implements UserRepository {
	private final SpringDataHibernateUserRepository springDataHibernateUserRepository;

	@Override
	public User save(User user) {
		UserEntity userEntity = springDataHibernateUserRepository.save(new UserEntity(user));
		return new User(userEntity.getId(), userEntity.getName());
	}

	@Override
	public List<User> findAll() {
		return springDataHibernateUserRepository.findAll().stream().map(userEntity -> new User(userEntity.getId(), userEntity.getName())).collect(Collectors.toList());
	}

	@Override
	public Optional<User> findById(Long id) {
		Optional<UserEntity> userEntity = springDataHibernateUserRepository.findById(id);
		return userEntity.map(entity -> new User(entity.getId(), entity.getName()));
	}

	@Override
	public void delete(User user) {
		springDataHibernateUserRepository.delete(new UserEntity(user));
	}
}
