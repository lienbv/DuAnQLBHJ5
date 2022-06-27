package com.asm.controller;

import com.asm.service.ICartService;
import com.asm.service.ICheckoutService;
import com.asm.service.IDrinkingCupsService;
import com.asm.service.implement.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/public")
public class HomeController {
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    IDrinkingCupsService iDrinkingCupsService;
    @Autowired
    ICartService iCartService;
    @Autowired
    ICheckoutService iCheckoutService;
    @Autowired
    CheckoutService checkoutService;

    @GetMapping(value = "/index")
    public String index(Model model) {
        return "user/index";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        return iDrinkingCupsService.layout(model);
    }

    @GetMapping(value = "/editDrinkingcup")
    public String editDrinkingcup() {
        httpServletRequest.setAttribute("view", "/WEB-INF/views/user/detail.jsp");
        return "user/index";
    }

}
