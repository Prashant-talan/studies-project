package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDURES_QUESTION_SELECT")
public class ProcedureQuestionSelect {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Question_UUID")
	private String questionUUID;
	
	@Column(name = "TEXT")
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudyID() {
		return studyID;
	}

	public void setStudyID(int studyID) {
		this.studyID = studyID;
	}

	public String getQuestionUUID() {
		return questionUUID;
	}

	public void setQuestionUUID(String questionUUID) {
		this.questionUUID = questionUUID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "ProcedureQuestionSelect [studyID=" + studyID + ", questionUUID=" + questionUUID + ", text=" + text
				+ "]";
	}
    
}
