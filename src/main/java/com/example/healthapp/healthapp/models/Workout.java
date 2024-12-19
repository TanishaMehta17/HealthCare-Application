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
@Table(name = "workout")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="Type cannot be null , select from Cardio, Strength, Yoga, Arobics")
    private String type; 

    @NotNull(message = "Duration cannot be null, please enter time in minutes")
    private int duration; 

    @NotNull(message = "Calories Burned cannot be null please enter a valid valuein Kcal")
    private double caloriesBurned;

    @NotNull(message = "Date cannot be null, please enter today's date fro reference")
    private LocalDate date;

    @NotNull(message = "Note cannot be null, please enter a valid remark by your respective trainer")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
