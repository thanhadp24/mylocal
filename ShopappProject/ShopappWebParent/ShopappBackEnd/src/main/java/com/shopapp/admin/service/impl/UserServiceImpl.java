package com.shopapp.admin.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopapp.admin.common.Common;
import com.shopapp.admin.exception.UserNotFoundException;
import com.shopapp.admin.repository.UserRepository;
import com.shopapp.admin.service.UserService;
import com.shopapp.common.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<User> getAll() {
		return userRepository.findAll(Sort.by("firstName").ascending());
	}
	
	@Override
	public int countTotalPages() {
		return userRepository.findAll(PageRequest.ofSize(Common.USERS_PER_PAGE)).getTotalPages();
	}
	
	@Override
	public Page<User> getByPage(int pageNum, String sortField, String sortDir, String keyword) {
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending(): sort.descending();
		
		Pageable pageable = PageRequest.of(pageNum - 1, Common.USERS_PER_PAGE, sort);
		
		if (keyword != null) {
			return userRepository.findAll(keyword, pageable);
		}
		return userRepository.findAll(pageable);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}
	
	@Override
	public User get(int id) throws UserNotFoundException{
		try {
			return userRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("Could not found any user with ID = " + id);
		}
	}
	
	@Override
	public User save(User user) {
		boolean isUpdatingUser = (user.getId() != null);
		if (isUpdatingUser) {
			if (user.getPassword().isEmpty()) {
				User existingUser = userRepository.findById(user.getId()).get();
				user.setPassword(existingUser.getPassword());
			}else {
				encode(user);
			}
		}else {
			encode(user);
		}
		
		return userRepository.save(user);
	}
	
	@Override
	public User updateAccount(User userInform) {
		User userInDb = userRepository.findById(userInform.getId()).get();
		
		if(!userInform.getPassword().isEmpty()) {
			userInDb.setPassword(userInform.getPassword());
			encode(userInDb);
		}
		
		if(userInform.getPhotos() != null) {
			userInDb.setPhotos(userInform.getPhotos());
		}
		
		userInDb.setFirstName(userInform.getFirstName());
		userInDb.setLastName(userInform.getLastName());
		
		return userInDb;
	}
	
	@Override
	public void delete(Integer id) throws UserNotFoundException {
		Long count = userRepository.countById(id);
		if (count == null || count == 0) {
			throw new UserNotFoundException("Could not find userId: " + id);
		}
		
		userRepository.deleteById(id);
	}
	
	@Override
	public boolean isEmailUnique(Integer id, String email) {
		User user = userRepository.getUserByEmail(email);

		if(user == null) return true;
		
		boolean idCreatingNew = (id == null);
		if(idCreatingNew) {
			if(user != null) {
				return false;
			}
		}else {
			if(user.getId() != id) {
				return false;
			}
		}
	
		return true;
	}
	
	@Override
	public void updateEnabledStatus(Integer id, boolean enabled) {
		userRepository.updateEnabledStatus(id, enabled);
	}
	
	private void encode(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
	}

}
