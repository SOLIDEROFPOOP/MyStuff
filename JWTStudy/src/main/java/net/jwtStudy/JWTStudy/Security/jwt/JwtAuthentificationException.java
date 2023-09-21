package net.jwtStudy.JWTStudy.Security.jwt;

import javax.naming.AuthenticationException;

public class JwtAuthentificationException extends AuthenticationException {
    public JwtAuthentificationException(String explanation) {
        super(explanation);
    }

    public JwtAuthentificationException() {
    }
}