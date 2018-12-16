package ru.trainee.adminpanel.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.trainee.adminpanel.data.repository.UserRepository;
import ru.trainee.adminpanel.service.CustomUserDetailService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/admin/**", "/admin/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .csrf().disable();
    }

    private PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}