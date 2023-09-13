package net.jwtStudy.JWTStudy.Security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {
    private final long id;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final boolean enabled;
    private final Date lastPassworResetDate;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(long id, String username, String firstname, String lastname, String email, String password, boolean enabled, Date lastPassworResetDate, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.lastPassworResetDate = lastPassworResetDate;
        this.authorities = authorities;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Date getLastPassworResetDate() {
        return lastPassworResetDate;
    }
    public boolean getEnabled(){
        return enabled;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
