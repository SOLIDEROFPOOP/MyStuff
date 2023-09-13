package net.jwtStudy.JWTStudy.Security.jwt;

import net.jwtStudy.JWTStudy.Model.Role;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtTokenProvider {
    public String createToken(String username, List<Role> roles){

    }
    public Authentication getAuthentication(String token)
}
