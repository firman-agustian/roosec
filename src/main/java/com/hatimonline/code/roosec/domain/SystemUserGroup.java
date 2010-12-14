package com.hatimonline.code.roosec.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooEntity
public class SystemUserGroup extends BaseEntity {

    @NotNull
    @Column(unique = true)
    @Size(max = 30)
    private String groupName;
}
