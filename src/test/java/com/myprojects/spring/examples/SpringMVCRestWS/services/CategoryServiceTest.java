package com.myprojects.spring.examples.SpringMVCRestWS.services;

import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.mapper.CategoryMapper;
import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.model.CategoryDTO;
import com.myprojects.spring.examples.SpringMVCRestWS.domain.Category;
import com.myprojects.spring.examples.SpringMVCRestWS.repositories.CategoryRespository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    CategoryServiceImpl categoryService;

    @Mock
    CategoryRespository categoryRespository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl();
        categoryService.setCategoryMapper(CategoryMapper.INSTANCE);
        categoryService.setCategoryRespository(categoryRespository);

//        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRespository);
    }

    @Test
    public void getAllCategories() throws Exception {

        //given
        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());

        when(categoryRespository.findAll()).thenReturn(categories);

        //when
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        //then
        assertEquals(3, categoryDTOS.size());
    }

    @Test
    public void getCategoryByName() throws Exception {

        //given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRespository.findByName(anyString())).thenReturn(category);

        //when
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        //then
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());

    }


}