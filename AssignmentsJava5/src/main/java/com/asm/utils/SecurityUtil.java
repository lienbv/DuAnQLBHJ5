package com.asm.utils;

import com.asm.service.implement.UserDetailImplUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static UserDetailImplUser getPrincipal(){
        return (UserDetailImplUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
    }
}
