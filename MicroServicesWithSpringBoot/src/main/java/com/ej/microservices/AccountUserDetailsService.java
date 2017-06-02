/**
 * 
 */
package com.ej.microservices;

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
class AccountUserDetailsService implements UserDetailsService {
	
	private AccountRepository accountRepository;

	@Autowired
	public AccountUserDetailsService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.accountRepository.findByUsername(username)
				.map(account -> new User(account.getUsername(),
						account.getPassword(),
						account.isActive(),account.isActive(),account.isActive(),account.isActive(),
						AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER")
						))
				.orElseThrow(() -> new UsernameNotFoundException("coudn't find " + username + "!"));
	}

}
