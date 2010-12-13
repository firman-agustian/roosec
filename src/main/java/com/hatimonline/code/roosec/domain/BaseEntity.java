package com.hatimonline.code.roosec.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.hatimonline.code.roosec.domain.SystemUser;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.validation.constraints.Past;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString(excludeFields={"userWhoCreated","timeCreated" ,"userWhoLastModified","timeLastModified", })
@RooEntity(mappedSuperclass = true, inheritanceType = "TABLE_PER_CLASS")
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private SystemUser userWhoCreated;

    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "SS")
    private Date timeCreated;

    @ManyToOne
    private SystemUser userWhoLastModified;

    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "SS")
    private Date timeLastModified;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
