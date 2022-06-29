package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ProcedureQuestionsDTO;
import com.clinicalResearch.entity.ProcedureQuestion;
import com.clinicalResearch.repos.ProcedureQuestionRepo;

@Service
public class ProcedureQuestionServiceImpl implements ProcedureQuestionService {
	@Autowired
	ProcedureQuestionRepo pqRepo;

	@Override
	public List<ProcedureQuestion> getProcedureQuestions(int studyId, String procedureUid)
			throws DataNotFoundException {
		List<ProcedureQuestion> pqList;
		try {
			pqList = pqRepo.findByStudyIDAndProcedureUUID(studyId,procedureUid);
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID  " + studyId);
		}
		return pqList;
	}

	@Override
	public List<ProcedureQuestion> saveProcedureQuestion(List<ProcedureQuestionsDTO> pqDtoList)
			throws clinicalResearchException {
		List<ProcedureQuestion> pqResponse = new ArrayList<>();
		for(ProcedureQuestionsDTO pqDto : pqDtoList) {
			try {
				ProcedureQuestion pqEntity = new ProcedureQuestion();
				pqEntity.setStudyID(pqDto.getStudyID());
				pqEntity.setProcedureUUID(pqDto.getProcedureUUID());
				pqEntity.setQuestionUUID(pqDto.getQuestionUUID());
				pqEntity.setCdashVariable(pqDto.getCdashVariable());
				pqEntity.setQuestion(pqDto.getQuestion());
				pqEntity.setDisplayOrder(pqDto.getDisplayOrder());
				pqEntity.setQuestionType(pqDto.getQuestionType());
				pqEntity.setVariableName(pqDto.getVariableName());
				pqResponse.add(pqRepo.save(pqEntity));
			}
			catch (Exception e) {
	        	e.printStackTrace();
		        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
	         }	
		}
		return pqResponse;
	}

}
