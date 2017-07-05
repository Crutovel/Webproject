package com.softserve.edu.webproject.authentication;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.webproject.entity.Account;
import com.softserve.edu.webproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyDBAuthenticationService implements UserDetailsService {

    private final AccountService accountService;

    @Autowired
    public MyDBAuthenticationService(AccountService accountService) {
        this.accountService = accountService;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findAccountByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        // EMPLOYEE,MANAGER,..
        String role = account.getUserRole();
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        // ROLE_EMPLOYEE, ROLE_MANAGER
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
        grantList.add(authority);
        boolean enabled = account.isActive();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(account.getUserName(),
                account.getPassword(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, grantList);
    }

}