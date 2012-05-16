package com.ebi.formation.mfb.dao;

import org.springframework.security.core.userdetails.UserDetails;

public interface IPersonDao {

	UserDetails findUserDetailsByUsername(String username);
}
