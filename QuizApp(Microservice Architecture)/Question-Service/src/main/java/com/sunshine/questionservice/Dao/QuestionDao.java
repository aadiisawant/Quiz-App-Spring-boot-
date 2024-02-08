package com.sunshine.questionservice.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunshine.questionservice.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	
	List<Question> findByCategory(String category);
	
	@Query(value = "SELECT q.id FROM question q Where q.category=:category ORDER BY RAND() LIMIT :numq", nativeQuery = true)
	List<Integer> findRandomQuesByCategory(String category, Integer numq);

	

	
}
