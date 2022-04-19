package com.exam.backend.service.impl;

import com.exam.backend.helper.UserFoundException;
import com.exam.backend.model.User;
import com.exam.backend.model.UserRole;
import com.exam.backend.repo.RoleRepository;
import com.exam.backend.repo.UserRepository;
import com.exam.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceIpml implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository ;

    // Creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws UserFoundException {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already there !");
            throw new UserFoundException();
        }
        else{
            // User created
            for(UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local= this.userRepository.save(user);
        }


        return local;
    }
    // getting user by username
    @Override
    public User getUser(String username){
        return this.userRepository.findByUsername(username);
    }

    // deleting user by ID
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}

