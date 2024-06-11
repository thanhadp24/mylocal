package com.spring.service;

import java.util.Arrays;
import java.util.List;

import com.spring.bean.Item;

public class ItemServiceImpl implements ItemService{
	
	@Override
	public List<Item> getAll() {
		return Arrays.asList(new Item(1, "item 1"), new Item(2, "item 2"));
	}
	
	public void init() {
		System.out.println(">> Do some initialization work");
	}
	
	public void destroy() {
		System.out.println(">> Do some cleaning work");
	}
}
