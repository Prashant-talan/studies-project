package com.clinicalResearch.services;

import java.util.List;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ProcedureQuestionsDTO;
import com.clinicalResearch.entity.ProcedureQuestion;

public interface ProcedureQuestionService {
	public List<ProcedureQuestion> getProcedureQuestions(int studyId , String procedureUid) throws DataNotFoundException; 

	public List<ProcedureQuestion> saveProcedureQuestion(List<ProcedureQuestionsDTO> pqlist) throws clinicalResearchException; 

}
