package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.FormOIDsDTO;
import com.clinicalResearch.entity.FormOIDs;
import com.clinicalResearch.repos.FormOIDsRepo;

@Service
public class FormOIdsServiceImpl implements FormOIdsService{
	
	@Autowired
	FormOIDsRepo formOidsRepo;
	
	@Override
	public List<FormOIDsDTO> getFormOids(int studyId) throws DataNotFoundException {
		List<FormOIDsDTO> formOidDtoList = new ArrayList<>();
		try {
			List<FormOIDs> formOidList = formOidsRepo.findByStudyID(studyId);
			if(formOidList.isEmpty()) {
				throw new DataNotFoundException("No Data available for Study ID  " + studyId);
			}
			for(FormOIDs formOid :formOidList ) {
				FormOIDsDTO formOidDto = new FormOIDsDTO();
				formOidDto.setStudyID(formOid.getStudyID());
				formOidDto.setOrderNumber(formOid.getOrderNumber());
				formOidDto.setStudyEventOID(formOid.getStudyEventOID());
				formOidDto.setFormOID(formOid.getFormOID());
				formOidDtoList.add(formOidDto);
			}
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID  " + studyId);
		}
		return formOidDtoList;
	}

	@Override    
	public List<FormOIDsDTO> saveFormOids(List<FormOIDsDTO> formOidsDtoList) throws clinicalResearchException {
		List<FormOIDs> formIdResponse =  new ArrayList<>();
		List<FormOIDsDTO> formOidDtoList = new ArrayList<>();
		for(FormOIDsDTO formOid :formOidsDtoList ) {
			try {
				FormOIDs fOid = new FormOIDs();
				fOid.setOrderNumber(formOid.getOrderNumber());
				fOid.setStudyID(formOid.getStudyID());
				fOid.setStudyEventOID(formOid.getStudyEventOID());
				fOid.setFormOID(formOid.getFormOID());				
				formIdResponse.add(formOidsRepo.save(fOid));
			}
			catch (Exception e) {
	        	e.printStackTrace();
		        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
	         }		
		}
		for(FormOIDs formOid :formIdResponse ) {
			FormOIDsDTO formOidDto = new FormOIDsDTO();
			formOidDto.setStudyID(formOid.getStudyID());
			formOidDto.setOrderNumber(formOid.getOrderNumber());
			formOidDto.setStudyEventOID(formOid.getStudyEventOID());
			formOidDto.setFormOID(formOid.getFormOID());
			formOidDtoList.add(formOidDto);
		}
		return formOidDtoList;
	}

	

}
