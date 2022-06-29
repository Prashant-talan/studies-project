package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.VisitProceduresDTO;
import com.clinicalResearch.entity.VisitProcedures;
import com.clinicalResearch.repos.VisitProceduresRepo;

@Service
public class VisitProcedureServiceImpl implements VisitProcedureService {
	@Autowired
	VisitProceduresRepo visitProceduresRepo;

	@Override
	public List<VisitProceduresDTO> getVisitProcedures(int studyId, String procedureUuid)
			throws DataNotFoundException {
		List<VisitProcedures> visitProceduresList;
		VisitProceduresDTO vpDto = new VisitProceduresDTO() ;
		List<VisitProceduresDTO> vpDtoList = new ArrayList<>();
		try {
			visitProceduresList = visitProceduresRepo.findByStudyIDAndProcedureUUID(studyId,procedureUuid);
			for(VisitProcedures visitProcedure : visitProceduresList) {
				vpDto.setStudyID(visitProcedure.getStudyID());
				vpDto.setVisitUUID(visitProcedure.getVisitUUID());
				vpDto.setProcedureUUID(visitProcedure.getProcedureUUID());
				vpDtoList.add(vpDto);
			}
		}
		catch (NoSuchElementException e) {
				throw new DataNotFoundException("No Data available for Study ID  " + studyId);
			}
		return vpDtoList;
	}

	@Override
	public List<VisitProcedures> saveAndUpdateVisitProcedures(List<VisitProceduresDTO> visitProceduresList)
			throws DataNotFoundException, clinicalResearchException {
		List<VisitProcedures> vpResponse = new ArrayList<>(); 
		for(VisitProceduresDTO vpDto : visitProceduresList) {
			VisitProcedures vpEntity = null;
			try {
				List<VisitProcedures> vpList =  visitProceduresRepo.
						findByStudyIDAndProcedureUUID(vpDto.getStudyID(),vpDto.getProcedureUUID());
				if(!vpList.isEmpty()) {
					VisitProcedures vp = new VisitProcedures();
					vp.setId(vpList.get(0).getId());
					vp.setProcedureUUID(vpDto.getProcedureUUID());
					vp.setStudyID(vpDto.getStudyID());
					vp.setVisitUUID(vpDto.getVisitUUID());
					vpEntity = vp;
				}
				
				if(vpEntity == null) {
					VisitProcedures vp = new VisitProcedures();
					vp.setProcedureUUID(vpDto.getProcedureUUID());
					vp.setStudyID(vpDto.getStudyID());
					vp.setVisitUUID(vpDto.getVisitUUID());
					vpEntity = vp;
				}
				vpResponse.add(visitProceduresRepo.save(vpEntity));	
			}
			catch (Exception e) {
	        	e.printStackTrace();
		        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
	         }	
		}
		return vpResponse;
	}

}
