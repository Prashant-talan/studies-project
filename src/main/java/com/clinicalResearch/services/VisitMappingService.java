package com.clinicalResearch.services;

import java.util.List;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.VisitMappingDTO;

public interface VisitMappingService {
	
	public List<VisitMappingDTO> saveVisitMapping(List<VisitMappingDTO> visitMapList) throws clinicalResearchException;
	public List<VisitMappingDTO> getVisitMapping(int studyId) throws DataNotFoundException;

}
