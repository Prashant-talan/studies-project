package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORM_OIDs")
public class FormOIDs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Study_Event_OID")
	private String studyEventOID;
	
	@Column(name = "Form_OID")
	private String formOID;
	
	@Column(name = "Order_Number")
	private int orderNumber;
	
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
		return "FormOIDs [studyID=" + studyID + ", studyEventOID=" + studyEventOID + ", formOID=" + formOID
				+ ", orderNumber=" + orderNumber + "]";
	}
    
}
