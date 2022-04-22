package com.esi.jpa.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.userDetailsService(userDetailsService)
    .passwordEncoder(getPasswordEncoder());
    }
    
    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    } 
        
    @Override 
    protected void configure(HttpSecurity http) throws Exception{
     http
    .httpBasic() 
    .and()
    .cors()
    .and().csrf().disable()
    .authorizeRequests()
    .antMatchers("/admin").hasAuthority("ADMIN") 
    .antMatchers("/user").hasAnyAuthority("ADMIN", "USER") 
    .antMatchers("/auth").authenticated()
    .antMatchers("/").permitAll()
    //.and().formLogin().permitAll();
    .and().formLogin().disable();
    } 
    
    
}
