package com.hatimonline.code.roosec.aspects;

import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.core.context.SecurityContextHolder;

import com.hatimonline.code.roosec.domain.BaseEntity;
import com.hatimonline.code.roosec.domain.SystemUser;

@Aspect
@Order(value = 2)
public class BaseEntityAspect {
	@Autowired
	MutableAclService mutableAclService;

	@Pointcut("execution(* com.hatimonline.code.roosec.domain.BaseEntity+.merge())")
	public void mergeEntity() {

	}

	@Pointcut("execution(* com.hatimonline.code.roosec.domain.BaseEntity+.persist())")
	public void persistEntity() {

	}

	@AfterReturning("com.hatimonline.code.roosec.aspects.BaseEntityAspect.persistEntity() && this(baseobject)")
	public void baseEntityPersistAcl(final BaseEntity baseobject) {
		// SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		// MutableAcl createAclCategory1 = mutableAclService.createAcl(new
		// ObjectIdentityImpl(baseobject));

	}

	@Before("com.hatimonline.code.roosec.aspects.BaseEntityAspect.persistEntity() && this(baseobject)")
	public void baseEntityPersist(BaseEntity baseobject) {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			Date current = new Date();
			baseobject.setTimeCreated(current);
			baseobject.setTimeLastModified(current);

			String userName = SecurityContextHolder.getContext()
					.getAuthentication().getName();

			baseobject.setUserWhoCreated((SystemUser) SystemUser
					.findSystemUsersByUsername(userName).getSingleResult());
			baseobject.setUserWhoLastModified(baseobject.getUserWhoCreated());
		}
		
	}

	// only modify last modified time and by user
	@Before("com.hatimonline.code.roosec.aspects.BaseEntityAspect.mergeEntity() && this(baseobject)")
	public void baseEntityMerge(BaseEntity baseobject) {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			Date current = new Date();
			baseobject.setTimeLastModified(current);
			String userName = SecurityContextHolder.getContext()
					.getAuthentication().getName();
			baseobject.setUserWhoLastModified((SystemUser) SystemUser
					.findSystemUsersByUsername(userName).getSingleResult());
		}
	}
}
