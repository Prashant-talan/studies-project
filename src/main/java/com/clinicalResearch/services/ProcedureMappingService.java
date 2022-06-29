package com.clinicalResearch.services;

import java.util.List;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ProcedureMappingDTO;

public interface ProcedureMappingService {
	public List<ProcedureMappingDTO> getProcedureMapping(int studyId) throws DataNotFoundException;

	public List<ProcedureMappingDTO> saveProcedureMapping(List<ProcedureMappingDTO> procedureMapDtoList ) throws clinicalResearchException;

}
