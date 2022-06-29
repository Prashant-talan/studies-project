package com.clinicalResearch.dtos;

public class QuestionMappingDTO {

	private int studyID;
	private String questionUUID;
	private String itemGroupOID;
	private String itemFieldOID;
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

	public void setItemRepeatKey(int i) {
		this.itemRepeatKey = i;
	}

	@Override
	public String toString() {
		return "QuestionMapping [studyID=" + studyID + ", questionUUID=" + questionUUID + ", itemGroupOID="
				+ itemGroupOID + ", itemFieldOID=" + itemFieldOID + ", itemRepeatKey=" + itemRepeatKey + "]";
	}


}
