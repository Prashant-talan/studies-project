package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISITS")
public class Visits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Visit_UUID")
	private String visitUUID;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Cdash_Variable")
	private String cdashVariable;
	
	@Column(name = "Visit_Order")
	private int visitOrder;
	
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
