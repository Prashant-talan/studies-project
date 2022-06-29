package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.VisitsDTO;
import com.clinicalResearch.entity.Visits;
import com.clinicalResearch.repos.VisitsRepo;
import com.clinicalResearch.utility.ConvertEntityToDto;

@Service
public class VisitServiceImpl implements VisitService{
	
	@Autowired
	VisitsRepo visitsRepo;
	@Autowired
	ConvertEntityToDto convertEntityToDto;

	@Override
	public List<Visits> getAllVisits(int studyId) throws DataNotFoundException{
		List<Visits> visits;
		try {
		visits= visitsRepo.findByStudyID(studyId);
		}
		 catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID " + studyId);
		}
		return visits;
	}

	@Override
    public List<Visits> saveAndUpdateVisit(List<VisitsDTO> visitDTOList) throws DataNotFoundException ,clinicalResearchException {
		List<Visits> visitResponse = new ArrayList<>();
		
		for (VisitsDTO visitDTO :visitDTOList ) {
			// check if visit does already exist or not.
		    List<Visits> visitList = visitsRepo.findByStudyID(visitDTO.getStudyID());
		    Visits visitEntity = null;
            if(!visitList.isEmpty()) {
            	// when visit already exists
        	    for(Visits visit :visitList) {
        	    	if(visit.getVisitUUID().equalsIgnoreCase(visitDTO.getVisitUUID())) {
        	    		visit.setStudyID(visitDTO.getStudyID());
        			    visit.setVisitUUID(visitDTO.getVisitUUID());
        			    visit.setName(visitDTO.getName());
        			    visit.setCdashVariable(visitDTO.getCdashVariable());
        			    visit.setVisitOrder(visitDTO.getVisitOrder());
        			    visitEntity = visit;
        		    }
        	     }
            }
            try {
            	if(visitEntity==null) { // if visit doesn't exist already
            		visitEntity = convertEntityToDto.convertVisitDTOToEntity(visitDTO);	
            	 }
        	    visitResponse.add(visitsRepo.save(visitEntity));
             }
	        catch (Exception e) {
	        	e.printStackTrace();
		        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
	         }		
		 }
		return visitResponse;
    }  
	
	@Override
	public void deleteVisit(int studyId , String visitUuid) throws DataNotFoundException {
		Visits visit;
		try {
			visit = visitsRepo.findByStudyIDAndVisitUUID(studyId,visitUuid);
			visitsRepo.deleteById(visit.getId());
		}
		catch (Exception e) {
			throw new DataNotFoundException("No Data available for Study and visitUuid" + studyId);
		}
	}
	
 }


