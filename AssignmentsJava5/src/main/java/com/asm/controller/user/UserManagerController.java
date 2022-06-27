package com.asm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userStaff/")
public class UserManagerController {
    @Autowired
    private HttpSession session;
    @GetMapping(value = "/logout")
    public String logout(Model model) {
        session.removeAttribute("accountKH");
        return "redirect:/public/home" + "?successLogout=1";
    }
}
