package com.sunshine.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.quizservice.entity.QuestionWrapper;
import com.sunshine.quizservice.entity.QuizDto;
import com.sunshine.quizservice.entity.Response;
import com.sunshine.quizservice.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
		return quizService.createQuiz(quizDto.getCategory(), quizDto.getNumq(), quizDto.getTitle()); 
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") int id){
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("submit")
	public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> response){
		return quizService.calculateResult(response);
	}
}
