package cn.diconet.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\9 0009
 */
@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {

    @RequestMapping("login")
    public String login(){
        return "index";
    }
    @Autowired
    private TokenEndpoint tokenEndpoint;

    @PostMapping("/login")
    public Result<OAuth2AccessToken> login(@RequestParam Map<String, String> parameters){
        try {
            log.info("login  start ......");
            parameters.put("grant_type","password");//设置授权类型为密码模式
            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//此处不能为空
            Authentication authentication = new UsernamePasswordAuthenticationToken("android", "android",grantedAuthorities);
            ResponseEntity<OAuth2AccessToken> responseEntity= tokenEndpoint.postAccessToken(authentication ,parameters);
            log.info("login  end ......");
            return  Result.ok(responseEntity.getBody());
        }catch (InvalidGrantException e){
            log.error("login error  用户名密码不正确 ....",e);
            return Result.error("用户名密码不正确");
        }
        catch (Exception e){
            log.error("login error ....",e);
            return Result.error(e.getMessage());
        }
    }
}
