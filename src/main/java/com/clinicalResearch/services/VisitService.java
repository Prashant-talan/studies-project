package com.clinicalResearch.services;

import java.util.List;
import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.VisitsDTO;
import com.clinicalResearch.entity.Visits;

public interface VisitService {
	
	public  List<Visits> getAllVisits(int studyId) throws DataNotFoundException;
	public List<Visits> saveAndUpdateVisit(List<VisitsDTO> visitDTO) throws DataNotFoundException , clinicalResearchException;
	public void deleteVisit(int studyId , String visitId) throws DataNotFoundException;
}
