package com.myprojects.spring.examples.SpringMVCRestWS.services;

import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.mapper.CategoryMapper;
import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.model.CategoryDTO;
import com.myprojects.spring.examples.SpringMVCRestWS.repositories.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;
    private CategoryRespository categoryRespository;

    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper){
        this.categoryMapper = categoryMapper;
    }

    @Autowired
    public void setCategoryRespository(CategoryRespository categoryRespository){
        this.categoryRespository = categoryRespository;
    }

//    public CategoryServiceImpl(CategoryMapper categoryMapper,  CategoryRespository categoryRespository) {
//        this.categoryMapper = categoryMapper;
//        this.categoryRespository = categoryRespository;
//    }

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
