package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.VisitMappingDTO;
import com.clinicalResearch.entity.VisitMapping;
import com.clinicalResearch.repos.VisitMappingRepo;

@Service
public class VisitMappingServiceImpl implements VisitMappingService {
	
	@Autowired
	VisitMappingRepo vmRepo;
	
	@Override
	public List<VisitMappingDTO> getVisitMapping(int studyId) throws DataNotFoundException {
		List<VisitMappingDTO> vmDtoList = new ArrayList<>();
		try {
			List<VisitMapping> visitMapList = vmRepo.findByStudyID(studyId);
			if(visitMapList.isEmpty()) {
				throw new DataNotFoundException("No Data available for Study ID  " + studyId);
			}
			for(VisitMapping visitMap :visitMapList) {
				VisitMappingDTO visitMapDto = new VisitMappingDTO();
				visitMapDto.setStudyID(visitMap.getStudyID());
				visitMapDto.setFolderOID(visitMap.getFolderOID());
				visitMapDto.setVisitUUID(visitMap.getVisitUUID());
				vmDtoList.add(visitMapDto);
			}
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID  " + studyId);
		}
		return vmDtoList;
	}

	@Override
	public List<VisitMappingDTO> saveVisitMapping(List<VisitMappingDTO> visitMapList) throws clinicalResearchException {
		List<VisitMapping> vmEntityList = new ArrayList<>();
		List<VisitMappingDTO> vmDtoResponse = new ArrayList<>();
		try {
			for(VisitMappingDTO visitMapDto :visitMapList ) {
				VisitMapping visitMapEntity = new VisitMapping();
				visitMapEntity.setStudyID(visitMapDto.getStudyID());
				visitMapEntity.setFolderOID(visitMapDto.getFolderOID());
				visitMapEntity.setVisitUUID(visitMapDto.getVisitUUID());
				vmEntityList.add(vmRepo.save(visitMapEntity));
			}
			// converting Entity List to Dto List
			for(VisitMapping vmEntity : vmEntityList) {
				VisitMappingDTO vmDto = new VisitMappingDTO();
				vmDto.setStudyID(vmEntity.getStudyID());
				vmDto.setVisitUUID(vmEntity.getVisitUUID());
				vmDto.setFolderOID(vmEntity.getFolderOID());
				vmDtoResponse.add(vmDto);
			}
		}
		catch (Exception e) {
        	e.printStackTrace();
	        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
		}
		return vmDtoResponse;
	}

	

}
