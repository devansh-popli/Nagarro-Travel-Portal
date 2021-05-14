package com.travel.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.travel.config.userPrincipal;
import com.travel.model.TravelModel;
import com.travel.repository.TravelRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private TravelRepository userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("uname"+username);
		TravelModel user=userrepo.findByUsername(username);
	 System.out.println("user found"+user);
		if (user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("User 404");
		} else {
			System.out.println("calling else");
			return new userPrincipal(user);
		}
	}
}