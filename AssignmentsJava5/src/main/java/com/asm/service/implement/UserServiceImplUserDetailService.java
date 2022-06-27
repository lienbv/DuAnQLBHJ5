package com.asm.service.implement;

import com.asm.entity.Account;
import com.asm.entity.User;
import com.asm.responsitory.AccountRepository;
import com.asm.responsitory.RoleRepository;
import com.asm.responsitory.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplUserDetailService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImplUserDetailService.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			 Account account = accountRepository.findByUsername(username);
			List<String> lstroles = roleRepository.findByRole(account.getId());

			String password = account.getPassword();
			long idUsser = account.getUser();
			Optional<User> optionalUser = userRepository.findById(idUsser);
			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
			String fullname= optionalUser.get().getFullname();
			String addess = optionalUser.get().getAddress();
			String email = optionalUser.get().getEmail();
			String phone = optionalUser.get().getPhoneNumber();

			for (String grantedAuthority : lstroles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(grantedAuthority);
				grantList.add(authority);
			}
			UserDetails userDetail = (UserDetails) new UserDetailImplUser(username, password, grantList,account.getId(),fullname, addess, email, phone);
			logger.info(userDetail.toString());

			return userDetail;
		} catch (Exception e) {
			throw new UsernameNotFoundException(username + " not found!");

		}
	}


}
