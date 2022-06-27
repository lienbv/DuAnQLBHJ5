package com.asm.service;


import com.asm.dto.request.CategoryRequest;
import com.asm.dto.response.CategoryResponse;
import com.asm.entity.Category;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    CategoryResponse create(CategoryRequest request, BindingResult bindingResult);
    CategoryResponse update(long id,CategoryRequest request, BindingResult bindingResult);
    void delete(long id);
    List<Category> findByName(String name);
    List<Category> findAll();
    Optional<Category> findById(Long id);



}
