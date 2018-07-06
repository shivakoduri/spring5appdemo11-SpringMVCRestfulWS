package com.myprojects.spring.examples.SpringMVCRestWS.bootstrap;

import com.myprojects.spring.examples.SpringMVCRestWS.domain.Category;
import com.myprojects.spring.examples.SpringMVCRestWS.repositories.CategoryRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRespository categoryRepository;

    public Bootstrap(CategoryRespository categoryRespository) {
        this.categoryRepository = categoryRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Data Loaded = " + categoryRepository.count() );

    }
}
