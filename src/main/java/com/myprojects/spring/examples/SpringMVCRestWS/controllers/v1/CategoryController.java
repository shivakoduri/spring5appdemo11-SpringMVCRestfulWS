package com.myprojects.spring.examples.SpringMVCRestWS.controllers.v1;

import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.model.CategoryDTO;
import com.myprojects.spring.examples.SpringMVCRestWS.api.v1.model.CategoryListDTO;
import com.myprojects.spring.examples.SpringMVCRestWS.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping
//    public ResponseEntity<CategoryListDTO> getAllCategories(){
//
//        return new ResponseEntity<CategoryListDTO>(
//                new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
//    }
//
//    @GetMapping("{name}")
//    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
//        return new ResponseEntity<CategoryDTO>(
//                categoryService.getCategoryByName(name), HttpStatus.OK);
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getallCatetories(){
        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }

}
