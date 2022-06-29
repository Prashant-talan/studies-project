package com.clinicalResearch.dtos;

public class VisitMappingDTO {
	
	private int studyID;
	private String visitUUID;
	private String folderOID;

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

	public String getFolderOID() {
		return folderOID;
	}

	public void setFolderOID(String folderOID) {
		this.folderOID = folderOID;
	}

	@Override
	public String toString() {
		return "VisitMapping [studyID=" + studyID + ", visitUUID=" + visitUUID + ", folderOID=" + folderOID + "]";
	}

}
