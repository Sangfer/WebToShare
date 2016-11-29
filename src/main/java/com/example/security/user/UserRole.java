/*
 * 
 */

package com.example.security.user;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author 
 */
public enum UserRole implements GrantedAuthority {
    
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_"+this.name();
    }
}
