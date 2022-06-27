package com.asm.service;

import org.springframework.ui.Model;

public interface IOrderService {
    String listUserBillWaiting(Model model);

    String getBillByIdUser(Model model, Long id);

    String updateConfirm(Model model, long idUser);

    String updateCancel(Model model);

    String getlistUserConfirm_Cancel(Model model);

    String getBillByIdUserAndAllStatus(Model model, Long id);
}
