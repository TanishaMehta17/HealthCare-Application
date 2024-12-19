package com.example.healthapp.healthapp.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "goal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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
