package com.hatimonline.code.roosec.web.admin;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.hatimonline.code.roosec.domain.SystemUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "admin/systemusers", formBackingObject = SystemUser.class)
@RequestMapping("/admin/systemusers")
@Controller
public class SystemUserController {
}
