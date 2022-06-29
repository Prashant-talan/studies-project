package com.clinicalResearch.services;

import java.util.List;
import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ProcedureQuestionSelectDTO;
import com.clinicalResearch.entity.ProcedureQuestionSelect;

public interface ProcedureQuestionSelectService {
	public List<ProcedureQuestionSelect> getProcedureQuestionSelect(int studyId,String quesUid) throws DataNotFoundException;
	public List<ProcedureQuestionSelect> saveProcedureQuestionSelect(List<ProcedureQuestionSelectDTO> pqsDto) throws clinicalResearchException;

}
