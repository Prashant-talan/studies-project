package com.clinicalResearch.controllers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ErrorResponse;
import com.clinicalResearch.dtos.ProcedureQuestionsDTO;
import com.clinicalResearch.dtos.Response;
import com.clinicalResearch.dtos.SuccessResponse;
import com.clinicalResearch.services.ProcedureQuestionService;
import com.clinicalResearch.utility.ConvertEntityToDto;

@RestController
@Controller
public class ProcedureQuestionController {
	@Autowired
	ConvertEntityToDto convertEntityToDto;
	@Autowired
	ProcedureQuestionService pqService;
	
	@GetMapping(value = "/v1/getProcedureQuestions/{studyId}/{procedureUid}")
	ResponseEntity<Response> getAllProcedureQues(@PathVariable("studyId") int studyId ,
			@PathVariable("procedureUid") String procedureUuid) {
		List<ProcedureQuestionsDTO> pqDtoList;
		try {
			pqDtoList =convertEntityToDto.convertProcedureQuesEntityListToDTOList(pqService.getProcedureQuestions(studyId, procedureUuid));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("ProcedureQuestion List Fetched Successfully");
			successResponse.setPayload(pqDtoList);
			return ResponseEntity.status(HttpStatus.OK).body(successResponse);
		}
		catch(DataNotFoundException e) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setCode(404);
			errorResponse.setMessage(e.getMessage());
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			errorResponse.setStackTrace(sw.toString());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
	@PostMapping(value = "/v1/saveProcedureQuestion")
	ResponseEntity<Response> saveProcedureQues(@RequestBody List<ProcedureQuestionsDTO> pqDtoList ){
		List<ProcedureQuestionsDTO> savedDtoList;
		try {
			savedDtoList =convertEntityToDto.convertProcedureQuesEntityListToDTOList(pqService.saveProcedureQuestion(pqDtoList));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("ProcedureQuestions List Saved Successfully");
			successResponse.setPayload(savedDtoList);
			return ResponseEntity.status(HttpStatus.OK).body(successResponse);	
		}
		catch (clinicalResearchException e) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setCode(500);
			errorResponse.setMessage(e.getMessage());
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			errorResponse.setStackTrace(sw.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}
	

}
