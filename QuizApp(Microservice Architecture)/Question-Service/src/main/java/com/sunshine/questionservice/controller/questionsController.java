package com.sunshine.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.questionservice.entity.Question;
import com.sunshine.questionservice.entity.QuestionWrapper;
import com.sunshine.questionservice.entity.Response;
import com.sunshine.questionservice.service.QuestionService;

@RestController
@RequestMapping("question")
public class questionsController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("allquestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	@GetMapping("category/{lang}")
	public ResponseEntity<List<Question>> sameCategoryQues(@PathVariable("lang")String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteQuestion(@PathVariable("id") Integer id) {
		return questionService.deleteById(id);
	}
	
	//
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQues) {
		return questionService.getQuestionForQuiz(categoryName, numQues);
	}
	
	@PostMapping("getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(@RequestBody List<Integer> questionIds){
		return questionService.getQuestionsByID(questionIds);
	}
	
	@PostMapping("getscore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		return questionService.getScore(responses);
	}
}
