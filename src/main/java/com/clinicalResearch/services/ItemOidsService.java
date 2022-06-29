package com.clinicalResearch.services;

import java.util.List;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ItemOIDsDTO;

public interface ItemOidsService {
	public List<ItemOIDsDTO> getItemOids(int studyId , String formOid) throws DataNotFoundException;
	public List<ItemOIDsDTO> saveItemOid(List<ItemOIDsDTO> itemOidDtoList) throws clinicalResearchException;
}
