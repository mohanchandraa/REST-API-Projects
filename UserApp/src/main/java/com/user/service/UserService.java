package com.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.user.entity.User;

public interface UserService {
	
	User save(User user);

	User getUserById(Long id);

	List<User> findAllUsers();
	
	Page<User> findAllUserPage(Pageable pageable);

	String deleteUserById(Long id);

	User updateUserById(Long id, User user);

	User patchUpdateUserById(Long id, User user);
	
	List<User> findAllByName(String name);
}
