package com.springboot.app.springbootapp.service;

import com.springboot.app.springbootapp.model.User;

import java.util.List;

public interface UserServiceInt {
    User getById(Long id);

    List<User> listUsers();

    void saveUser(User user);

    void removeUser(Long id);

    //void updateUser(User user);
}
