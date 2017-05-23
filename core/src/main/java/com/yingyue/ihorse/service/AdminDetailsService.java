package com.yingyue.ihorse.service;

import com.yingyue.ihorse.base.AdminDetails;
import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AdminDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByAccountNumber(username);
		if (admin == null)
			throw new UsernameNotFoundException(String.format("Admin %s does not exist!", username));
		Set<GrantedAuthority> authorities = new HashSet<>();
		admin.getAdminRole().getAuthorities().stream().forEach(authorities::add);
		UserDetails userDetails = new AdminDetails(admin, authorities);
		return userDetails;
	}

	public Admin loadAdmin(String username){
		Admin admin = adminRepository.findByAccountNumber(username);
		return admin;
	}
}
