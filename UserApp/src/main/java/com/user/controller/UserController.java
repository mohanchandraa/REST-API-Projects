package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

//import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@Hidden  hides all apis from swagger
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addNewUser")
//	@Hidden hides particular api from swagger ui
	public User addUser(@Valid @RequestBody User user) {
//		log.info("This user is coming from Postman {}",user.getName());
//		log.debug("This user is coming from Postman {}",user.getEmail());
//		try {
//			return userService.save(user);
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
		
		return userService.save(user);
	}
	
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
	@GetMapping("/getAllUsersPage")
    public Page<User> getAllUserPage(Pageable pageable)
    {
    	 return  userService.findAllUserPage(pageable);
    }
	
	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
	}
	
	@PutMapping("/updateUserById/{id}")
	public User updateUser(@PathVariable Long id,@RequestBody User user) {
		return userService.updateUserById(id,user);
	}
	
	
	@PatchMapping("/patchUpdateUserById/{id}")
	public User patchUpdateUser(@PathVariable Long id,@RequestBody User user) {
		return userService.patchUpdateUserById(id,user);
	}
	
	@GetMapping("/findAllByName/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return userService.findAllByName(name);
    }	
	
	
	
	
	
	
	
	
	
	
	
}
