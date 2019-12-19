package edu.mum.ea.config;

import edu.mum.ea.services.impl.UserDetailsServiceImpl;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/timeline", "/timeline/**")
                .hasRole("TIMELINE_PRIVILEGE")
                .antMatchers("/profile", "/user_profile", "/authenticated-user-info",
                        "/authenticated-user-follow-info", "/authenticated-user-profile-data/**",
                        "/searched-user-profile-data/**")
                .hasRole("PROFILE_PRIVILEGE")
                .antMatchers("/dashboard")
                .hasRole("DASHBOARD_PRIVILEGE")
                .antMatchers("/follow", "/who-to-follow", "/follow/**")
                .hasRole("FOLLOW_PRIVILEGE")
                .antMatchers("/user_claims", "/users_all")
                .hasRole("USER_MANAGEMENT_PRIVILEGE")
                .antMatchers("/filthy", "/filthy_words")
                .hasRole("FILTHY_PRIVILEGE")
                .antMatchers("/claim")
                .hasRole("CLAIM_PRIVILEGE")
                .antMatchers("/home", "/denied")
                .authenticated()
                .antMatchers("/", "/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true");
    }
}
