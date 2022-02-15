package tn.suptech.examenahmedmannainumero_sujetv.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        private UserDetailsService userDetailsService;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable();
       http.formLogin();
       http.authorizeRequests().antMatchers("/gestionUser/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionClass/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionEleveClass/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionEnseignantMatiereClasseClass/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionExamenClass/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionExamen/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionMatiere/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionModule/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionNiveau/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/bulletin/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers("/gestionSemestre/**").hasAuthority("Admin");
       http.authorizeRequests().antMatchers(HttpMethod.POST,"/gestionNotes/**").hasAuthority("en");
       http.authorizeRequests().antMatchers(HttpMethod.GET,"/gestionNotes/**").hasAuthority("el");

       http.authorizeRequests().anyRequest().authenticated();



    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }


}
