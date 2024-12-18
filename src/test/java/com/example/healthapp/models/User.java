package com.example.healthapp.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @Column(name = "ID")
    private String id;


    @Column(name = "Name")
   // @NotNull(message = "Name cannot be null") 
    private String name;
    
    @Column(name = "Email")
    //@NotNull(message="Email cannot be null")
    // @Pattern(
    //     regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
    //     message = "Invalid email address"
    // )
    private String email;
    
    @Column(name = "Password")
   // @NotNull(message="Password cannot be null")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String password;

    @Column(name = "Height")
    //@NotNull(message="Height cannot be null")
    private double height;

    @Column(name = "Weight")
   // @NotNull(message="Weight cannot be null")
    private double weight;

    
    @Column(name = "Gender")
    //@NotNull(message="Gender cannot be null")
    private String gender;
    
    @Column(name = "Fitness_Goal")
   // @NotNull(message="FitnessGoal cannot be null")
    private String fitnessGoal;
}

