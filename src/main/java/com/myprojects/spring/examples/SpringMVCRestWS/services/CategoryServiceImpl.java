package com.myprojects.spring.examples.SpringMVCRestWS.services;

import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.mapper.CategoryMapper;
import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.model.CategoryDTO;
import com.myprojects.spring.examples.SpringMVCRestWS.repositories.CategoryRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRespository categoryRespository;

    public CategoryServiceImpl(CategoryMapper categoryMapper,  CategoryRespository categoryRespository) {
        this.categoryMapper = categoryMapper;
        this.categoryRespository = categoryRespository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRespository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRespository.findByName(name));
    }
}