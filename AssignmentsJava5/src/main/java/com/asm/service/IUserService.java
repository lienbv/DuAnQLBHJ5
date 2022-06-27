package com.asm.service;

import com.asm.dto.request.EmailRequest;
import com.asm.dto.request.LoginRequest;
import com.asm.dto.request.UserRequest;
import com.asm.dto.response.LoginResponse;
import com.asm.dto.response.UserResponse;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface IUserService {
String register(UserRequest userRequest, BindingResult bindingResult, Model model);
String login(LoginRequest request, BindingResult bindingResult, Model model);
String sendEmail(EmailRequest emailRequest, BindingResult bindingResult, Model model);
String getlistUserConfirm_Cancel(Model model);
}
