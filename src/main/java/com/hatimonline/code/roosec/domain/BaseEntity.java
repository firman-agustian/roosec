package com.hatimonline.code.roosec.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString(excludeFields = { "userWhoCreated", "timeCreated",
		"userWhoLastModified", "timeLastModified", })
@RooEntity(mappedSuperclass = true, inheritanceType = "TABLE_PER_CLASS")
public abstract class BaseEntity {

	
	@ManyToOne
	@JoinColumn(insertable=true,updatable=false)
	private SystemUser userWhoCreated;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "SS")
	@Column(updatable=false,insertable=true)
	private Date timeCreated;

	@ManyToOne
	private SystemUser userWhoLastModified;



	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "SS")
	private Date timeLastModified;

}
