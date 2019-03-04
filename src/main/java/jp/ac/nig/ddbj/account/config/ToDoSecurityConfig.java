package jp.ac.nig.ddbj.account.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class ToDoSecurityConfig extends WebSecurityConfigurerAdapter {

    //Another way to override the user/password (another alternative to the spring.security.* properties
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("apress")
                .password(passwordEncoder().encode("springboot2"))
                .roles("ADMIN","USER");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers(
                        PathRequest
                                .toStaticResources()
                                .atCommonLocations()).permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                    .logoutRequestMatcher(
                            new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login");
    }



    // Skipping the authentication.

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/register/**"
        );
    }

}
