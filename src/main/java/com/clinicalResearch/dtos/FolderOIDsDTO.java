package com.clinicalResearch.dtos;

public class FolderOIDsDTO {
	private int studyID;
	private String studyEventOID;
	private int orderNumber;
	
	public int getStudyID() {
		return studyID;
	}
	public void setStudyID(int studyID) {
		this.studyID = studyID;
	}
	public String getStudyEventOID() {
		return studyEventOID;
	}
	public void setStudyEventOID(String studyEventOID) {
		this.studyEventOID = studyEventOID;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	@Override
	public String toString() {
		return "FolderOIDsDTO [studyID=" + studyID + ", studyEventOID=" + studyEventOID + ", orderNumber=" + orderNumber
				+ "]";
	}
	
}
