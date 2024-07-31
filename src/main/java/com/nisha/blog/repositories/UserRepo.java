package com.nisha.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisha.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
