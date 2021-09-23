package com.peaksoft.controller;

import com.peaksoft.model.User;
import com.peaksoft.service.RoleService;
import com.peaksoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RestControllerApi {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public RestControllerApi(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> findAll() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/addUser")
    public  void addUser(@RequestBody User user){
        userService.saveUser(user);
        //        try {
//            return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }
    @PutMapping("/update")
    public String updateUser(@RequestBody User user){
        userService.saveUser(user);
        return "Update";
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id) {
        try {
            userService.deleteUser(userService.findById(id));
            return new ResponseEntity(userService.getAllUsers(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

        @GetMapping("/find/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int id) {
        try {
          return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/find/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable("username") String username){
        try {
            return new ResponseEntity<>(userService.findByUsername(username),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}