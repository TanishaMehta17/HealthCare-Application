package com.example.healthapp.healthapp.service;

import java.util.List;
import java.util.Optional;

import com.example.healthapp.healthapp.models.User;



public interface UserService {

         User saveUser(User user);
         Optional<User> getUserById(String id);
         Optional<User> updateUser(User user);
        void deleteUser(String id);
        boolean isUserExist(String userId);
        boolean isUserExistByEmail(String email);
        List<User> getAllUsers();
        User getUserByEmail(String email);
        boolean authenticateUser(String email, String rawPassword);
   }
   

