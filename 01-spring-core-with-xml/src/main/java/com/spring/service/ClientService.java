package com.spring.service;

public class ClientService {
	private ClientService() {
	}
	
	private static ClientService clientService;
	
	public static ClientService getInstance() {
		if(clientService == null) {
			clientService = new ClientService();
		}
		return clientService;
	}
}
