package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISIT_PROCEDURES")
public class VisitProcedures {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Visit_UUID")
	private String visitUUID;
	
	@Column(name = "Procedure_UUID")
	private String procedureUUID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
