package com.nisha.blog.services;

import java.util.List;

import com.nisha.blog.payloads.CategoryDto;
import com.nisha.blog.payloads.UserDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	CategoryDto getCategoryById(Integer categoryId);
	
	public void deleteCategory(Integer categoryId);
	
	List<CategoryDto> getAllCategories();


}
