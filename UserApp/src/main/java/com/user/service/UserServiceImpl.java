package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public Page<User> findAllUserPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public String deleteUserById(Long id) {
		userRepository.deleteById(id);
		return "User Deleted Successfully";
		
	}

	@Override
	public User updateUserById(Long id, User user) {
//		User existsedUser =  userRepository.findById(id).orElseThrow(()->new RuntimeException("User with that id is not present"+id));
		User existsedUser =  userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User with that id is not present"+id));
		
		existsedUser.setName(user.getName());
		existsedUser.setEmail(user.getEmail());
		
		return userRepository.save(existsedUser);
	}

	@Override
	public User patchUpdateUserById(Long id, User user) {
		User existsedUser =  userRepository.findById(id).orElseThrow(()->new RuntimeException("User with that id is not present"+id));
		
		if(user.getName()!=null) {
			existsedUser.setName(user.getName());

		}
		if(user.getEmail()!=null) {
			existsedUser.setEmail(user.getEmail());

		}
		return userRepository.save(existsedUser);
	}

	@Override
	public List<User> findAllByName(String name) {
		return userRepository.findAllByName(name);
	}
	
	
	
}
