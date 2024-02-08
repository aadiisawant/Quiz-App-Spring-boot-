package com.sunshine.quizservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sunshine.quizservice.Dao.QuizDao;
import com.sunshine.quizservice.entity.QuestionWrapper;
import com.sunshine.quizservice.entity.Quiz;
import com.sunshine.quizservice.entity.Response;
import com.sunshine.quizservice.feign.QuizFInterface;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	@Autowired
	QuizFInterface quizFInterface;

	public ResponseEntity<String> createQuiz(String category, int numq, String title) {
		List<Integer> questions = quizFInterface.getQuestionsForQuiz(category, numq).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz>quiz = quizDao.findById(id);
		List<Integer> questionsFromDB = quiz.get().getQuestionIds();
		
		List<QuestionWrapper> questionForUser = quizFInterface.getQuestionsByID(questionsFromDB).getBody();
//		for(Question q : questionsFromDB) {
//			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
//			questionForUser.add(qw);
//		}
		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(List<Response> responses) {
//		Quiz quiz = quizDao.findById(id).get();
//		List<Integer> questions = quiz.getQuestionIds();
		int right = quizFInterface.getScore(responses).getBody();
//		int i=0;
//		for(Response response: responses) {
//			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
//			right++;
//			}
//			i++;
//		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
}
