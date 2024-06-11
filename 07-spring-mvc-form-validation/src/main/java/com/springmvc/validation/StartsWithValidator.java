package com.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartsWithValidator implements ConstraintValidator<StartsWith, String>{
	
	private String prefix;
	
	@Override
	public void initialize(StartsWith startsWith) {
		prefix = startsWith.prefix();
	} 
	
	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		if(input == null) {
			return false;
		}
		return input.startsWith(prefix);
	}
}
