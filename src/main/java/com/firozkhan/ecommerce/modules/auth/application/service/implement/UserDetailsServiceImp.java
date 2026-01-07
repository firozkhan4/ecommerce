package com.firozkhan.ecommerce.modules.auth.application.service.implement;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.firozkhan.ecommerce.modules.auth.domain.entity.UserDetailsAdapter;
import com.firozkhan.ecommerce.modules.auth.infrastructure.port.UserQueryPort;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UserQueryPort userQueryPort;

    public UserDetailsServiceImp(UserQueryPort userQueryPort) {
        this.userQueryPort = userQueryPort;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userQueryPort.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));

        return new UserDetailsAdapter(user);
    }

}
