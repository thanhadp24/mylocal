package com.shopapp.admin.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shopapp.admin.exception.UserNotFoundException;
import com.shopapp.common.entity.User;

public interface UserService{
	List<User> getAll();
	
	User getUserByEmail(String email);
	
	User get(int id) throws UserNotFoundException;
	
	Page<User> getByPage(int pageNum, String sortField, String sortDir, String keyword);
	
	int countTotalPages();

	User save(User user);
	
	User updateAccount(User userInform);
	
	void delete(Integer id) throws UserNotFoundException;
	
	boolean isEmailUnique(Integer id, String email);
	
	void updateEnabledStatus(Integer id, boolean enabled);
}
