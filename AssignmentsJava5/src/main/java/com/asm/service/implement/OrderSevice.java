package com.asm.service.implement;

import com.asm.entity.Bill;
import com.asm.responsitory.BillDetailRepository;
import com.asm.responsitory.BillRepository;
import com.asm.responsitory.DrinkingcupRepository;
import com.asm.responsitory.UserRepository;
import com.asm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class OrderSevice implements IOrderService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BillRepository billRepository;

    @Override
    public String listUserBillWaiting(Model model) {

        List<Object[]> listObject = userRepository.findUserByStatus();
        model.addAttribute("listOrder_Waiting_Customer", listObject);
        model.addAttribute("view", "/WEB-INF/views/admin/List_Customer_Order.jsp");
        return "admin/layout";

    }

    @Override
    public String getBillByIdUser(Model model, Long id) {
        List<Object[]> listObject = billRepository.findDrinkingByidUser(id);
        model.addAttribute("listOrderDrinkingCup_Waiting", listObject);
        model.addAttribute("view", "/WEB-INF/views/admin/OrderDetail.jsp");
        return "admin/layout";
    }

    @Override
    public String updateConfirm(Model model, long idUser) {
        this.billRepository.DrinkingByidUserConfirm(idUser);
        return "redirect:/staff/drinkingCups/getBill" + "?successConfirm=1";
    }

    @Override
    public String updateCancel(Model model) {
        List<Bill> findAll = this.billRepository.findAll();
        this.billRepository.DrinkingByidUserCancel(findAll.get(0).getIdUser(), findAll.get(0).getId());
        return "redirect:/staff/drinkingCups/getBill" + "?successCancel=1";
    }

    @Override
    public String getlistUserConfirm_Cancel(Model model) {
        List<Object[]> listObject = userRepository.findUserByStatus();
        List<Object[]> listConfirm = userRepository.findUserByStatusConfirm();
        List<Object[]> listCancel = userRepository.findUserByStatusCancel();
        model.addAttribute("listOrder_Waiting_Customer", listObject);
        model.addAttribute("listOrder_Confirm_Customer", listConfirm);
        model.addAttribute("listOrder_Cancel_Customer", listCancel);
        model.addAttribute("view", "/WEB-INF/views/admin/waiting_cancel_confirm_Admin.jsp");
        return "admin/layout";
    }

    @Override
    public String getBillByIdUserAndAllStatus(Model model, Long id) {
        List<Object[]> listObjectWaiting = billRepository.findDrinkingByidUser(id);
        List<Object[]> listObjectConfirm = billRepository.findDrinkingByidUser(id);
        List<Object[]> listObjectCancel = billRepository.findDrinkingByidUser(id);
        model.addAttribute("listOrderDrinkingCup_Waiting", listObjectWaiting);
        model.addAttribute("listOrderDrinkingCup_Waiting", listObjectConfirm);
        model.addAttribute("listOrderDrinkingCup_Waiting", listObjectCancel);
        model.addAttribute("view", "/WEB-INF/views/admin/OrderDetailConfirm_Cancel.jsp");
        return "admin/layout";
    }
}
