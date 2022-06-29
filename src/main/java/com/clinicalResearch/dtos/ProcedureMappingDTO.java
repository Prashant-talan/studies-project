package com.clinicalResearch.dtos;

public class ProcedureMappingDTO {
	
	private int studyID;
	private String procedureUUID;
	private String folderOID;
	private String formOID;
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
	public String getFolderOID() {
		return folderOID;
	}
	public void setFolderOID(String folderOID) {
		this.folderOID = folderOID;
	}
	public String getFormOID() {
		return formOID;
	}
	public void setFormOID(String formOID) {
		this.formOID = formOID;
	}
	
	
	@Override
	public String toString() {
		return "ProcedureMappingDTO [studyID=" + studyID + ", procedureUUID=" + procedureUUID + ", folderOID="
				+ folderOID + ", formOID=" + formOID + "]";
	}
}
