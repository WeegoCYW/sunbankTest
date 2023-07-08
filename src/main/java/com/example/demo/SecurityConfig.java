package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/register","/index").permitAll() // 允許訪問註冊&index頁面
                .anyRequest().authenticated() // 其他請求需要驗證
            )
            .formLogin((formLogin) -> formLogin
                .loginPage("/login") // 自定義登入頁面的 URL
                .permitAll()
                .failureUrl("/index")
                .defaultSuccessUrl("/index")// 登入成功後導向 index
            )
            .logout((logout) -> logout
                .permitAll()
            );
        return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/ignore");
    }

}
