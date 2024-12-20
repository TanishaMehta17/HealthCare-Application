package com.example.healthapp.healthapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthapp.healthapp.models.Goal;
import com.example.healthapp.healthapp.repository.GoalRepo;

@RestController
@RequestMapping("/goal")
public class GoalController {
    
    @Autowired
    private GoalRepo goalRepo;
    
    @PostMapping("/save")
    public Goal save(@RequestBody Goal goal)
    {
        return goalRepo.save(goal);
    }
    
    @GetMapping("/getAll")
    public List<Goal>getAll(){
       return goalRepo.findAll();
    }

    @GetMapping("/{id}")
    public Goal findGoal(@PathVariable int id)
    {
        return goalRepo.findGoalById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)
    {
        return goalRepo.deleteGoal(id);
    }

}
