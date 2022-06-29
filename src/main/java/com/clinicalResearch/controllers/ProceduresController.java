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
import com.clinicalResearch.dtos.ProceduresDTO;
import com.clinicalResearch.dtos.Response;
import com.clinicalResearch.dtos.SuccessResponse;
import com.clinicalResearch.services.ProcedureService;
import com.clinicalResearch.utility.ConvertEntityToDto;

@RestController
@Controller
public class ProceduresController {
	
	@Autowired
	ConvertEntityToDto convertEntityToDto;
	@Autowired
	ProcedureService procedureService;
	
	@GetMapping(value = "/v1/getProcedures/{studyId}")
	ResponseEntity<Response> getAllProcedures(@PathVariable("studyId") int studyId) {
		try {
			List<ProceduresDTO> procedures = convertEntityToDto.convertProcedureEntityListToDTOList(procedureService.getAllProcedures(studyId));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("Procedures List Fetched Successfully");
			successResponse.setPayload(procedures);
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
	
	@PostMapping(value = "/v1/saveProcedures")
	ResponseEntity<Response> saveAndUpdateProcedures(@RequestBody List<ProceduresDTO> proceduresDto){
		List<ProceduresDTO> procedureDto;
		try {
			procedureDto = convertEntityToDto.convertProcedureEntityListToDTOList(procedureService.saveAndUpdateProcedures(proceduresDto));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("Visit Saved Successfully");
			successResponse.setPayload(procedureDto);
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
