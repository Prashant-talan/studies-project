package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_OIDs")
public class ItemOIDs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Form_OID")
	private String formOID;
	
	@Column(name = "Item_Group_OID")
	private String itemGroupOID;
	
	@Column(name = "Item_OID")
	private String itemOID;

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
		return "ItemOIDs [studyID=" + studyID + ", formOID=" + formOID + ", itemGroupOID=" + itemGroupOID + ", itemOID="
				+ itemOID + "]";
	}
	
}
