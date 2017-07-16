package com.aralmighty.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.aralmighty.model.SiteUser;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, SiteUser>{

	@Override
	public void initialize(PasswordMatch constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(SiteUser user, ConstraintValidatorContext context) {
		String plainPassword = user.getPlainPassword();
		String repeatPassword = user.getRepeatPassword();
		
		if (plainPassword==null || plainPassword.length() == 0) {
			return true;
		}
		
		return plainPassword.equals(repeatPassword);
	}

}
