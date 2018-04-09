package cn.diconet.cms.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\9 0009
 */
@Configuration
@EnableOAuth2Sso
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许所有用户访问"/"和"/home"
        //http.csrf().disable();
        http.antMatcher("/**")
            // 所有请求都得经过认证和授权
            .authorizeRequests().anyRequest().authenticated()
            .and().authorizeRequests().antMatchers("/login", "/oauth/**","/anon").permitAll()
            .and()
            // 这里之所以要禁用csrf，是为了方便。
            // 否则，退出链接必须要发送一个post请求，请求还得带csrf token
            // 那样我还得写一个界面，发送post请求
            .csrf().disable()
            // 退出的URL是/logout
            .logout().logoutUrl("/logout").permitAll()
            // 退出成功后，跳转到/路径。
            .logoutSuccessUrl("/login");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/global/**");
    }
}
