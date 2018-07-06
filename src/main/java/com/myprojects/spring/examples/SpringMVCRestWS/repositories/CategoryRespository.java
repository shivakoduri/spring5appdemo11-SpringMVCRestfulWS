package com.myprojects.spring.examples.SpringMVCRestWS.repositories;

import com.myprojects.spring.examples.SpringMVCRestWS.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Long> {
}
