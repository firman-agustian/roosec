// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.hatimonline.code.roosec.web.admin;

import com.hatimonline.code.roosec.domain.SystemUser;
import com.hatimonline.code.roosec.domain.SystemUserGroup;
import java.io.UnsupportedEncodingException;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect SystemUserGroupController_Roo_Controller {
    
    @Autowired
    private GenericConversionService SystemUserGroupController.conversionService;
    
    @RequestMapping(method = RequestMethod.POST)
    public String SystemUserGroupController.create(@Valid SystemUserGroup systemUserGroup, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("systemUserGroup", systemUserGroup);
            addDateTimeFormatPatterns(model);
            return "admin/systemusergroups/create";
        }
        systemUserGroup.persist();
        return "redirect:/admin/systemusergroups/" + encodeUrlPathSegment(systemUserGroup.getId().toString(), request);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String SystemUserGroupController.createForm(Model model) {
        model.addAttribute("systemUserGroup", new SystemUserGroup());
        addDateTimeFormatPatterns(model);
        return "admin/systemusergroups/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String SystemUserGroupController.show(@PathVariable("id") Long id, Model model) {
        addDateTimeFormatPatterns(model);
        model.addAttribute("systemusergroup", SystemUserGroup.findSystemUserGroup(id));
        model.addAttribute("itemId", id);
        return "admin/systemusergroups/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String SystemUserGroupController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model model) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            model.addAttribute("systemusergroups", SystemUserGroup.findSystemUserGroupEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) SystemUserGroup.countSystemUserGroups() / sizeNo;
            model.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            model.addAttribute("systemusergroups", SystemUserGroup.findAllSystemUserGroups());
        }
        addDateTimeFormatPatterns(model);
        return "admin/systemusergroups/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String SystemUserGroupController.update(@Valid SystemUserGroup systemUserGroup, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("systemUserGroup", systemUserGroup);
            addDateTimeFormatPatterns(model);
            return "admin/systemusergroups/update";
        }
        systemUserGroup.merge();
        return "redirect:/admin/systemusergroups/" + encodeUrlPathSegment(systemUserGroup.getId().toString(), request);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String SystemUserGroupController.updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("systemUserGroup", SystemUserGroup.findSystemUserGroup(id));
        addDateTimeFormatPatterns(model);
        return "admin/systemusergroups/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String SystemUserGroupController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model model) {
        SystemUserGroup.findSystemUserGroup(id).remove();
        model.addAttribute("page", (page == null) ? "1" : page.toString());
        model.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/admin/systemusergroups?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
    @ModelAttribute("systemusers")
    public Collection<SystemUser> SystemUserGroupController.populateSystemUsers() {
        return SystemUser.findAllSystemUsers();
    }
    
    Converter<SystemUser, String> SystemUserGroupController.getSystemUserConverter() {
        return new Converter<SystemUser, String>() {
            public String convert(SystemUser systemUser) {
                return new StringBuilder().append(systemUser.getTimeCreated()).append(" ").append(systemUser.getTimeLastModified()).append(" ").append(systemUser.getPassword()).toString();
            }
        };
    }
    
    Converter<SystemUserGroup, String> SystemUserGroupController.getSystemUserGroupConverter() {
        return new Converter<SystemUserGroup, String>() {
            public String convert(SystemUserGroup systemUserGroup) {
                return new StringBuilder().append(systemUserGroup.getTimeCreated()).append(" ").append(systemUserGroup.getTimeLastModified()).toString();
            }
        };
    }
    
    @PostConstruct
    void SystemUserGroupController.registerConverters() {
        conversionService.addConverter(getSystemUserConverter());
        conversionService.addConverter(getSystemUserGroupConverter());
    }
    
    void SystemUserGroupController.addDateTimeFormatPatterns(Model model) {
        model.addAttribute("systemUserGroup_timecreated_date_format", DateTimeFormat.patternForStyle("SS", LocaleContextHolder.getLocale()));
        model.addAttribute("systemUserGroup_timelastmodified_date_format", DateTimeFormat.patternForStyle("SS", LocaleContextHolder.getLocale()));
    }
    
    private String SystemUserGroupController.encodeUrlPathSegment(String pathSegment, HttpServletRequest request) {
        String enc = request.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
