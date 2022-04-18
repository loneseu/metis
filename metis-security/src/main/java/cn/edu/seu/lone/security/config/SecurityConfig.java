package cn.edu.seu.lone.security.config;


import cn.edu.seu.lone.security.handle.MyAuthenticationFailureHandler;
import cn.edu.seu.lone.security.handle.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login.html")
                // 登录成功跳转页面必须是post请求
                //.successForwardUrl("/toMain")
                .successHandler(new MyAuthenticationSuccessHandler("https://www.baidu.com"))
                //.failureForwardUrl("/toError");
                .failureHandler(new MyAuthenticationFailureHandler("/error.html"));

        httpSecurity.authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .anyRequest().authenticated();

        httpSecurity.csrf().disable();
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
