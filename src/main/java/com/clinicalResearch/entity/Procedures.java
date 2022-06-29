package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDURES")
public class Procedures {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Procedure_UUID")
	private String procedureUUID;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Cdash_Variable")
	private String cdashVariable;
	
	@Column(name = "Display_Order")
	private int displayOrder;
	
	@Column(name = "Display_Type")
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
		return "Procedures [studyID=" + studyID + ", procedureUUID=" + procedureUUID + ", Name=" + name
				+ ", cdashVariable=" + cdashVariable + ", displayOrder=" + displayOrder + ", displayType=" + displayType
				+ "]";
	}

}
