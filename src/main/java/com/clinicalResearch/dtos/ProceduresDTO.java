package com.clinicalResearch.dtos;

public class ProceduresDTO {

	private int studyID;
	private String procedureUUID;
	private String name;
	private String cdashVariable;
	private int displayOrder;
	private String displayType;
	
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
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	
	@Override
	public String toString() {
		return "ProceduresDTO [studyID=" + studyID + ", procedureUUID=" + procedureUUID + ", Name=" + name
				+ ", cdashVariable=" + cdashVariable + ", displayOrder=" + displayOrder + ", displayType=" + displayType
				+ "]";
	}
}
