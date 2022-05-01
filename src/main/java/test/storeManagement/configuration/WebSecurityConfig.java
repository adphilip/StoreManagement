package test.storeManagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        http.headers().frameOptions().disable();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("user1")
                        .password("password1")
                        .roles("STANDARD")
                        .build();

        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("user2")
                        .password("password2")
                        .roles("ADMIN", "STANDARD")
                        .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
