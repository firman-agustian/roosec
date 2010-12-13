package com.hatimonline.code.roosec.domain;

import com.hatimonline.code.roosec.domain.BaseEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooEntity
public class SystemUser extends BaseEntity {

    @NotNull
    @Column(unique = true)
    @Size(min = 5, max = 30)
    private String username;
}
