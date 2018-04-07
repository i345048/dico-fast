package cn.diconet.gateway;

import cn.diconet.gateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Administrator
 * @Package cn.diconet.gateway
 * @Description: 描述
 * @date 2018\4\3 000311:34
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@RestController
public class GatewayApplication {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
