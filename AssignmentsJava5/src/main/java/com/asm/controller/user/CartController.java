package com.asm.controller.user;

import com.asm.dto.request.CheckoutRequest;
import com.asm.dto.request.UserRequest;
import com.asm.entity.User;
import com.asm.service.ICartService;
import com.asm.service.ICheckoutService;
import com.asm.service.IDrinkingCupsService;
import com.asm.service.implement.CheckoutService;
import com.asm.service.implement.UserDetailImplUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
@Controller
@RequestMapping("/user")
public class CartController {
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
    @Autowired
    HttpSession session;

    @GetMapping(value = "/cart")
    public String cart(Model model) {
        UserDetailImplUser userDetails1 = (UserDetailImplUser) session.getAttribute("accountKH");
        if(userDetails1==null){
            return "redirect:/public/login" + "?Error=1";
        }
        model.addAttribute("view", "/WEB-INF/views/user/cart.jsp");
        return "user/index";
    }

    @GetMapping("/delete/{productId}")
    public String delete(Model model, @PathVariable int productId) {
        iCartService.removeProduct(productId);
        return "redirect:/user/cart";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(Model model) {
        iCartService.removeProducts();
        return "redirect:/user/cart";
    }

    @GetMapping("/addToCart/{productId}")
    public String addToCart(Model model, @PathVariable int productId) {
        UserDetailImplUser userDetails1 = (UserDetailImplUser) session.getAttribute("accountKH");
        if(userDetails1==null){
            return "redirect:/public/login" + "?Error=1";
        }
        iCartService.addToCart(productId, 1);
        return "redirect:/public/home"+"?successAddToCart=1";
    }

    @PostMapping("/updateDown/{productId}")
    public String updateToCart(Model model, @PathVariable int productId) {
        iCartService.changeProductQuantity(productId);
        return "redirect:/user/cart";
    }

    @PostMapping("/updateUp/{productId}")
    public String updateToCartUp(Model model, @PathVariable int productId) {
        iCartService.changeProductQuantityUp(productId);
        return "redirect:/user/cart";
    }

    @PostMapping("/checkoutCart")
    public String checkoutToCart(Model model) {
        iCheckoutService.insertBillDetail();
        return "redirect:/user/checkout"+"?successCheckoutCart=1";
    }

    @GetMapping(value = "/checkout")
    public String checkout(Model model,@Valid User request) {

        httpServletRequest.setAttribute("view", "/WEB-INF/views/user/checkout.jsp");
        return "user/index";
    }
}
