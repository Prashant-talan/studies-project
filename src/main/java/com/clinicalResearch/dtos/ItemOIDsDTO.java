package com.clinicalResearch.dtos;

public class ItemOIDsDTO {
	
	private int studyID;
	private String formOID;
	private String itemGroupOID;
	private String itemOID;
	public int getStudyID() {
		return studyID;
	}
	public void setStudyID(int studyID) {
		this.studyID = studyID;
	}
	public String getFormOID() {
		return formOID;
	}
	public void setFormOID(String formOID) {
		this.formOID = formOID;
	}
	public String getItemGroupOID() {
		return itemGroupOID;
	}
	public void setItemGroupOID(String itemGroupOID) {
		this.itemGroupOID = itemGroupOID;
	}
	public String getItemOID() {
		return itemOID;
	}
	public void setItemOID(String itemOID) {
		this.itemOID = itemOID;
	}
	
	@Override
	public String toString() {
		return "ItemOIDsDTO [studyID=" + studyID + ", formOID=" + formOID + ", itemGroupOID=" + itemGroupOID
				+ ", itemOID=" + itemOID + "]";
	}
}
