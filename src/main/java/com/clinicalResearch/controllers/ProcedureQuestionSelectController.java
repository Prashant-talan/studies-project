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
import com.clinicalResearch.dtos.ProcedureQuestionSelectDTO;
import com.clinicalResearch.dtos.Response;
import com.clinicalResearch.dtos.SuccessResponse;
import com.clinicalResearch.services.ProcedureQuestionSelectService;
import com.clinicalResearch.utility.ConvertEntityToDto;

@RestController
@Controller
public class ProcedureQuestionSelectController {

	@Autowired
	ProcedureQuestionSelectService pqsService;
	@Autowired
	ConvertEntityToDto convertEntityToDto;
	
	@GetMapping(value = "/v1/getProcedureQuestionSelect/{studyId}/{quesUuid}")
	ResponseEntity<Response> getAllProcedureQuesSelect(@PathVariable("studyId") int studyId ,
			@PathVariable("quesUuid") String quesUuid) {
		List<ProcedureQuestionSelectDTO> pqsDtoList;
		try {
			pqsDtoList = convertEntityToDto.convertProcedureQuestionSelectEntityToDto(pqsService.getProcedureQuestionSelect(studyId, quesUuid));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("ProcedureQuestion List Fetched Successfully");
			successResponse.setPayload(pqsDtoList);
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
	
	@PostMapping(value = "/v1/saveProcedureQuestionSelect")
	ResponseEntity<Response> saveProcedureQuesSelect(@RequestBody List<ProcedureQuestionSelectDTO> pqsDtoList ){
		List<ProcedureQuestionSelectDTO> savedDtoList;
		try {
			savedDtoList = convertEntityToDto.convertProcedureQuestionSelectEntityToDto(pqsService.saveProcedureQuestionSelect(pqsDtoList));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("ProcedureQuestionSelect List Saved Successfully");
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
