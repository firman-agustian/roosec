package com.hatimonline.code.roosec.util;


import java.util.Date;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hatimonline.code.roosec.domain.SystemUser;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

        @Override
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {
        	if (event.getApplicationContext().getParent() == null) {
        	   /* SystemUser a = new SystemUser();
                a.setUsername("admin");
                a.setPassword("admin");
                a.setUserWhoCreated(a);
                a.setUserWhoLastModified(a);
                a.setTimeCreated(new Date());
                a.setTimeLastModified(new Date());
                a.persist();*/
        	} else {
        		System.out.println(">>>>>>>>  Child started; ignoring");
        	}
        }
}