package com.clinicalResearch.dtos;

public class ProcedureQuestionSelectDTO {
	private int studyID;
	private String questionUUID;
	private String text;
	
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
		return "ProcedureQuestionSelectDTO [studyID=" + studyID + ", questionUUID=" + questionUUID + ", text=" + text
				+ "]";
	}
}
