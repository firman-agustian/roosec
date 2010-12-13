package com.hatimonline.code.roosec.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;

@RooJavaBean
@RooToString
@RooEntity(mappedSuperclass = true, inheritanceType = "TABLE_PER_CLASS")
public class BaseEntity {
}
