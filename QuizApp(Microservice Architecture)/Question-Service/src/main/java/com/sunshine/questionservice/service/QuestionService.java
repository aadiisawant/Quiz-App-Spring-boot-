package com.sunshine.questionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sunshine.questionservice.Dao.QuestionDao;
import com.sunshine.questionservice.entity.Question;
import com.sunshine.questionservice.entity.QuestionWrapper;
import com.sunshine.questionservice.entity.Response;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

		}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return new ResponseEntity<>("Not Added", HttpStatus.BAD_REQUEST);

	}

	public String deleteById(Integer id) {
		questionDao.deleteById(id);
		return "Question Deleted";
	}

	public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numQues) {
		List<Integer> questions = questionDao.findRandomQuesByCategory(categoryName,numQues);
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(List<Integer> questionIds) {
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		for(Integer id : questionIds) {
			questions.add(questionDao.findById(id).get());
		}
		for(Question que : questions) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(que.getId());
			wrapper.setQuestionTitle(que.getQuestionTitle());
			wrapper.setOption1(que.getOption1());
			wrapper.setOption2(que.getOption2());
			wrapper.setOption3(que.getOption3());
			wrapper.setOption4(que.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
	
		int right = 0;
		for(Response response: responses) {
			Question question = questionDao.findById(response.getId()).get();
			if(response.getResponse().equals(question.getRightAnswer())) {
			right++;
			}
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
}
