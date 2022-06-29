package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ProceduresDTO;
import com.clinicalResearch.entity.Procedures;
import com.clinicalResearch.repos.ProceduresRepo;
import com.clinicalResearch.utility.ConvertEntityToDto;

@Service
public class ProceduresServiceImpl implements ProcedureService {
	
	@Autowired
	ProceduresRepo procedureRepo;
	@Autowired
	ConvertEntityToDto convertEntityToDto;

	@Override
	public List<Procedures> getAllProcedures(int studyId) throws DataNotFoundException {
		List<Procedures> procedures;
		try {
			procedures = procedureRepo.findByStudyID(studyId);	
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID " + studyId);
		}
		return procedures ;
	}

	@Override
	public List<Procedures> saveAndUpdateProcedures(List<ProceduresDTO> proceduresDtoList)
			throws DataNotFoundException, clinicalResearchException {
        List<Procedures> procedureResponse = new ArrayList<>();
		for (ProceduresDTO procedureDTO :proceduresDtoList) {
			// check if visit does already exist or not.
		    List<Procedures> procedureList = procedureRepo.findByStudyID(procedureDTO.getStudyID());
		    Procedures procedureEntity = null;
            if(!procedureList.isEmpty()) {
            	// when visit already exists
        	    for(Procedures procedure :procedureList) {
        	    	if(procedure.getProcedureUUID().equalsIgnoreCase(procedureDTO.getProcedureUUID())) {
        	    		procedure.setStudyID(procedureDTO.getStudyID());
        	    		procedure.setProcedureUUID(procedureDTO.getProcedureUUID());
        	    		procedure.setName(procedureDTO.getName());
        	    		procedure.setCdashVariable(procedureDTO.getCdashVariable());
        	    		procedure.setDisplayOrder(procedureDTO.getDisplayOrder());
        	    		procedure.setDisplayType(procedureDTO.getDisplayType());
        	    		procedureEntity = procedure;
        		    }
        	     }
            }
            try {
            	if(procedureEntity==null) { // if visit doesn't exist already
            		procedureEntity = convertEntityToDto.convertProcedureDTOToEntity(procedureDTO);
            	 }
            	procedureResponse.add(procedureRepo.save(procedureEntity));
             }
	        catch (Exception e) {
	        	e.printStackTrace();
		        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
	         }		
		 }
		return procedureResponse;
	}

}
