package com.peaksoft.service;

import com.peaksoft.model.User;
import com.peaksoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    UserServiceImpl implements UserService {
     @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
     this.userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
    userRepository.delete(user);
    }

    @Override
    public User findById(Integer id) {
       return userRepository.findById(id).get();

    }

    @Override
    public User findByUsername(String username) {
        List<User> users = userRepository.findAll();
        for (User user:users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }


}
