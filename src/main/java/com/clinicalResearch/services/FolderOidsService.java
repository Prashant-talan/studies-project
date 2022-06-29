package com.clinicalResearch.services;

import java.util.List;
import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.FolderOIDsDTO;

public interface FolderOidsService {
	public List<FolderOIDsDTO> getFolderOids(int studyId) throws DataNotFoundException;
	public List<FolderOIDsDTO> saveFolderOids(List<FolderOIDsDTO> folderOidsList) throws clinicalResearchException;

}
