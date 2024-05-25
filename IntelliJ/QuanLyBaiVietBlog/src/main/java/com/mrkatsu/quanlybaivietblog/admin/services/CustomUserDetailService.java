package com.mrkatsu.quanlybaivietblog.admin.services;

import com.mrkatsu.quanlybaivietblog.admin.models.CustomeUserDetail;
import com.mrkatsu.quanlybaivietblog.admin.models.User;
import com.mrkatsu.quanlybaivietblog.admin.models.UserRole;
import com.mrkatsu.quanlybaivietblog.admin.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<GrantedAuthority> authorities = new HashSet<>();

        Set<UserRole> roles = user.getUserRoles();
        for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().getName()) );
        }
        return new CustomeUserDetail(user, authorities);
    }
}
