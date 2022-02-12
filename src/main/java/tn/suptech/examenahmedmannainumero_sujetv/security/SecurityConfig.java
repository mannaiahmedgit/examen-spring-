package tn.suptech.examenahmedmannainumero_sujetv.security;/*package tn.suptech.examenahmedmannainumero_sujetv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //in memory authentification
       /* auth.inMemoryAuthentication().withUser("ahmed").password("{noop}123").roles("admin");
        auth.inMemoryAuthentication().withUser("rafik").password("{noop}123").roles("user");*/
        //jdbc authentification
       /* PasswordEncoder passwordEncoder = passwordEncoder();
        System.out.println("*******************************************************************************************************************");
        System.out.println(passwordEncoder.encode("123"));
        auth.inMemoryAuthentication().withUser("ahmed").password(passwordEncoder.encode("123")).roles("admin");
        auth.inMemoryAuthentication().withUser("rafik").password(passwordEncoder.encode("123")).roles("user");

    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        //http.httpBasic();
      //  http.authorizeRequests().anyRequest().authenticated();

        http.authorizeRequests().anyRequest().authenticated();
       // http.csrf(); //actvatio de mecanme contre attaque csrf
        //http.csrf().disable(); //desactiver
    }
   // @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
*/
public class SecurityConfig{

}