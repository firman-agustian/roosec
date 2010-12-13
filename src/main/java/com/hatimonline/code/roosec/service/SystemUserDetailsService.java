package com.hatimonline.code.roosec.service;

import javax.persistence.NoResultException;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hatimonline.code.roosec.domain.SystemUser;

@Service("systemUserDetailsService")
public class SystemUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		if (username.isEmpty()) {
			throw new UsernameNotFoundException(
					"null user not found in the system");
		}

		SystemUser user = null;
		try {

			user = (SystemUser) SystemUser.findSystemUsersByUsername(username)
					.getSingleResult();
		} catch (NoResultException nre) { // - if there is no result
			throw new UsernameNotFoundException(
					"username/password not found in the system");
		}
		// non unique stuff will never occur
		// query timeout i am not sure if it will occur
		// TODO
		return (UserDetails) user;
	}

}