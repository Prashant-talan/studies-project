package com.clinicalResearch.services;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ProcedureQuestionSelectDTO;
import com.clinicalResearch.entity.ProcedureQuestionSelect;
import com.clinicalResearch.repos.ProcedureQuestionSelectRepo;

@Service
public class ProcedureQuestionSelectServiceImpl implements ProcedureQuestionSelectService {
	
	@Autowired
	ProcedureQuestionSelectRepo pqsRepo;

	@Override
	public List<ProcedureQuestionSelect> getProcedureQuestionSelect(int studyId, String quesUid)
			throws DataNotFoundException {
		List<ProcedureQuestionSelect> procedureQuestionSelectList;
		try {
			procedureQuestionSelectList = pqsRepo.findByStudyIDAndQuestionUUID(studyId,quesUid);
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID  " + studyId);
		}
		return procedureQuestionSelectList;
	}

	@Override
	public List<ProcedureQuestionSelect> saveProcedureQuestionSelect(List<ProcedureQuestionSelectDTO> pqsDtoList)
			throws clinicalResearchException {
		List<ProcedureQuestionSelect> pqsResponse = new ArrayList<>();
		try {
			for(ProcedureQuestionSelectDTO pqsDto : pqsDtoList) {
				ProcedureQuestionSelect pqsEntity = new ProcedureQuestionSelect();
				pqsEntity.setStudyID(pqsDto.getStudyID());
				pqsEntity.setQuestionUUID(pqsDto.getQuestionUUID());
				pqsEntity.setText(pqsDto.getText());
				pqsResponse.add(pqsRepo.save(pqsEntity));
			}
		}
		catch (Exception e) {
        	e.printStackTrace();
	        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
         }
		return pqsResponse;
	}

}
