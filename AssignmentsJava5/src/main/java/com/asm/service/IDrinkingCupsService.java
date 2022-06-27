package com.asm.service;

import com.asm.dto.request.DrinkingcupCreateRequest;
import com.asm.dto.request.DrinkingcupRequest;
import com.asm.dto.response.DrinkingCupResponse;
import com.asm.entity.Drinkingcup;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


public interface IDrinkingCupsService {
    String create(DrinkingcupCreateRequest request, BindingResult bindingResult, Model model, MultipartFile file);

    String update( DrinkingcupRequest request, BindingResult bindingResult, Model model,  MultipartFile uploadedFile);

    String delete(long id, Model model);

    List<Drinkingcup> findAll();

    String findByName(String name, Model model, Pageable pageable);

    Optional<Drinkingcup> edit(long id);
    List<Drinkingcup> getDrinkingCupByCategory(long id);

    Object findByCategoryByDrinking(Long id);
    String layout(Model model);
    String layoutAdmin(Model model);

}
