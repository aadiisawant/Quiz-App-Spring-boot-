package com.sunshine.quizservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.quizservice.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
