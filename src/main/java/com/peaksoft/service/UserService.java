package com.peaksoft.service;


import com.peaksoft.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user); //String id);

    void deleteUser(User user);

    User findById(Integer id);

    User findByUsername(String username);


}
