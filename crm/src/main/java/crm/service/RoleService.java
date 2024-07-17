package crm.service;

import java.util.List;

import crm.model.Role;
import crm.repository.RoleRepository;

public class RoleService {
	
	private RoleRepository roleRepository = new RoleRepository();
	
	public List<Role> getAll(){
		return roleRepository.getAll();
	}
	
	public boolean deleteRoleById(int id) {
		return roleRepository.deleteRoleById(id) > 0;
	}
	
	public boolean addRole(String name, String desc) {
		return roleRepository.add(name, desc) > 0;
	}
}
