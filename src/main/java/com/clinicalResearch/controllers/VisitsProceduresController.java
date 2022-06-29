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
import com.clinicalResearch.dtos.Response;
import com.clinicalResearch.dtos.SuccessResponse;
import com.clinicalResearch.dtos.VisitProceduresDTO;
import com.clinicalResearch.services.VisitProcedureService;
import com.clinicalResearch.utility.ConvertEntityToDto;

@RestController
@Controller
public class VisitsProceduresController {
	@Autowired 
	VisitProcedureService vpService;
	@Autowired
	ConvertEntityToDto convertEntityToDto;

	@GetMapping(value = "/v1/getVisitProcedure/{studyId}/{procedureUuid}")
	ResponseEntity<Response> getVisitProcedures(@PathVariable("studyId") int studyId ,
			@PathVariable("procedureUuid") String procedureUuid) {
		List<VisitProceduresDTO> visitProceduresList;
		try {
			visitProceduresList = vpService.getVisitProcedures(studyId, procedureUuid);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("Visit List Fetched Successfully");
			successResponse.setPayload(visitProceduresList);
			return ResponseEntity.status(HttpStatus.OK).body(successResponse);
		}
		catch (DataNotFoundException e) {
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
	
	@PostMapping(value = "/v1/saveVisitProcedure")
	ResponseEntity<Response> saveAndUpdateVisitProcedures(@RequestBody List<VisitProceduresDTO> vpDtoList){
		List<VisitProceduresDTO> vpList;
		try {
			vpList = convertEntityToDto.convertVisitProcedureEntityListToDTOList(vpService.saveAndUpdateVisitProcedures(vpDtoList));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("Visit Procedure List Saved Successfully");
			successResponse.setPayload(vpList);
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
		catch (DataNotFoundException e) {
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
}
