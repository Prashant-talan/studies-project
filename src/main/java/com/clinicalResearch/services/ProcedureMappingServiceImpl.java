package com.clinicalResearch.services;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ProcedureMappingDTO;
import com.clinicalResearch.entity.ProcedureMapping;
import com.clinicalResearch.repos.ProcedureMappingRepo;

@Service
public class ProcedureMappingServiceImpl implements ProcedureMappingService{
	
	@Autowired
	ProcedureMappingRepo procedureMapRepo;
	
	@Override
	public List<ProcedureMappingDTO> getProcedureMapping(int studyId) throws DataNotFoundException {
		List<ProcedureMappingDTO> procedureDtoList = new ArrayList<>();
		try {
			List<ProcedureMapping> procedureMapList = procedureMapRepo.findByStudyID(studyId);
			if(procedureMapList.isEmpty()) {
				throw new DataNotFoundException("No Data available for Study ID  " + studyId);
			}
			for(ProcedureMapping procedureMap :procedureMapList) {
				ProcedureMappingDTO procedureMapDto = new ProcedureMappingDTO();
				procedureMapDto.setStudyID(procedureMap.getStudyID());
				procedureMapDto.setFolderOID(procedureMap.getFolderOID());
				procedureMapDto.setFormOID(procedureMap.getFormOID());
				procedureMapDto.setProcedureUUID(procedureMap.getProcedureUUID());
				procedureDtoList.add(procedureMapDto);
			}
		}
		catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data available for Study ID  " + studyId);
		}
		return procedureDtoList;
	}

	@Override
	public List<ProcedureMappingDTO> saveProcedureMapping(List<ProcedureMappingDTO> procedureMapDtoList)
			throws clinicalResearchException {
		List<ProcedureMapping> procedureEntityList = new ArrayList<>();
		List<ProcedureMappingDTO> procedureDtoResponse = new ArrayList<>();
		try {
			for(ProcedureMappingDTO procedureMapDto :procedureMapDtoList ) {
				ProcedureMapping procedureMapEntity = new ProcedureMapping();
				procedureMapEntity.setStudyID(procedureMapDto.getStudyID());
				procedureMapEntity.setProcedureUUID(procedureMapDto.getProcedureUUID());
				procedureMapEntity.setFolderOID(procedureMapDto.getFolderOID());
				procedureMapEntity.setFormOID(procedureMapDto.getFormOID());
				procedureEntityList.add(procedureMapRepo.save(procedureMapEntity));
			}
			for(ProcedureMapping procedureEntity : procedureEntityList) {
				ProcedureMappingDTO procedureDto = new ProcedureMappingDTO();
				procedureDto.setStudyID(procedureEntity.getStudyID());
				procedureDto.setProcedureUUID(procedureEntity.getProcedureUUID());
				procedureDto.setFormOID(procedureEntity.getFormOID());
				procedureDto.setFolderOID(procedureEntity.getFolderOID());
				procedureDtoResponse.add(procedureDto);
			}
		}
		catch (Exception e) {
        	e.printStackTrace();
	        throw new clinicalResearchException("OOPS... Some Error Occured in Saving And Updating");
		}
		return procedureDtoResponse;
	}

}
