package stcManager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import stcManager.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser =userRepository.findByUsername(username);
		if(appUser==null) {
			throw new UsernameNotFoundException("Could not find User");
		}
        UserDetails userDetails = User.withUsername(appUser.getUsername()).password(appUser.getPassword()).authorities("USER").build();
        return userDetails;
	}
	
}
