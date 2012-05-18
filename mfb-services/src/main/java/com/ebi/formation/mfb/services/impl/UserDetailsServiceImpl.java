package com.ebi.formation.mfb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IPersonDao;

/**
 * Implémentation de l'interface UserDetailsService pour le login avec Spring Security
 * 
 * @author excilys
 * 
 */
@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IPersonDao dao;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = dao.findUserDetailsByUsername(username);
		if (userDetails == null) {
			StringBuilder builder = new StringBuilder("user ").append(username).append(" doesn't exist.");
			throw new UsernameNotFoundException(builder.toString());
		}
		return userDetails;
	}
}
