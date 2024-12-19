package com.example.healthapp.healthapp.models;


import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "users")

@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @Column(name = "ID")
    private String id;


    @Column(name = "Name")
    @NotNull(message = "Name cannot be null") 
    private String name;
    
    @Column(name = "Email")
    @NotNull(message="Email cannot be null")
    @Pattern(
        regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
        message = "Invalid email address"
    )
    private String email;
    
    @Column(name = "Password")
    @NotNull(message="Password cannot be null")
    private String password;

    @Column(name = "Height")
    @NotNull(message="Height cannot be null")
    private double height;

    @Column(name = "Weight")
    @NotNull(message="Weight cannot be null")
    private double weight;

    
    @Column(name = "Gender")
    @NotNull(message="Gender cannot be null")
    private String gender;
    
    @Column(name = "Fitness_Goal")
    @NotNull(message="FitnessGoal cannot be null")
    private String fitnessGoal;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", height="
                + height + ", weight=" + weight + ", gender=" + gender + ", fitnessGoal=" + fitnessGoal + "]";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    

    
}

