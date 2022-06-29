package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDURES_QUESTION")
public class ProcedureQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Procedure_UUID")
	private String procedureUUID;
	
	@Column(name = "Question_UUID")
	private String questionUUID;
	
	@Column(name = "Question")
	private String Question;
	
	@Column(name = "Cdash_Variable")
	private String cdashVariable;
	
	@Column(name = "Variable_Name")
	private String variableName;
	
	@Column(name = "Display_Order")
	private int displayOrder;
	
	@Column(name = "Question_Type")
	private String questionType;

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

	public String getProcedureUUID() {
		return procedureUUID;
	}

	public void setProcedureUUID(String procedureUUID) {
		this.procedureUUID = procedureUUID;
	}

	public String getQuestionUUID() {
		return questionUUID;
	}

	public void setQuestionUUID(String questionUUID) {
		this.questionUUID = questionUUID;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getCdashVariable() {
		return cdashVariable;
	}

	public void setCdashVariable(String cdashVariable) {
		this.cdashVariable = cdashVariable;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@Override
	public String toString() {
		return "ProcedureQuestion [studyID=" + studyID + ", procedureUUID=" + procedureUUID + ", questionUUID="
				+ questionUUID + ", Question=" + Question + ", cdashVariable=" + cdashVariable + ", variableName="
				+ variableName + ", displayOrder=" + displayOrder + ", questionType=" + questionType + "]";
	}

}
