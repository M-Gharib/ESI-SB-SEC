package com.esi.jpa.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 

@CrossOrigin // you need  a CrossOrigin annotation
@RestController
public class SecController {

  @GetMapping("/authenticate")
    public List<String> authenticate() {

        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication().getPrincipal();
        List<String> roles = new ArrayList<>();
        if (principal instanceof MyUserDetails) {
            UserDetails details = (MyUserDetails) principal;
            for (GrantedAuthority authority: details.getAuthorities())
                roles.add(authority.getAuthority());
        }

        return roles;
    }

    @GetMapping("/")
    public String publicAPI(){
    return "Hi, this is a public API";
    }


    @GetMapping("/auth")
    public String authenticatedAPI(){
        return "Hi, you are authenticated";
    }

    @GetMapping("/user")
    public String userAPI(){
        return "Hi, you are a user/admin";
    } 
 
    @GetMapping("/admin")
    public String adminAPI(){
        return "Hi, you are an admin";
    } 


}

    

