package com.example.healthapp.healthapp.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "meal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "meslName cannot be empty, enter from the fllowing {Breakfast, Lunch and Dinner}")
    private String mealName;

    @NotNull(message = "Calories cannot be null, Enter a valis number in kcal")
    private double calories;

    @NotNull(message = "Date cannot be null, Enter a valid date ")
    private LocalDate date;

    @NotNull(message = "Eneter the remark  given by your trainer")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
