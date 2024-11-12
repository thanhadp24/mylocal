package com.shopapp.admin.security;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String dirName = "user-photos";
		Path userPhotoDir = Paths.get(dirName);
		
		String userPhotoPath = userPhotoDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/" + dirName + "/**")
				.addResourceLocations("file:/" + userPhotoPath + "/");
		
		String categoryDirName = "../category-images"; 
		Path catePhotoDir = Paths.get(categoryDirName);
		
		String catePhotoPath = catePhotoDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/category-images/**")
				.addResourceLocations("file:/" + catePhotoPath + "/");
		
	}
	
	private void configResourceHandler(String dirName, ResourceHandlerRegistry registry) {
		Path userPhotoDir = Paths.get(dirName);
		
		String photoPath = userPhotoDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/" + dirName + "/**")
				.addResourceLocations("file:/" + photoPath + "/");
	}
}
