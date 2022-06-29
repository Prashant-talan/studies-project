package com.clinicalResearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ItemOIDsDTO;
import com.clinicalResearch.entity.ItemOIDs;
import com.clinicalResearch.repos.ItemOIDsRepo;

@Service
public class ItemOidsServiceImpl implements ItemOidsService {
	@Autowired
	ItemOIDsRepo itemOidsRepo;

	@Override
	public List<ItemOIDsDTO> getItemOids(int studyId, String formOid) throws DataNotFoundException {
		List<ItemOIDs> itemOidsEntityList;
		List<ItemOIDsDTO> itemDtoList =  new ArrayList<>();
		try {
			if(formOid == null||formOid.equalsIgnoreCase("null") || formOid.equalsIgnoreCase("") ) {
				itemOidsEntityList = itemOidsRepo.findByStudyID(studyId);
			}
			else {
				itemOidsEntityList = itemOidsRepo.findByStudyIDAndFormOID(studyId,formOid);
			}
			if(itemOidsEntityList.isEmpty()) {
				throw new DataNotFoundException("No Data available for Study ID  " + studyId);
			}
			for(ItemOIDs itemIdo :itemOidsEntityList) {
				ItemOIDsDTO itemDto = new ItemOIDsDTO();
				itemDto.setStudyID(itemIdo.getStudyID());
				itemDto.setFormOID(itemIdo.getFormOID());
				itemDto.setItemOID(itemIdo.getItemOID());
				itemDto.setItemGroupOID(itemIdo.getItemGroupOID());
				itemDtoList.add(itemDto);
			}
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID  " + studyId);
		}
		return itemDtoList;
	}

	@Override
	public List<ItemOIDsDTO> saveItemOid(List<ItemOIDsDTO> itemOidsDtoList) throws clinicalResearchException {
		List<ItemOIDs> itemIodResponse =  new ArrayList<>();
		List<ItemOIDsDTO> itemOidDtoList = new ArrayList<>();
		for(ItemOIDsDTO itemOidDto :itemOidsDtoList ) {
			try {
				ItemOIDs itemOid = new ItemOIDs();
				itemOid.setItemGroupOID(itemOidDto.getItemGroupOID());
				itemOid.setStudyID(itemOidDto.getStudyID());
				itemOid.setFormOID(itemOidDto.getFormOID());
				itemOid.setItemOID(itemOidDto.getItemOID());
				itemIodResponse.add(itemOidsRepo.save(itemOid));
			}
			catch (Exception e) {
	        	e.printStackTrace();
		        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
	         }		
		}
		for(ItemOIDs formOid :itemIodResponse ) {
			ItemOIDsDTO itemOidDto = new ItemOIDsDTO();
			itemOidDto.setStudyID(formOid.getStudyID());
			itemOidDto.setItemGroupOID(formOid.getItemGroupOID());
			itemOidDto.setItemOID(formOid.getItemOID());
			itemOidDto.setFormOID(formOid.getFormOID());
			itemOidDtoList.add(itemOidDto);
		}
		return itemOidDtoList;
	}

}
