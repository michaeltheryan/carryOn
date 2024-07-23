package com.michaelryan.carryon.config;

import com.michaelryan.carryon.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(("/register/**")).permitAll()
                        //.requestMatchers(("/register**")).permitAll()
                        .requestMatchers(("/index/**")).permitAll()
                        .requestMatchers(("/about/**")).permitAll()
                        .requestMatchers(("/auction/**")).permitAll()
                        .requestMatchers(("/contact/**")).permitAll()
                        .requestMatchers(("/error/**")).permitAll()
                        .requestMatchers(("/privacy/**")).permitAll()
                        .requestMatchers(("/profile/**")).permitAll()
                        .requestMatchers(("/purchase/**")).permitAll()
                        .requestMatchers(("/search/**")).permitAll()
                        .requestMatchers(("/search_results/**")).permitAll()
                        .requestMatchers(("/user_agreement/**")).permitAll()
                        .requestMatchers(("/**")).permitAll()
                        .requestMatchers(("https://flight-info-api.p.rapidapi.com/**")).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(
                        form   -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/index")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }
}
