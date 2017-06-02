/**
 * 
 */
package com.ej.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author eunsoojung
 *
 */
@Service
public class AccountUserDetailService implements UserDetailsService {
	
	private final AccountRepository accountRepository;
	
	@Autowired
	public AccountUserDetailService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.accountRepository.findByUsername(username)
				.map(account -> new User(account.getUsername(),
						account.getPassowrd(),
						account.isActive(),
						account.isActive(),
						account.isActive(),
						account.isActive(),
						AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")
						))
				.orElseThrow(() -> new UsernameNotFoundException("couldn't find " + username + "!"));
	}

}
