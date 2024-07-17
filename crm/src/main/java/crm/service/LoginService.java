package crm.service;

import java.util.List;

import crm.model.User;
import crm.repository.UserRepository;

public class LoginService {
	
	private UserRepository userRepository = new UserRepository();
	
	public boolean checkLogin(String username, String password) {
		List<User> users = userRepository.getUserByUsernameAndPassword(username, password);
		return users.size() > 0 ? true : false;
	}
}
