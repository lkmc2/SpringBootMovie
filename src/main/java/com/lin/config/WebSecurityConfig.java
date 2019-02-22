package com.lin.config;

import com.lin.utils.MyPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security 配置
 * @author lkmc2
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启Spring Security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 请求授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().headers().disable()
            .authorizeRequests()
            // 以下地址无需权限验证
            .antMatchers("/index", "/movie/**", "/website/**", "/movieDetail/**", "/aboutMe", "/static/**")
            .permitAll()
            // 其他地址需要验证权限
            .anyRequest().authenticated()
            .and()
            .formLogin()
            // 登陆成功跳转到/admin
            .defaultSuccessUrl("/admin")
            .permitAll()
            .and()
            // 退出成功跳转到/index
            .logout()
            .logoutSuccessUrl("/index")
            .permitAll();
    }

    // 用户认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .passwordEncoder(new MyPasswordEncoder())
            .withUser("admin")
            .password("123456")
            .roles("ADMIN");
    }

}
