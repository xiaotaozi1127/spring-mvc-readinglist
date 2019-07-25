package com.taohui.readinglist;

//import com.taohui.readinglist.Entity.Reader;
//import com.taohui.readinglist.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
////                .and().csrf().disable();

        http.authorizeRequests()
                .antMatchers("/readingList").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                Optional<Reader> reader = readerRepository.findById(username);
//                if(reader.get() != null)
//                {
//                    return reader.get();
//                }
//                throw new UsernameNotFoundException("User '" + username + "' not found.");
//            }
//        })
//        .passwordEncoder(new CustomPasswordEncoder());

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("READER")
        .and()
        .passwordEncoder(new CustomPasswordEncoder());
    }
}
