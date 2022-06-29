package com.clinicalResearch.dtos;

public class VisitsDTO {

	private int studyID;
	private String visitUUID;
	private String name;
	private String cdashVariable;
	private int visitOrder;

	public int getStudyID() {
		return studyID;
	}

	public void setStudyID(int studyID) {
		this.studyID = studyID;
	}

	public String getVisitUUID() {
		return visitUUID;
	}

	public void setVisitUUID(String visitUUID) {
		this.visitUUID = visitUUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCdashVariable() {
		return cdashVariable;
	}

	public void setCdashVariable(String cdashVariable) {
		this.cdashVariable = cdashVariable;
	}

	public int getVisitOrder() {
		return visitOrder;
	}

	public void setVisitOrder(int visitOrder) {
		this.visitOrder = visitOrder;
	}

	@Override
	public String toString() {
		return "Visits [studyID=" + studyID + ", visitUUID=" + visitUUID + ", Name=" + name + ", cdashVariable="
				+ cdashVariable + ", visitOrder=" + visitOrder + "]";
	}

}
