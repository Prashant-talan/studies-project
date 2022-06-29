package com.clinicalResearch.utility;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.clinicalResearch.dtos.ProcedureQuestionSelectDTO;
import com.clinicalResearch.dtos.ProcedureQuestionsDTO;
import com.clinicalResearch.dtos.ProceduresDTO;
import com.clinicalResearch.dtos.VisitProceduresDTO;
import com.clinicalResearch.dtos.VisitsDTO;
import com.clinicalResearch.entity.ProcedureQuestion;
import com.clinicalResearch.entity.ProcedureQuestionSelect;
import com.clinicalResearch.entity.Procedures;
import com.clinicalResearch.entity.VisitProcedures;
import com.clinicalResearch.entity.Visits;

@Component
public class ConvertEntityToDto {
	
	public List<VisitsDTO> convertVisitEntityListToDTOList(List<Visits> visitsList){
		List<VisitsDTO> visitsDTOList = new  ArrayList<>(); 
		
		for(Visits visit : visitsList) {
			VisitsDTO visitDTO = new VisitsDTO();
			
			visitDTO.setStudyID(visit.getStudyID());
			visitDTO.setVisitUUID(visit.getVisitUUID());
			visitDTO.setName(visit.getName());
			visitDTO.setVisitOrder(visit.getVisitOrder());
			visitDTO.setCdashVariable(visit.getCdashVariable());
			visitsDTOList.add(visitDTO);
		}
		return visitsDTOList;	
	}
	
	public List<ProceduresDTO> convertProcedureEntityListToDTOList(List<Procedures> proceduresList){
		List<ProceduresDTO> proceduresDTOList = new  ArrayList<>(); 
		
		for(Procedures procedure : proceduresList) {
			ProceduresDTO proceduresDTO = new ProceduresDTO();
			proceduresDTO.setStudyID(procedure.getStudyID());
			proceduresDTO.setProcedureUUID(procedure.getProcedureUUID());
			proceduresDTO.setName(procedure.getName());
			proceduresDTO.setDisplayOrder(procedure.getDisplayOrder());
			proceduresDTO.setDisplayType(procedure.getDisplayType());
			proceduresDTO.setCdashVariable(procedure.getCdashVariable());
			proceduresDTOList.add(proceduresDTO);
		}
		return proceduresDTOList;	
	}
	
	public Visits convertVisitDTOToEntity(VisitsDTO visitDTO) {
		Visits visit = new Visits();
		visit.setStudyID(visitDTO.getStudyID());
		visit.setVisitUUID(visitDTO.getVisitUUID());
		visit.setName(visitDTO.getName());
		visit.setVisitOrder(visitDTO.getVisitOrder());
		visit.setCdashVariable(visitDTO.getCdashVariable());
		return visit;
	}
	
	public VisitsDTO convertVisitEntityToDTO(Visits visitEntity) {
		VisitsDTO visitDto = new VisitsDTO();
		visitDto.setStudyID(visitEntity.getStudyID());
		visitDto.setVisitUUID(visitEntity.getVisitUUID());
		visitDto.setName(visitEntity.getName());
		visitDto.setVisitOrder(visitEntity.getVisitOrder());
		visitDto.setCdashVariable(visitEntity.getCdashVariable());
		return visitDto;
	}
	
	public Procedures convertProcedureDTOToEntity(ProceduresDTO procedureDTO) {
		Procedures procedure = new Procedures();
		procedure.setStudyID(procedureDTO.getStudyID());
		procedure.setProcedureUUID(procedureDTO.getProcedureUUID());
		procedure.setName(procedureDTO.getName());
		procedure.setDisplayOrder(procedureDTO.getDisplayOrder());
		procedure.setDisplayType(procedureDTO.getDisplayType());
		procedure.setCdashVariable(procedureDTO.getCdashVariable());
		return procedure;
	}
	
	public List<VisitProceduresDTO> convertVisitProcedureEntityListToDTOList(List<VisitProcedures> vpList){
		List<VisitProceduresDTO> vpDTOList = new  ArrayList<>(); 
		for(VisitProcedures vp : vpList) {
			VisitProceduresDTO vpDTO = new VisitProceduresDTO();
			vpDTO.setStudyID(vp.getStudyID());
			vpDTO.setVisitUUID(vp.getVisitUUID());
			vpDTO.setProcedureUUID(vp.getProcedureUUID());
			vpDTOList.add(vpDTO);
		}
		return vpDTOList;	
	}
	
	public List<ProcedureQuestionsDTO> convertProcedureQuesEntityListToDTOList(List<ProcedureQuestion> pqEntityList){
		List<ProcedureQuestionsDTO> pqDTOList = new  ArrayList<>(); 
		for(ProcedureQuestion pqEntity : pqEntityList) {
			ProcedureQuestionsDTO pqDTO = new ProcedureQuestionsDTO();
			pqDTO.setStudyID(pqEntity.getStudyID());
			pqDTO.setProcedureUUID(pqEntity.getProcedureUUID());
			pqDTO.setQuestionUUID(pqEntity.getQuestionUUID());
			pqDTO.setDisplayOrder(pqEntity.getDisplayOrder());
			pqDTO.setQuestion(pqEntity.getQuestion());
			pqDTO.setCdashVariable(pqEntity.getCdashVariable());
			pqDTO.setVariableName(pqEntity.getVariableName());
			pqDTO.setQuestionType(pqEntity.getQuestionType());
			pqDTOList.add(pqDTO);
		}
		return pqDTOList;	
	}
	
	public List<ProcedureQuestionSelectDTO> convertProcedureQuestionSelectEntityToDto(List<ProcedureQuestionSelect> pqsEntityList){
		List<ProcedureQuestionSelectDTO> pqsDtoList = new  ArrayList<>(); 
		
		for(ProcedureQuestionSelect pqsEntity :pqsEntityList) {
			ProcedureQuestionSelectDTO pqsDto = new ProcedureQuestionSelectDTO();
			pqsDto.setQuestionUUID(pqsEntity.getQuestionUUID());
			pqsDto.setStudyID(pqsEntity.getStudyID());
			pqsDto.setText(pqsEntity.getText());
			pqsDtoList.add(pqsDto);
		}
		return pqsDtoList;
	}

}
