package com.hatimonline.code.roosec.validators;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.hatimonline.code.roosec.domain.SystemUser;

@Component
public class SystemUserValidator extends LocalValidatorFactoryBean implements
		Validator {

	private static final Log logger = LogFactory
			.getLog(SystemUserValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return SystemUser.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		super.validate(target, errors);
		SystemUser user = (SystemUser) target;

		if (user != null) {
			
			
			if(user.getId() == null && SystemUser.findSystemUsersByUsername(user.getUsername()).getResultList().size() > 0)
			{
				errors.rejectValue("username",
						"systemuser.username.alreadyinuse",
						new String[] { user.getUsername() },
						"usename {0} is already in use");
			}
			
			if(user.getId() != null && SystemUser.findSystemUsersByUsername(user.getUsername()).getResultList().size() > 0 && ((SystemUser) SystemUser.findSystemUsersByUsername(user.getUsername()).getSingleResult()).getId().longValue() != user.getId().longValue())
			{
				errors.rejectValue("username",
						"systemuser.username.alreadyinuse",
						new String[] { user.getUsername() },
						"usename {0} is already in use");
				
			}
			// else , let it slide
		} else {
			errors.reject("systemuser.error", "WTF, What a Terrible Failure");
		}
	}
}
