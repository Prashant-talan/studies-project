package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISIT_MAPPING")
public class VisitMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Visit_UUID")
	private String visitUUID;
	
	@Column(name = "Folder_OID")
	private String folderOID;
	
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
