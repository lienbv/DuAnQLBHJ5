package com.asm.controller.user;

import com.asm.dto.Username;
import com.asm.dto.request.EmailRequest;
import com.asm.dto.request.LoginRequest;
import com.asm.dto.request.UserRequest;
import com.asm.entity.Drinkingcup;
import com.asm.entity.User;
import com.asm.responsitory.DrinkingcupRepository;
import com.asm.responsitory.UserRepository;
import com.asm.service.*;
import com.asm.service.implement.CheckoutService;
import com.asm.utils.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;

@Controller
@RequestMapping("/public")
public class UserController {
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
    IUserService iUserService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UploadFileService uploadFileService;
    @Autowired
    DrinkingcupRepository drinkingcupRepository;
    @Autowired
    IOrderService iOrderService;


    @GetMapping(value = "/login")
    public String getLogin(Model model, LoginRequest request) {
        model.addAttribute("user", request);
        model.addAttribute("view", "/WEB-INF/views/user/login.jsp");
        return "user/index";
    }

    @GetMapping(value = "/register")
    public String getRegister(Model model, UserRequest userRequest) {
        model.addAttribute("messages_vi", userRequest);
        model.addAttribute("view", "/WEB-INF/views/user/register.jsp");
        return "user/index";
    }

    @GetMapping(value = "/forgotPassword")
    public String getForgotpassword(Model model, EmailRequest request) {
        model.addAttribute("user", request);
        model.addAttribute("view", "/WEB-INF/views/user/forgotPassword.jsp");
        return "user/index";
    }
    @GetMapping(value = "/search")
    public String search(@RequestParam(name = "name", required = false) String name, Model model, Pageable pageable) {
        return this.iDrinkingCupsService.findByName(name, model,pageable);
    }
    @PostMapping(value = "/login")
    public String login(@Valid @ModelAttribute("user") LoginRequest request, BindingResult bindingResult, Model model) {
     return iUserService.login(request, bindingResult, model);
    }

    @PostMapping(value = "/register")
    public String register( @Valid @ModelAttribute("messages_vi") UserRequest userRequest, BindingResult bindingResult, Model model) {
        return iUserService.register(userRequest, bindingResult, model);
    }

    @PostMapping(value = "/forgotPassword")
    public String forgotPassword(@Valid @ModelAttribute("user") EmailRequest request, BindingResult bindingResult, Model model) {
        return iUserService.sendEmail(request, bindingResult,model);
    }

    @GetMapping(value = "/drinkingCups/{id}")
    public String getDrinkCups(Model model, @PathVariable("id") Long id) {
        Drinkingcup drinkingcup = this.drinkingcupRepository.findById(id).get();
        //httpServletRequest.setAttribute("drinkingCups", drinkingcup);
        model.addAttribute("drinkingCups", drinkingcup);
        model.addAttribute("view", "/WEB-INF/views/user/detail.jsp");
        return "user/index";
    }
    @GetMapping("/getBillUser")
    public String getBillStatusAll(Model model) {
        return iUserService.getlistUserConfirm_Cancel(model);
    }
}
