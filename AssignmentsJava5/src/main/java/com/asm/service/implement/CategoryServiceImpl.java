package com.asm.service.implement;


import com.asm.dto.request.CategoryRequest;
import com.asm.dto.response.CategoryResponse;
import com.asm.entity.Category;
import com.asm.responsitory.CategoryRepository;
import com.asm.service.ICategoryService;
import com.asm.utils.MessageUtils;
import com.asm.utils.Stastus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponse create(CategoryRequest request, BindingResult bindingResult) {
        Category category = new Category();
        CategoryResponse reponse = new CategoryResponse();
        if (bindingResult.hasErrors()) {

            return reponse;
        }
        category.setName(request.getName());
        category.setStatus(1);
        category.setImg(request.getImg());
        categoryRepository.save(category);
        reponse.setName(request.getName());
        reponse.setImg(request.getImg());

        return reponse;
    }

    @Override
    public CategoryResponse update(long id,CategoryRequest request, BindingResult bindingResult) {
        CategoryResponse reponse = new CategoryResponse();
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.get().getId()!=null) {
            if (bindingResult.hasErrors()) {

                return reponse;
            }
            categoryOptional.get().setName(request.getName());
            categoryOptional.get().setStatus(1);
            categoryOptional.get().setImg(request.getImg());
            categoryRepository.save(categoryOptional.get());

            reponse.setName(request.getName());
            reponse.setImg(request.getImg());

            return reponse;
        }
         return null;
    }

    @Override
    public void delete(long id) {
        categoryRepository.updtate(id);
    }

    @Override
    public List<Category> findByName(String name) {
        List<Category> categories = categoryRepository.findByNameLike("%"+name+"%");

        return categories;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
