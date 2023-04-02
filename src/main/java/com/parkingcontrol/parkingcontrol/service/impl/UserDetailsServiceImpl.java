package com.parkingcontrol.parkingcontrol.service.impl;

import com.parkingcontrol.parkingcontrol.models.User;
import com.parkingcontrol.parkingcontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User userModel = userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userName));
        return new org.springframework.security.core.userdetails.User(userModel.getUsername(), userModel.getPassword(), true, true, true, true, userModel.getAuthorities());
    }
}
