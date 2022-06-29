package com.clinicalResearch.services;

import java.util.List;
import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.QuestionMappingDTO;

public interface QuestionMappingService {
	public List<QuestionMappingDTO> getQuestionMapping(int studyId) throws DataNotFoundException;
	public List<QuestionMappingDTO> saveQuestionMapping(List<QuestionMappingDTO> questionMapDtoList) throws clinicalResearchException;

}
