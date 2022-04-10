package com.exam.backend.controller;


import com.exam.backend.model.Role;
import com.exam.backend.model.User;
import com.exam.backend.model.UserRole;
import com.exam.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
//@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    //Creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user){
        user.setProfile("default.png");
        Set<UserRole> roles=new HashSet<>();
        Role role =new Role();
        role.setRoleId(45L);
        role.setRoleName("Normal");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);

        return this.userService.createUser(user,roles);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //delete user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

    //update api

}
