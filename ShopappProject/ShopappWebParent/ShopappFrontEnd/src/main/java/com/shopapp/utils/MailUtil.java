package com.shopapp.utils;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.shopapp.common.bean.EmailSettingBag;

import jakarta.servlet.http.HttpServletRequest;

public class MailUtil {
	
	public static String getSiteURL(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		return url.replace(request.getServletPath(), "");
	}
	
	public static JavaMailSenderImpl mailSenderImpl(EmailSettingBag settingBag) {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		
		mailSenderImpl.setHost(settingBag.getHost());
		mailSenderImpl.setPort(settingBag.getPort());
		mailSenderImpl.setUsername(settingBag.getUsername());
		mailSenderImpl.setPassword(settingBag.getPassword());
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", settingBag.getSmtpAuth());
		props.setProperty("mail.smtp.starttls.enable", settingBag.getSmtpSecured());
		
		mailSenderImpl.setJavaMailProperties(props);
		
		return mailSenderImpl;
	}
}
