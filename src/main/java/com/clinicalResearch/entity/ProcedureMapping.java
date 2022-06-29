package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDURE_MAPPING")
public class ProcedureMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Procedure_UUID")
	private String procedureUUID;
	
	@Column(name = "Folder_OID")
	private String folderOID;
	
	@Column(name = "Form_OID")
	private String formOID;

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
		return "ProcedureMapping [studyID=" + studyID + ", procedureUUID=" + procedureUUID + ", folderOID=" + folderOID
				+ ", formOID=" + formOID + "]";
	}

}
