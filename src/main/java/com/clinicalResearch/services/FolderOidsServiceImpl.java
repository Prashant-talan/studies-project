package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.FolderOIDsDTO;
import com.clinicalResearch.entity.FolderOIDs;
import com.clinicalResearch.repos.FolderOIDsRepo;

@Service
public class FolderOidsServiceImpl implements FolderOidsService {
	@Autowired
	FolderOIDsRepo folderOidRepo;

	@Override
	public List<FolderOIDsDTO> getFolderOids(int studyId) throws DataNotFoundException {
		List<FolderOIDsDTO> folderOidDtoList = new ArrayList<>();
		try {
			List<FolderOIDs> folderOidList = folderOidRepo.findByStudyID(studyId);
			if(folderOidList.isEmpty()) {
				throw new DataNotFoundException("No Data available for Study ID  " + studyId);
			}
			for(FolderOIDs folderOid :folderOidList ) {
				FolderOIDsDTO folderOidDto = new FolderOIDsDTO();
				folderOidDto.setStudyID(folderOid.getStudyID());
				folderOidDto.setOrderNumber(folderOid.getOrderNumber());
				folderOidDto.setStudyEventOID(folderOid.getStudyEventOID());
				folderOidDtoList.add(folderOidDto);
			}
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID  " + studyId);
		}
		return folderOidDtoList;
	}

	@Override
	public List<FolderOIDsDTO> saveFolderOids(List<FolderOIDsDTO> folderOidsDtoList) throws clinicalResearchException {
		List<FolderOIDs> folderIdResponse =  new ArrayList<>();
		List<FolderOIDsDTO> folderOidDtoList = new ArrayList<>();
		for(FolderOIDsDTO folderOid :folderOidsDtoList ) {
			try {
				FolderOIDs fOid = new FolderOIDs();
				fOid.setOrderNumber(folderOid.getOrderNumber());
				fOid.setStudyID(folderOid.getStudyID());
				fOid.setStudyEventOID(folderOid.getStudyEventOID());			
				folderIdResponse.add(folderOidRepo.save(fOid));
			}
			catch (Exception e) {
	        	e.printStackTrace();
		        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
	         }		
		}
		for(FolderOIDs folderOid :folderIdResponse ) {
			FolderOIDsDTO folderOidDto = new FolderOIDsDTO();
			folderOidDto.setStudyID(folderOid.getStudyID());
			folderOidDto.setOrderNumber(folderOid.getOrderNumber());
			folderOidDto.setStudyEventOID(folderOid.getStudyEventOID());
			folderOidDtoList.add(folderOidDto);
		}
		return folderOidDtoList;
	}

}
