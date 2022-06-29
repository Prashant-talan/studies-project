package com.clinicalResearch.dtos;

public class ProcedureQuestionsDTO {
	
	private int studyID;
	private String procedureUUID;
	private String questionUUID;
	private String Question;
	private String cdashVariable;
	private String variableName;
	private int displayOrder;
	private String questionType;
	
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
		return "ProcedureQuestionsDTO [studyID=" + studyID + ", procedureUUID=" + procedureUUID + ", questionUUID="
				+ questionUUID + ", Question=" + Question + ", cdashVariable=" + cdashVariable + ", variableName="
				+ variableName + ", displayOrder=" + displayOrder + ", questionType=" + questionType + "]";
	}
	
}
