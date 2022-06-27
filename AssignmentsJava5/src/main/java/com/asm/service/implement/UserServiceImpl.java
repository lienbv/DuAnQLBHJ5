package com.asm.service.implement;

import com.asm.config.MailConfig;
import com.asm.dto.request.ChangePass;
import com.asm.dto.request.EmailRequest;
import com.asm.dto.request.LoginRequest;
import com.asm.dto.request.UserRequest;
import com.asm.dto.response.EmailResponse;
import com.asm.dto.response.LoginResponse;
import com.asm.dto.response.UserResponse;
import com.asm.entity.Account;
import com.asm.entity.Role;
import com.asm.entity.User;
import com.asm.responsitory.AccountRepository;
import com.asm.responsitory.BillRepository;
import com.asm.responsitory.RoleRepository;
import com.asm.responsitory.UserRepository;
import com.asm.service.IUserService;
import com.asm.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private HttpSession session;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    BillRepository billRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String register(UserRequest userRequest, BindingResult bindingResult, Model model) {

        UserResponse userResponse = new UserResponse();
        User user = new User();
        Role role = new Role();
        List<User> userList = userRepository.findAll();

        Account Checkaccount = accountRepository.findByUsername(userRequest.getUsername());

        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setFullname(userRequest.getFullname());
        user.setCreateDate(new Date());
        user.setEmail(userRequest.getEmail());
        user.setStatus("EXISTS");
        user.setAddress(userRequest.getAddress());
        user.setImg(null);

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors().get(0).getDefaultMessage());
            model.addAttribute("messages_vi", userRequest);
            model.addAttribute("view", "/WEB-INF/views/user/register.jsp");
            return "user/index";
        }
        for (User users : userList) {
            if (users.getEmail().equals(userRequest.getEmail())) {
                session.setAttribute("errorEmail", "Email exist");
                model.addAttribute("view", "/WEB-INF/views/user/register.jsp");
                return "user/index";
            }
            if (users.getPhoneNumber().equals(userRequest.getPhoneNumber())) {
                session.setAttribute("errorPhoneNumber", "Phone exist");
                model.addAttribute("view", "/WEB-INF/views/user/register.jsp");
                return "user/index";
            }
        }
        if (Checkaccount != null) {
            session.setAttribute("errorUsename", "Account exist");
            model.addAttribute("view", "/WEB-INF/views/user/register.jsp");
            return "user/index";
        }
        if (!userRequest.getPassword().equals(userRequest.getRePassword())) {
            session.setAttribute("errorPass", "Pass not equal ");
            model.addAttribute("view", "/WEB-INF/views/user/register.jsp");
            return "user/index";
        }

        user = userRepository.save(user);
        role.setId(3L);
        Account account = new Account();
        account.setUsername(userRequest.getUsername());
        account.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        account.setUser(user.getId());
        account.setRole(3L);

        account = accountRepository.save(account);
        userResponse.setUsername(account.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setFullname(user.getFullname());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setAddress(user.getAddress());

        return "redirect:/public/home" + "?successRegister=1";
    }

    @Override
    public String login(LoginRequest loginRequest, BindingResult bindingResult, Model model) {

        LoginResponse response = new LoginResponse();
        List<Account> check = accountRepository.findAll();
        Account checkAccount = accountRepository.findByUsername(loginRequest.getUsername());
        Account checkPass = accountRepository.findByPassword(loginRequest.getPassword());

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors().get(0).getDefaultMessage());
            model.addAttribute("messages_vi", loginRequest);
            model.addAttribute("view", "/WEB-INF/views/user/login.jsp");
            return "user/index";
        }

        if (checkAccount == null) {
            session.setAttribute("errorUsename", "Account not Exist");
            model.addAttribute("view", "/WEB-INF/views/user/login.jsp");
            return "user/index";
        }
        if ((BCrypt.checkpw(loginRequest.getPassword(), checkAccount.getPassword())) == false) {
            session.setAttribute("errorPassword", "Incorrect password");
            model.addAttribute("view", "/WEB-INF/views/user/login.jsp");
            return "user/index";
        }


        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetailImplUser userDetails = (UserDetailImplUser) authentication
                    .getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            response.setUsername(userDetails.getUsername());
            response.setRoles(roles);

            if(roles.get(0).equals("USER")){
                session.setAttribute("accountKH", SecurityUtil.getPrincipal());
                Cookie cookieUserName = new Cookie("userNameCookie", SecurityUtil.getPrincipal().getUsername());
                cookieUserName.setMaxAge(600);
                return "redirect:/public/home" + "?successLogin=1";

            }else if(roles.get(0).equals("STAFF")){
                session.setAttribute("accountSTAFF", SecurityUtil.getPrincipal().getFullname());
                Cookie cookieUserName = new Cookie("userNameCookie", SecurityUtil.getPrincipal().getUsername());
                cookieUserName.setMaxAge(600);
                return "redirect:/staff/drinkingCups/getAll" + "?successLogin=1";
            }
            else {
                session.setAttribute("accountSTAFF", SecurityUtil.getPrincipal().getFullname());
                Cookie cookieUserName = new Cookie("userNameCookie", SecurityUtil.getPrincipal().getUsername());
                cookieUserName.setMaxAge(600);
                return "redirect:/staff/drinkingCups/getAll" + "?successLogin=1";
            }



        } catch (BadCredentialsException ex) {

            model.addAttribute("view", "/WEB-INF/views/user/login.jsp");
            return "user/index";
        }

    }
    @Override
    public String sendEmail(EmailRequest emailRequest, BindingResult bindingResult, Model model) {
        EmailResponse response = new EmailResponse();
        Account checkUsername = accountRepository.findByUsername(emailRequest.getUsername());
       User checkEMail=  userRepository.findEmailByUsername(emailRequest.getEmail());

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors().get(0).getDefaultMessage());
            model.addAttribute("user", emailRequest);
            model.addAttribute("view", "/WEB-INF/views/user/forgotPassword.jsp");
            return "user/index";
        }
        if (checkUsername == null) {
            session.setAttribute("errorUsername", "Username not exist");
            model.addAttribute("view", "/WEB-INF/views/user/forgotPassword.jsp");
            return "user/index";
        }
        if (checkEMail == null) {
            session.setAttribute("errorEmail", "Email ko hợp lệ");
            model.addAttribute("view", "/WEB-INF/views/user/forgotPassword.jsp");
            return "user/index";
        }
        try {
            String password = DataUtils.generateTempPwd(6);
            Map<String, Object> props = new HashMap<>();
            response.setProps(props);
            response.setTo(emailRequest.getEmail());
            response.setSubject("You've forgotten.You've forgotten the bile.You forgot your password.");
            checkUsername.setPassword(bCryptPasswordEncoder.encode(password));
            ChangePass changePasss = this.changePassword(checkUsername);

            if (changePasss == null) {
                model.addAttribute("view", "/WEB-INF/views/user/forgotPassword.jsp");
                return "user/index";
            }
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            String content = "<div style='width: 30%; background-color: wheat;" +
                    "height: 300px'><div style='text-align: center;font-weight: bold;" +
                    "color: black;padding-top: 20px;" +
                    "font-family: sans-serif; ' >You forgot your password." +
                    "<font style='color: red'>Your temporary password is</font>"+password+"</div>" +
                    "</div><div style='padding: 10px;padding-left: 50px'>Thời gian: <b>"+new Date() +"-2021</b></div>"+
                    "<div style='padding-top: 10px;text-align: center; color: blue;font-family: monospace;'>Nếu không phải bạn mời bỏ qua mail</div>";
            message.setContent(content, "text/html; charset=utf-8");
            helper.setTo(response.getTo());
            helper.setSubject(response.getSubject());

            mailSender.send(message);
            return "redirect:/public/home" + "?successForgot=1";
        } catch (MessagingException exp) {
            model.addAttribute("view", "/WEB-INF/views/user/forgotPassword.jsp");
            return "user/index";
        }
    }

    @Override
    public String getlistUserConfirm_Cancel(Model model) {

        List<Object[]> listObjectWaiting = billRepository.findBillUser(SecurityUtil.getPrincipal().getId());
        model.addAttribute("listOrderDrinkingCup_Waiting", listObjectWaiting);
        model.addAttribute("view", "/WEB-INF/views/user/waiting_cancel_confirm_User.jsp");
        return "admin/layout";
    }

    public ChangePass changePassword(Account reChangePass) {
        ChangePass response = new ChangePass();
        Account account = accountRepository.save(reChangePass);
        if (account == null) {
            return null;
        }
        response.setPassword(account.getPassword());
        response.setUsername(account.getUsername());
        return response;
    }


}
