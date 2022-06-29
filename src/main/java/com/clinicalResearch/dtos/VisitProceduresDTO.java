package com.clinicalResearch.dtos;

public class VisitProceduresDTO {
	
	private int studyID;
	private String visitUUID;
	private String procedureUUID;

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

	public String getProcedureUUID() {
		return procedureUUID;
	}

	public void setProcedureUUID(String procedureUUID) {
		this.procedureUUID = procedureUUID;
	}

}
