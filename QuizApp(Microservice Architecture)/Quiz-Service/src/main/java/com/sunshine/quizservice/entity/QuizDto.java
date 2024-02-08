package com.sunshine.quizservice.entity;

import lombok.Data;

@Data
public class QuizDto {
	String category;
	int numq; 
	String title;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNumq() {
		return numq;
	}
	public void setNumq(int numq) {
		this.numq = numq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QuizDto(String category, int numq, String title) {
		super();
		this.category = category;
		this.numq = numq;
		this.title = title;
	} 
	
	
}
