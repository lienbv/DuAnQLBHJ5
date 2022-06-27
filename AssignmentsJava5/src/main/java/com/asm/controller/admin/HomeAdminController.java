package com.asm.controller.admin;

import com.asm.dto.request.DrinkingcupCreateRequest;
import com.asm.dto.request.DrinkingcupRequest;
import com.asm.entity.Category;
import com.asm.entity.Drinkingcup;
import com.asm.responsitory.CategoryRepository;
import com.asm.service.IDrinkingCupsService;
import com.asm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/staff/drinkingCups/")
public class HomeAdminController {
    @Autowired
    private IDrinkingCupsService iDrinkingCupsService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("getAll")
    public String getAll(Model model) {
        return iDrinkingCupsService.layoutAdmin(model);
    }

    @GetMapping("/create")
    public String create(@Valid DrinkingcupCreateRequest drinkingcupRequest, Model model) {

        List<Category> lstCategory = categoryRepository.findAll();
        model.addAttribute("lstCategory", lstCategory);
        model.addAttribute("drinkingCreate", drinkingcupRequest);
        model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
        return "admin/layout";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("drinkingCreate") DrinkingcupCreateRequest drinkingcupRequest, BindingResult bindingResult, Model model, @RequestParam("imgfile") MultipartFile uploadedFile) {

        return iDrinkingCupsService.create(drinkingcupRequest, bindingResult, model, uploadedFile);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Drinkingcup request, Model model) {
        DrinkingcupRequest drinkingcupRequest = new DrinkingcupRequest();
        drinkingcupRequest.setId(request.getId());
        drinkingcupRequest.setColor(request.getColor());
        drinkingcupRequest.setDescription(request.getDescription());
        drinkingcupRequest.setImg(request.getImg());
        drinkingcupRequest.setIdCategory(request.getIdCategory());
        drinkingcupRequest.setMaterial(request.getMaterial());
        drinkingcupRequest.setName(request.getName());
        drinkingcupRequest.setPrice(request.getPrice());
        drinkingcupRequest.setPromotion(request.getPromotion());
        drinkingcupRequest.setSize(request.getSize());
        drinkingcupRequest.setVolume(request.getVolume());
        drinkingcupRequest.setStatus(request.getStatus());
        drinkingcupRequest.setAmount(request.getAmount());
        List<Category> lstCategory = categoryRepository.findAll();
        model.addAttribute("drinking", drinkingcupRequest);
        model.addAttribute("lstCategory", lstCategory);
        model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
        return "admin/layout";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid DrinkingcupRequest drinkingcupRequest, BindingResult bindingResult, Model model, @RequestParam("imgfile") MultipartFile uploadedFile) {
        model.addAttribute("drinking", drinkingcupRequest);
        return iDrinkingCupsService.update(drinkingcupRequest, bindingResult, model, uploadedFile);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {

        return iDrinkingCupsService.delete(id, model);
    }

    //Bill - BillDetail
    @GetMapping("/getBill")
    public String getBill(Model model) {
        return iOrderService.listUserBillWaiting(model);
    }

    @GetMapping("/getBillByIdUser/{id}")
    public String getBillByIdUser(@PathVariable("id") Long id, Model model) {
        return iOrderService.getBillByIdUser(model, id);
    }


    @GetMapping("/updateBilldetail/{idUser}")
    public String updateConfirm(@PathVariable("idUser") Long idUser , Model model) {
        return iOrderService.updateConfirm(model, idUser);
    }

    @GetMapping("/cancelBilldetail")
    public String deleteBillDetail( Model model) {
        return iOrderService.updateCancel(model);
    }

    @GetMapping("/getBillStatusAll")
    public String getBillStatusAll(Model model) {
        return iOrderService.getlistUserConfirm_Cancel(model);
    }

    @GetMapping("/getBillByIdUserAndAllStatus/{id}")
    public String getBillByIdUserAndAllStatus(@PathVariable("id") Long id, Model model) {
        return iOrderService.getBillByIdUserAndAllStatus(model, id);
    }
}
