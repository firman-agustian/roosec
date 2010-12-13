package com.hatimonline.code.roosec.domain;

import java.util.Collection;
import com.hatimonline.code.roosec.domain.BaseEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString(excludeFields = { "userWhoCreated", "timeCreated", "userWhoLastModified", "timeLastModified" })
@RooEntity(finders = { "findSystemUsersByUsername" })
public class SystemUser extends BaseEntity implements UserDetails {

    @NotNull
    @Column(unique = true)
    @Size(min = 5, max = 30)
    private String username;

    private String password;

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    //TODO what are these things, so many similar things
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
