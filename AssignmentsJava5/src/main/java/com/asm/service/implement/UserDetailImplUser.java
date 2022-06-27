package com.asm.service.implement;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

public class UserDetailImplUser extends User {
    private Long id;
    private String fullname;
    private String address;
    private String email;
    private String phone;
    public UserDetailImplUser(String username, String password,Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


    public UserDetailImplUser(String username, String password, Collection<? extends GrantedAuthority> authorities,Long id, String fullname,
                              String address, String email, String phone) {
        super(username, password, authorities);
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }


    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    public Long getId(){
        return id;
    }
}
