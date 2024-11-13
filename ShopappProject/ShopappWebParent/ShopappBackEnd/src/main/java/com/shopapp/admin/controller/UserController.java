package com.shopapp.admin.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopapp.admin.common.Common;
import com.shopapp.admin.exception.UserNotFoundException;
import com.shopapp.admin.exporter.UserCsvExporter;
import com.shopapp.admin.exporter.UserExcelExporter;
import com.shopapp.admin.exporter.UserPdfExporter;
import com.shopapp.admin.service.RoleService;
import com.shopapp.admin.service.UserService;
import com.shopapp.admin.utils.FileUploadUtil;
import com.shopapp.common.entity.User;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/users")
	public String firstPage(Model model) {
		return getByPage(1, model, "firstName", "asc", null);
	}
	
	@GetMapping("/users/page/{pageNum}")
	public String getByPage(@PathVariable("pageNum") int pageNum, Model model,
				@Param("sortField") String sortField,
				@Param("sortDir") String sortDir,
				@Param("keyword") String keyword) {

		if(pageNum < 1) pageNum = 1;
		
		int totalPages = userService.countTotalPages();
		
		if (pageNum > totalPages) {
			pageNum = totalPages;
		}
		
		Page<User> usersPage = userService.getByPage(pageNum, sortField, sortDir, keyword);
		List<User> users = usersPage.getContent();
		
		long totalItems = usersPage.getTotalElements();
		
		long startCount = (pageNum - 1) * Common.USERS_PER_PAGE + 1;
		long endCount = startCount + Common.USERS_PER_PAGE - 1;
		
		if(endCount > totalItems) {
			endCount = totalItems;
		}
		
		String reverseSortDir = sortDir.equals("asc") ? "desc": "asc";
		
		model.addAttribute("startCount", startCount);
		model.addAttribute("endCount", endCount);
		model.addAttribute("currentPage", pageNum);
		
		model.addAttribute("users", users);
		model.addAttribute("totalPages", usersPage.getTotalPages());
		model.addAttribute("totalItems", totalItems);
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", reverseSortDir);
		model.addAttribute("keyword", keyword);
		
		return "users/users";
	}
	
	@GetMapping("/users/new")
	public String newUser(Model model) {
		User user = new User();
		user.setEnabled(true);
		
		model.addAttribute("roles", roleService.getAll());
		model.addAttribute("user", user);
		model.addAttribute("pageTitle", "Create new user");
		 
		return "users/user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes redirectAttributes,
			@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
		
		if(!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			
			user.setPhotos(fileName);
			User savedUser = userService.save(user);
			
			String uploadDir = "user-photos/" + savedUser.getId();

			FileUploadUtil.cleanDir(uploadDir);
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		}else {
			if (user.getPhotos().isEmpty()) {
				user.setPhotos(null);
			}
			userService.save(user);
		}
		
		redirectAttributes.addFlashAttribute("message", "User " + user.getFirstName() + " " + user.getLastName() + " has been saved successful");
		
		return getRedirectToAffectedUser(user);
	}

	private String getRedirectToAffectedUser(User user) {
		String firstPartOfEmail = user.getEmail().split("@")[0];
		return "redirect:/users/page/1?sortField=id&sortDir=asc&keyword=" + firstPartOfEmail;
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(RedirectAttributes redirectAttributes, 
			@PathVariable("id") Integer id, Model model) {
		try {
			User user = userService.get(id);
			
			model.addAttribute("user", user);
			model.addAttribute("roles", roleService.getAll());
			model.addAttribute("pageTitle", "Edit user (ID: " + id + ")");
			
			return "users/user_form";
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			return "redirect:/users";
		}
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id,
			RedirectAttributes redirectAttributes) {
		
		try {
			userService.delete(id);
			
			redirectAttributes.addFlashAttribute("message", "User with Id: " + id + " has been deleted!");
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/users";
	}
	
	@GetMapping("/users/{id}/enabled/{status}")
	public String enableUser(@PathVariable("id") Integer id,
			@PathVariable("status") boolean enable, RedirectAttributes redirectAttributes) {
		
		userService.updateEnabledStatus(id, enable);
		
		String status = enable ? "enabled": "disabled";
		String message = "The user ID " + id + " has been " + status;
		
		redirectAttributes.addFlashAttribute("message", message);
		
		return "redirect:/users";
	}
	
	@GetMapping("/users/export/csv")
	public void exportCsv(HttpServletResponse response) throws IOException {
		List<User> users = userService.getAll();
		UserCsvExporter csvExporter = new UserCsvExporter();
		csvExporter.exportCsvFile(users, response);
	}
	
	@GetMapping("/users/export/excel")
	public void exportExcel(HttpServletResponse response) throws IOException {
		List<User> users = userService.getAll();
		
		 UserExcelExporter excelExporter = new UserExcelExporter();
		 excelExporter.exportExcelFile(users, response);
	}
	
	@GetMapping("/users/export/pdf")
	public void exportPdf(HttpServletResponse response) throws IOException {
		List<User> users = userService.getAll();
		
		 UserPdfExporter pdfExporter = new UserPdfExporter();
		 pdfExporter.exportPdfFile(users, response);
	}
	
}
