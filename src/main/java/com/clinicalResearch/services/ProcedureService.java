package com.clinicalResearch.services;

import java.util.List;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ProceduresDTO;
import com.clinicalResearch.entity.Procedures;

public interface ProcedureService {
	public List<Procedures> getAllProcedures(int studyId) throws DataNotFoundException;
	public List<Procedures> saveAndUpdateProcedures(List<ProceduresDTO> procedures) throws DataNotFoundException,clinicalResearchException;
}
