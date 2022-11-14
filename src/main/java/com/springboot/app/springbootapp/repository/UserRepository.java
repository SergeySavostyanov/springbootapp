package com.springboot.app.springbootapp.repository;

import com.springboot.app.springbootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
