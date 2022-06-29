package com.clinicalResearch.services;

import java.util.List;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.VisitProceduresDTO;
import com.clinicalResearch.entity.VisitProcedures;

public interface VisitProcedureService {
	public List<VisitProceduresDTO> getVisitProcedures(int studyId,String procedureUuid) throws DataNotFoundException;
	public List<VisitProcedures> saveAndUpdateVisitProcedures(List<VisitProceduresDTO> visitProceduresList) 
			throws DataNotFoundException , clinicalResearchException;

}
