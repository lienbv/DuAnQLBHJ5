package com.asm.service.implement;

import com.asm.dto.request.DrinkingcupCreateRequest;
import com.asm.dto.request.DrinkingcupRequest;
import com.asm.dto.response.DrinkingCupResponse;
import com.asm.entity.Category;
import com.asm.entity.Drinkingcup;
import com.asm.responsitory.CategoryRepository;
import com.asm.responsitory.DrinkingcupRepository;
import com.asm.service.IDrinkingCupsService;
import com.asm.utils.MessageUtils;
import com.asm.utils.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DrinkigCupServiceImpl implements IDrinkingCupsService {
    @Autowired
    private DrinkingcupRepository drinkingcupRepository;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private HttpSession session;

    @Override
    public String create(DrinkingcupCreateRequest request, BindingResult bindingResult, Model model, @RequestParam("imgfile")MultipartFile file) {
        Drinkingcup drinkingcup = new Drinkingcup();
        DrinkingCupResponse response = new DrinkingCupResponse();
        List<Category> lstCategory = categoryRepository.findAll();
        model.addAttribute("lstCategory", lstCategory);
        File save = uploadFileService.save(file);

        if (request.getName().equals("")) {
            session.setAttribute("errorname","Name is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
            return "admin/layout";
        }
        if (request.getPrice()==null) {
            session.setAttribute("errorprice","Price is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
            return "admin/layout";
        }
        try {
            if (request.getPrice() <=1) {
                session.setAttribute("errorprice","price must not be less than 1");
                model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
                return "admin/layout";
            }
            if (request.getPrice() >= 1000000000) {
                session.setAttribute("errorprice","Price must not be more than 1 billion VND");
                model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
                return "admin/layout";
            }
        }catch (Exception e){
            session.setAttribute("errorprice","Price must is number");
            model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
            return "admin/layout";
        }
        if (request.getAmount()==null) {
            session.setAttribute("erroramount","Amount is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
            return "admin/layout";
        }
        try {
            if (request.getAmount() <=1) {
                session.setAttribute("erroramount","Amount must not be less than 1");
                model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
                return "admin/layout";
            }
            if (request.getPrice() >= 1000000000) {
                session.setAttribute("erroramount","Amount must not be more than 1 billion VND");
                model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
                return "admin/layout";
            }
        }catch (Exception e){
            session.setAttribute("erroramount","Amount must is number");
            model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
            return "admin/layout";
        }
        if (request.getVolume() == null) {
            session.setAttribute("errorvolume","Volume is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
            return "admin/layout";
        }
        try {
            if (request.getAmount() <=0) {
                session.setAttribute("errorvolume","Volume must not be less than 1");
                model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
                return "admin/layout";
            }
            if (request.getVolume() >= 1000000000) {
                session.setAttribute("errorvolume","Volume must not be more than 1 billion VND");
                model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
                return "admin/layout";
            }
        }catch (Exception e){
            session.setAttribute("errorvolume","Volume must is number");
            model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
            return "admin/layout";
        }
        if(request.getMaterial().equals("")){
            session.setAttribute("errormaterial","Material is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
            return "admin/layout";
        }
        drinkingcup.setCreateDate(new Date());
        drinkingcup.setColor(request.getColor());
        drinkingcup.setDescription(request.getDescription());

        drinkingcup.setImg(save.getName());

        drinkingcup.setIdCategory(request.getIdCategory());
        drinkingcup.setMaterial(request.getMaterial());
        drinkingcup.setName(request.getName());
        drinkingcup.setPrice(request.getPrice());
        drinkingcup.setPromotion(request.getPromotion());
        drinkingcup.setSize(request.getSize());
        drinkingcup.setVolume(request.getVolume());
        drinkingcup.setStatus(1);
        drinkingcup.setAmount(request.getAmount());

        drinkingcup = drinkingcupRepository.save(drinkingcup);

        response.setColor(drinkingcup.getColor());
        response.setDescription(drinkingcup.getDescription());
        response.setImg(drinkingcup.getImg());
        response.setIdCategory(drinkingcup.getIdCategory());
        response.setMaterial(drinkingcup.getMaterial());
        response.setName(drinkingcup.getName());
        response.setPrice(drinkingcup.getPrice());
        response.setPromotion(drinkingcup.getPromotion());
        response.setSize(drinkingcup.getSize());
        response.setVolume(drinkingcup.getVolume());
        response.setAmount(drinkingcup.getAmount());
        response.setStatus(drinkingcup.getStatus());

        model.addAttribute("view", "/WEB-INF/views/admin/createDrinkingCups.jsp");
        return "redirect:/staff/drinkingCups/getAll" + "?successCreateDrinking=1";
    }

    @Override
    public String update(DrinkingcupRequest request, BindingResult bindingResult, Model model,@RequestParam("imgfile")MultipartFile file) {

        Drinkingcup drinkingcup = new Drinkingcup();
        DrinkingCupResponse response = new DrinkingCupResponse();
        Optional<Drinkingcup> optionalDrinkingcup = drinkingcupRepository.findById(request.getId());
        List<Category> lstCategory = categoryRepository.findAll();
        model.addAttribute("lstCategory", lstCategory);
        File save = uploadFileService.save(file);
//
        if (request.getName().equals("")) {
            session.setAttribute("errorname","Name is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
            return "admin/layout";
        }
        if (request.getPrice()==null) {
            session.setAttribute("errorprice","Price is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
            return "admin/layout";
        }
        try {
            if (request.getPrice() <=1) {
                session.setAttribute("errorprice","price must not be less than 1");
                model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
                return "admin/layout";
            }
            if (request.getPrice() >= 1000000000) {
                session.setAttribute("errorprice","Price must not be more than 1 billion VND");
                model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
                return "admin/layout";
            }
        }catch (Exception e){
            session.setAttribute("errorprice","Price must is number");
            model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
            return "admin/layout";
        }
        if (request.getAmount()==null) {
            session.setAttribute("erroramount","Amount is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
            return "admin/layout";
        }
        try {
            if (request.getAmount() <=1) {
                session.setAttribute("erroramount","Amount must not be less than 1");
                model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
                return "admin/layout";
            }
            if (request.getPrice() >= 1000000000) {
                session.setAttribute("erroramount","Amount must not be more than 1 billion VND");
                model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
                return "admin/layout";
            }
        }catch (Exception e){
            session.setAttribute("erroramount","Amount must is number");
            model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
            return "admin/layout";
        }
        if (request.getVolume() == null) {
            session.setAttribute("errorvolume","Volume is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
            return "admin/layout";
        }
        try {
            if (request.getAmount() <=0) {
                session.setAttribute("errorvolume","Volume must not be less than 1");
                model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
                return "admin/layout";
            }
            if (request.getVolume() >= 1000000000) {
                session.setAttribute("errorvolume","Volume must not be more than 1 billion VND");
                model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
                return "admin/layout";
            }
        }catch (Exception e){
            session.setAttribute("errorvolume","Volume must is number");
            model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
            return "admin/layout";
        }
        if(request.getMaterial().equals("")){
            session.setAttribute("errormaterial","Material is not null");
            model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
            return "admin/layout";
        }
        drinkingcup.setId(request.getId());

        drinkingcup.setCreateDate(new Date());
        drinkingcup.setColor(request.getColor());
        drinkingcup.setDescription(request.getDescription());

        drinkingcup.setImg(save.getName());
        if(save.getName().equals("")){
            drinkingcup.setImg(optionalDrinkingcup.get().getImg());

        }else if(save.getName().equals("img")){
            drinkingcup.setImg(optionalDrinkingcup.get().getImg());
        }

        drinkingcup.setIdCategory(request.getIdCategory());
        drinkingcup.setMaterial(request.getMaterial());
        drinkingcup.setName(request.getName());
        drinkingcup.setPrice(request.getPrice());
        drinkingcup.setPromotion(request.getPromotion());
        drinkingcup.setSize(request.getSize());
        drinkingcup.setVolume(request.getVolume());
        drinkingcup.setStatus(request.getStatus());
        drinkingcup.setAmount(request.getAmount());


        System.out.println(optionalDrinkingcup.get() + "asdfghjk 105");
        drinkingcup = drinkingcupRepository.save(drinkingcup);

        response.setColor(drinkingcup.getColor());
        response.setDescription(drinkingcup.getDescription());
        response.setImg(drinkingcup.getImg());
        response.setIdCategory(drinkingcup.getIdCategory());
        response.setMaterial(drinkingcup.getMaterial());
        response.setName(drinkingcup.getName());
        response.setPrice(drinkingcup.getPrice());
        response.setPromotion(drinkingcup.getPromotion());
        response.setSize(drinkingcup.getSize());
        response.setVolume(drinkingcup.getVolume());
        response.setAmount(drinkingcup.getAmount());
        response.setStatus(drinkingcup.getStatus());

        model.addAttribute("view", "/WEB-INF/views/admin/updateDrinkingCups.jsp");
        return "redirect:/staff/drinkingCups/getAll" + "?successUpdateDrinking=1";
    }

    @Override
    public String delete(long id, Model model) {
    this.drinkingcupRepository.updateAmount(id);
        model.addAttribute("view", "/WEB-INF/views/admin/drinkingCups.jsp");
        return "redirect:/staff/drinkingCups/getAll" + "?successDelete=1";
    }

    @Override
    public List<Drinkingcup> findAll() {
        return drinkingcupRepository.findAll();
    }

    @Override
    public String findByName(String name, Model model, Pageable pageable) {

        String pageParam = httpServletRequest.getParameter("page");

        int page = pageParam == null ? 0 : Integer.parseInt(pageParam);
        pageable = PageRequest.of(page, 5);

        Page<Drinkingcup> cocs;

        if(name !=null){
            cocs = drinkingcupRepository.findByNameLike("%"+ name+"%", pageable);
            model.addAttribute("pageData", cocs );
        } else {
            cocs  = this.drinkingcupRepository.findAll(pageable);
        }

        model.addAttribute("view", "/WEB-INF/views/user/home.jsp");
        return "user/index";
    }

    @Override
    public Optional<Drinkingcup> edit(long id) {
        Optional<Drinkingcup> optionalDrinkingcup = drinkingcupRepository.findById(id);
        return optionalDrinkingcup;
    }

    @Override
    public List<Drinkingcup> getDrinkingCupByCategory(long id) {
        List<Drinkingcup> drinkingcups = drinkingcupRepository.loadProductByCategory(id);
        return drinkingcups;
    }

    @Override
    public Object findByCategoryByDrinking(Long id) {

        Object category = drinkingcupRepository.findCategoryByProduct(id);
        return category;
    }

    @Override
    public String layout(Model model) {
        String pageParam = httpServletRequest.getParameter("page");
        String limitParam = httpServletRequest.getParameter("limit");

        int page = pageParam == null ? 0 : Integer.parseInt(pageParam);
        int limit = limitParam == null ? 5 : Integer.parseInt(limitParam);
        Pageable pageable = PageRequest.of(page, limit);

        Page pageData = this.drinkingcupRepository.findAll(pageable);

        model.addAttribute("pageData", pageData);

        model.addAttribute("view", "/WEB-INF/views/user/home.jsp");
        return "user/index";
    }

    @Override
    public String layoutAdmin(Model model) {
        String pageParam = httpServletRequest.getParameter("page");
        String limitParam = httpServletRequest.getParameter("limit");

        int page = pageParam == null ? 0 : Integer.parseInt(pageParam);
        int limit = limitParam == null ? 5 : Integer.parseInt(limitParam);
        Pageable pageable = PageRequest.of(page, limit);

        Page pageData = this.drinkingcupRepository.findAll(pageable);

        model.addAttribute("pageData", pageData);

        model.addAttribute("view", "/WEB-INF/views/admin/drinkingCups.jsp");
        return "admin/layout";
    }


}
