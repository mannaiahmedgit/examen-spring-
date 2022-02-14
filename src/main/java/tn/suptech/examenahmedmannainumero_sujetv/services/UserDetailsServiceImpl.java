package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.*;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService ;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);
        Collection<GrantedAuthority>  authorities = new ArrayList<>() ;
        String roleName= "";


            if(user.getClass().equals(Admnistrateur.class)) {
                roleName="admin";
            }
            else if (user.getClass().equals(Enseignant.class)) {
                roleName="en" ;
            }
            else {
                roleName = "el";
            }
        authorities.add(new SimpleGrantedAuthority(roleName));

        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),authorities);
    }
}
