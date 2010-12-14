package com.hatimonline.code.roosec.web.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hatimonline.code.roosec.domain.SystemUser;

@RooWebScaffold(path = "admin/systemusers", formBackingObject = SystemUser.class)
@RequestMapping("/admin/systemusers")
@Controller
public class SystemUserController {
	@Autowired  
	private Validator systemUserValidator;  
	  
	@InitBinder  
	  
	protected void initBinder(WebDataBinder binder) {  
	  
	binder.setValidator(systemUserValidator);  
	  
	} 
}
