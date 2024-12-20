package com.example.healthapp.healthapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.healthapp.healthapp.models.Goal;

@Repository
public class GoalRepo {
    
    public static final String HASH_KEY= "Goal";
    @Autowired
      @Qualifier("redisTemplate")
    private RedisTemplate template;

    public Goal save(Goal goal)
    {
        template.opsForHash().put(HASH_KEY, goal.getId(), goal);
        return goal;
    }
    public List<Goal>findAll()
    {
        return template.opsForHash().values(HASH_KEY);
    }
    public Goal findGoalById(int id)
    {
        return (Goal)template.opsForHash().get(HASH_KEY, id);
    }
    public String deleteGoal(int id)
    {
         template.opsForHash().delete(HASH_KEY, id);
         return "goal removed successfully";
    }

}
