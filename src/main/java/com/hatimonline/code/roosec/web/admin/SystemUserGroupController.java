package com.hatimonline.code.roosec.web.admin;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.hatimonline.code.roosec.domain.SystemUserGroup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "admin/systemusergroups", formBackingObject = SystemUserGroup.class)
@RequestMapping("/admin/systemusergroups")
@Controller
public class SystemUserGroupController {
}
