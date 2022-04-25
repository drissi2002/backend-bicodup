package com.exam.backend.service;

import com.exam.backend.helper.UserFoundException;
import com.exam.backend.model.User;
import com.exam.backend.model.UserRole;

import java.util.Set;

public interface UserService {
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws UserFoundException;
    //public User createUser(User user, Set<UserRole> userRoles);

    // getting user by username
    public User getUser(String username);
    //deleting user by id
    public void deleteUser(Long userId);
}

