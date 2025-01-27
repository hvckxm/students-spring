package com.students.security.settings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.students.domain.entities.Role;
import com.students.domain.entities.User;

public class CustomUserDetails implements UserDetails {
     private final User user;

     public CustomUserDetails(User user) {
          this.user = user;
     }

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
          List<Role> roles = user.getRoles();
          List<SimpleGrantedAuthority> authorities = new ArrayList<>();

          for (Role role : roles) {
               authorities.add(new SimpleGrantedAuthority(role.getName()));
          }

          return authorities;
     }

     @Override
     public String getPassword() {
          return user.getPassword();
     }

     @Override
     public String getUsername() {
          return user.getEmail();
     }

     @Override
     public boolean isAccountNonExpired() {
          return true;
     }

     @Override
     public boolean isAccountNonLocked() {
          return true;
     }

     @Override
     public boolean isCredentialsNonExpired() {
          return true;
     }

     @Override
     public boolean isEnabled() {
          return true;
     }

     public String getFullName() {
          return user.getFirstName() + " " + user.getLastName();
     }
}
