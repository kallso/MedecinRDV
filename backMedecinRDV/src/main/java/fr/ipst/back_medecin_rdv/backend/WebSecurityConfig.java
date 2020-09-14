package fr.ipst.back_medecin_rdv.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            /*.authorizeRequests()
            .antMatchers("/", "/home", "/api/greetings")
                .permitAll()
            .anyRequest().authenticated()
            .and()
                .cors().disable().cors()
            .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
                .logout()
                .permitAll();*/

            /* DISABLED ALL SECURITY  */
            .csrf().disable();
    }
}
