package com.clinicalResearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION_MAPPING")
public class QuestionMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Study_ID")
	private int studyID;
	
	@Column(name = "Question_UUID")
	private String questionUUID;
	
	@Column(name = "Item_Group_OID")
	private String itemGroupOID;
	
	@Column(name = "Item_Field_OID")
	private String itemFieldOID;
	
	@Column(name = "Item_Repeat_Key")
	private int itemRepeatKey;

	public int getStudyID() {
		return studyID;
	}

	public void setStudyID(int studyID) {
		this.studyID = studyID;
	}

	public String getQuestionUUID() {
		return questionUUID;
	}

	public void setQuestionUUID(String questionUUID) {
		this.questionUUID = questionUUID;
	}

	public String getItemGroupOID() {
		return itemGroupOID;
	}

	public void setItemGroupOID(String itemGroupOID) {
		this.itemGroupOID = itemGroupOID;
	}

	public String getItemFieldOID() {
		return itemFieldOID;
	}

	public void setItemFieldOID(String itemFieldOID) {
		this.itemFieldOID = itemFieldOID;
	}

	public int getItemRepeatKey() {
		return itemRepeatKey;
	}

	public void setItemRepeatKey(int itemRepeatKey) {
		this.itemRepeatKey = itemRepeatKey;
	}

	@Override
	public String toString() {
		return "QuestionMapping [studyID=" + studyID + ", questionUUID=" + questionUUID + ", itemGroupOID="
				+ itemGroupOID + ", itemFieldOID=" + itemFieldOID + ", itemRepeatKey=" + itemRepeatKey + "]";
	}

}
