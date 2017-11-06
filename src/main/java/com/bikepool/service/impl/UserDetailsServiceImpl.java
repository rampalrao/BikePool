package com.bikepool.service.impl;

import com.bikepool.dao.BikeUserDao;
import com.bikepool.dto.BikeUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by rampal on 5/11/17.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private BikeUserDao bikeUserDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername username=" + username);
        //cal Dao to get user details

        final BikeUser user=bikeUserDao.getBikeUser(username);

        if(user==null){
            throw new UsernameNotFoundException(username + " not found");
        }

        return new UserDetails() {
            private static final long serialVersionUID = 2059202961588104658L;

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
                auths.add(new SimpleGrantedAuthority("Admin"));
                return auths;
            }
        };
    }
}
