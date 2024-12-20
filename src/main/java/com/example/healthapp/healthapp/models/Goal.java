package com.example.healthapp.healthapp.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "goal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Goal")
public class Goal implements Serializable {
    @Id  
    private int id;
    
    @NotNull(message= " Description cannot be null, please enter a valid description given by your trainer")
    private String description;

    @NotNull(message = "Please enter a valid taregtDate for your goal completion")
    private LocalDate targetDate;

    @NotNull(message = "Please enter true or false on the basis of wheather your goal is achieved or not")
    private boolean isCompleted;

    @ManyToOne
    @JsonIgnore
    private User user;
}
