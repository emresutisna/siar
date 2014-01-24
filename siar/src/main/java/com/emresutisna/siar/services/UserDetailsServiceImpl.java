package com.emresutisna.siar.services;

import java.util.ArrayList;
import java.util.Collection;

//import javax.faces.bean.ManagedProperty;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emresutisna.siar.model.Role;
import com.emresutisna.siar.model.StatusUser;
import com.emresutisna.siar.model.UserEntity;

@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userService.getByUsername(username);
		if(user != null){
			String password = user.getPassword();
			boolean enabled = user.getStatus().equals(StatusUser.ACTIVE);
			boolean accountNonExpired = user.getStatus().equals(StatusUser.ACTIVE);
			boolean credentialsNonExpired = user.getStatus().equals(StatusUser.ACTIVE);
			boolean accountNonLocked = user.getStatus().equals(StatusUser.ACTIVE);
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role : user.getRoles()){
				authorities.add(new GrantedAuthorityImpl(role.getNamaRole()));
			}
			User securityUser = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			userService.setLoggedinUser(user);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("User " + username + " tidak ditemukan");
		}
	}
}