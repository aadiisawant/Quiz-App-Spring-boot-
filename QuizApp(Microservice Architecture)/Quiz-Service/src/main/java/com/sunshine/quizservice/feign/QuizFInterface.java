package com.sunshine.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunshine.quizservice.entity.QuestionWrapper;
import com.sunshine.quizservice.entity.Response;

@FeignClient("QUESTION-APP")
public interface QuizFInterface {

	@GetMapping("question-app/api/question/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQues);
	
	@PostMapping("question-app/api/question/getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(@RequestBody List<Integer> questionIds);
	
	@PostMapping("question-app/api/question/getscore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
