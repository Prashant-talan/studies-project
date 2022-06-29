package com.clinicalResearch.services;

import java.util.List;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.FormOIDsDTO;

public interface FormOIdsService {
	public List<FormOIDsDTO> getFormOids(int studyId) throws DataNotFoundException;
	public List<FormOIDsDTO> saveFormOids(List<FormOIDsDTO> formOidList) throws clinicalResearchException;
 
}
