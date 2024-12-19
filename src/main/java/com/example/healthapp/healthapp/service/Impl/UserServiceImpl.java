
package com.example.healthapp.healthapp.service.Impl;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;


import com.example.healthapp.healthapp.models.User;
import com.example.healthapp.healthapp.repository.UserRepo;
import com.example.healthapp.healthapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{
    
     @Autowired
     private UserRepo userRepo;

     @Autowired
     private PasswordEncoder passwordEncoder;

     

    @Override
    public User saveUser(User user) {
        Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists");  
        }
        String userId= UUID.randomUUID().toString();
        user.setId(userId);
        user.setPassword(passwordEncoder.encode(user.getPassword())); 
        User savedUser= userRepo.save(user);
        return savedUser;
       
    }

    @Override
    public Optional<User> getUserById(String id) {   
      return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user1 = userRepo.findById(user.getId())
            .orElseThrow(() -> new IllegalArgumentException("User not found. Please enter a valid user ID."));
        
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setFitnessGoal(user.getFitnessGoal());
        user1.setHeight(user.getHeight());
        user1.setWeight(user.getWeight());
        user1.setGender(user.getGender());
        
        User savedUser = userRepo.save(user1);
        return Optional.of(savedUser);
    }
    
    @Override
    public void deleteUser(String id) {
        User user2 = userRepo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("User not found. Please enter a valid user ID."));
        userRepo.delete(user2);

    }

    @Override
    public boolean isUserExist(String userId) {
      
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
      
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {  
        return userRepo.findAll();
    }

    @Override
    public User getUserByEmail(String email) {  
        return userRepo.findByEmail(email).orElse(null);
    }
    
    @Override
    public boolean authenticateUser(String email, String rawPassword) {
        User user = userRepo.findByEmail(email).orElseThrow(() -> 
            new IllegalArgumentException("User with this email does not exist."));
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
    
}
