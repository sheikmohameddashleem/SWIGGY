package com.masai.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.Model.User;
import com.masai.Repository.UserRepository;

@Service
public class ManualUserDetailsSevice implements UserDetailsService {

	@Autowired
	private UserRepository uRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> user=uRepo.findByuserName(username);
		
		if(user.isEmpty())throw new UsernameNotFoundException("User not Found");
		
		User us=user.get();
		
//		ManualUserDetails mud=ne w ManualUserDetails(us);
		
		
		List<GrantedAuthority> auth=new ArrayList<>();
		
		SimpleGrantedAuthority sga=new SimpleGrantedAuthority("ROLE_"+us.getRole().toUpperCase());
		auth.add(sga);
		org.springframework.security.core.userdetails.User user1=new org.springframework.security.core.userdetails.User(us.getUserName(),us.getPassword(),auth);
		return user1;
	}

}
