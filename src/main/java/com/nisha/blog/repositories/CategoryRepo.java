package com.nisha.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisha.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	
}
