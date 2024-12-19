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
@Table(name = "progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Progress {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Date cannot be null, Enter a valid date ")
    private LocalDate date;

    @NotNull(message = "Weight cannot be null, Enter your current weight ")
    private double weight;

    @NotNull(message = "BMI cannot be null, Enter your current BMI ")
    private double bmi;

    @NotNull(message = "Steps cannot be null, Enter your today's step ")
    private int steps;

    @NotNull(message = "Heart Rate cannot be null, Enter your current heart rate ")
    private int heartRate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; 
}
