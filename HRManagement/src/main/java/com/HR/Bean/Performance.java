package com.HR.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pId;
	private String quelityOfWork;
	private int rating;
	private String comment;
	
	public Performance() {
		// TODO Auto-generated constructor stub
	}

	public Performance(long pId, String quelityOfWork, int rating, String comment) {
		super();
		this.pId = pId;
		this.quelityOfWork = quelityOfWork;
		this.rating = rating;
		this.comment = comment;
	}

	public String getQuelityOfWork() {
		return quelityOfWork;
	}

	public void setQuelityOfWork(String quelityOfWork) {
		this.quelityOfWork = quelityOfWork;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Performance [pId=" + pId + ", quelityOfWork=" + quelityOfWork + ", rating=" + rating + ", comment="
				+ comment + "]";
	}
	
	
}
