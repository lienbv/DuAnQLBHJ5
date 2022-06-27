package com.asm.service.implement;

import com.asm.dto.request.CheckoutRequest;
import com.asm.dto.request.UserRequest;
import com.asm.entity.*;
import com.asm.responsitory.BillDetailRepository;
import com.asm.responsitory.BillRepository;
import com.asm.responsitory.DrinkingcupRepository;
import com.asm.responsitory.UserRepository;
import com.asm.service.ICheckoutService;
import com.asm.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;

@Service
public class CheckoutService implements ICheckoutService {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DrinkingcupRepository drinkingcupRepository;
    @Autowired
    private BillDetailRepository billDetailRepository;
    @Autowired
    private BillRepository billRepository;

    @Override
    public void insertBillDetail() {

        HttpSession session = httpServletRequest.getSession();
        UserDetailImplUser user = (UserDetailImplUser) session.getAttribute("accountKH");

        double sum = 0;
        HashMap<Long, Cart> cart = (HashMap<Long, Cart>) session.getAttribute("listCart");
        session.setAttribute("listCart", cart);
        Bill bill = new Bill();
        Drinkingcup drinkingcup = new Drinkingcup();

        for (Map.Entry<Long, Cart> entry : cart.entrySet()) {

            Long key = entry.getKey();
            Cart val = entry.getValue();
            sum += val.getIdDrinkingCups().getPrice() * val.getAmount();

            bill.setIdUser(user.getId());
            bill.setStatus("waiting");
            bill.setCreateDate(new Date());
            bill.setDescription("");
            bill.setTotal(sum + 35000);
            bill = billRepository.save(bill);
            BillDetail billDetail = new BillDetail();

            Drinkingcup optionalDrinkingcup = this.drinkingcupRepository.findById(key).get();
            optionalDrinkingcup.setAmount(optionalDrinkingcup.getAmount() - entry.getValue().getAmount());
            this.drinkingcupRepository.save(optionalDrinkingcup);


            billDetail.setAmount(val.getAmount());
            billDetail.setIdBill(bill.getId());
            billDetail.setIdDrinkingcup(val.getIdDrinkingCups().getId());
            billDetail = billDetailRepository.save(billDetail);


        }
        session.setAttribute("sum", sum);
        session.setAttribute("shippingFee", 35000);
        session.setAttribute("sumTT", sum + 35000);
        session.setAttribute("sum", 0);
        session.setAttribute("shippingFee", 0);
        session.setAttribute("sumTT", 0);
        session.removeAttribute("listCart");


    }

    public User inserUser(@Valid CheckoutRequest userRequest) {

        User user = new User();
        user.setAddress(userRequest.getAddress());
        user.setImg(null);
        user.setStatus("exist");
        user.setEmail(userRequest.getEmail());
        user.setFullname(userRequest.getFullname());
        user.setCreateDate(new Date());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user = userRepository.save(user);
        return user;
    }

    private void profileUser() {
        User user = new User();
        HttpSession session = httpServletRequest.getSession();
        user = (User) session.getAttribute("accountKH");
        Long id = user.getId();
        Optional<User> optionalUser = this.userRepository.findById(id);
        httpServletRequest.setAttribute("user", optionalUser.get());
    }
}
