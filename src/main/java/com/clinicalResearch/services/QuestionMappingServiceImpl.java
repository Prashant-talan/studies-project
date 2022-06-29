package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.QuestionMappingDTO;
import com.clinicalResearch.entity.QuestionMapping;
import com.clinicalResearch.repos.QuestionMappingRepo;

@Service
public class QuestionMappingServiceImpl implements QuestionMappingService {
	
	@Autowired
	QuestionMappingRepo quesMapRepo;

	@Override
	public List<QuestionMappingDTO> getQuestionMapping(int studyId) throws DataNotFoundException {
		List<QuestionMapping> quesMapList ;
		List<QuestionMappingDTO> quesMapDtoList = new ArrayList<>() ;

		try {
			quesMapList = quesMapRepo.findAllByStudyID(studyId);
			if(quesMapList.isEmpty()) {
				throw new DataNotFoundException("No Data available for Study ID " + studyId);
			}
			for(QuestionMapping quesMap :quesMapList) {
				QuestionMappingDTO quesMapDto = new QuestionMappingDTO();
				quesMapDto.setStudyID(quesMap.getStudyID());
				quesMapDto.setItemFieldOID(quesMap.getItemFieldOID());
				quesMapDto.setItemGroupOID(quesMap.getItemGroupOID());
				quesMapDto.setQuestionUUID(quesMap.getQuestionUUID());
				quesMapDto.setItemRepeatKey(quesMap.getItemRepeatKey());
				quesMapDtoList.add(quesMapDto);
			}
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID " + studyId);
		}
		return quesMapDtoList;
	}

	@Override
	public List<QuestionMappingDTO> saveQuestionMapping(List<QuestionMappingDTO> questionMapDtoList)
			throws clinicalResearchException {
		List<QuestionMapping> quesMapEntityList = new ArrayList<>();
		List<QuestionMappingDTO> quesMapDTOResponse = new ArrayList<>();

		try {
			for(QuestionMappingDTO quesMapDto: questionMapDtoList ) {
				QuestionMapping quesMapEntity = new QuestionMapping();
				quesMapEntity.setQuestionUUID(quesMapDto.getQuestionUUID());
				quesMapEntity.setStudyID(quesMapDto.getStudyID());
				quesMapEntity.setItemFieldOID(quesMapDto.getItemFieldOID());
				quesMapEntity.setItemGroupOID(quesMapDto.getItemGroupOID());
				quesMapEntity.setItemRepeatKey(quesMapDto.getItemRepeatKey());
				quesMapEntityList.add(quesMapRepo.save(quesMapEntity));
			}
			// converting Entity List to Dto List
			for(QuestionMapping quesMap :quesMapEntityList) {
				QuestionMappingDTO quesMapDto = new QuestionMappingDTO();
				quesMapDto.setStudyID(quesMap.getStudyID());
				quesMapDto.setItemFieldOID(quesMap.getItemFieldOID());
				quesMapDto.setItemGroupOID(quesMap.getItemGroupOID());
				quesMapDto.setQuestionUUID(quesMap.getQuestionUUID());
				quesMapDto.setItemRepeatKey(quesMap.getItemRepeatKey());
				quesMapDTOResponse.add(quesMapDto);
			}	
		}
		catch (Exception e) {
        	e.printStackTrace();
	        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
		}
		return quesMapDTOResponse;
	}
	
}
