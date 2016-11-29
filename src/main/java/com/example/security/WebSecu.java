package com.example.security;

import com.example.security.user.UserService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.inject.Inject;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecu extends WebSecurityConfigurerAdapter {
    
    @Inject
	UserService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/public/**", "/css/**","/fronts/**","/js/**","/lib/**","/inscription","/persiUtilisateur").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                ;
        http
                .formLogin()
                .and()
                .logout() // NB: CSRF will disallow visiting GET /logout manually
                ;
        http.authorizeRequests()
                .anyRequest().authenticated();

    }
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {    
            auth
		  .userDetailsService(userDetailsService)
		  .passwordEncoder(userDetailsService.encoder);
	}

}
