package com.clinicalResearch.dtos;

public class FormOIDsDTO {
	
	private int studyID;
	private String studyEventOID;
	private String formOID;
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
	public String getFormOID() {
		return formOID;
	}
	public void setFormOID(String formOID) {
		this.formOID = formOID;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	@Override
	public String toString() {
		return "FormOIDsDTO [studyID=" + studyID + ", studyEventOID=" + studyEventOID + ", formOID=" + formOID
				+ ", orderNumber=" + orderNumber + "]";
	}
	
}
