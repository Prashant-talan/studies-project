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
import com.clinicalResearch.dtos.ProcedureMappingDTO;
import com.clinicalResearch.dtos.Response;
import com.clinicalResearch.dtos.SuccessResponse;
import com.clinicalResearch.services.ProcedureMappingService;

@RestController
@Controller
public class ProcedureMappingController {
	
	@Autowired
	ProcedureMappingService procedureMapService;
	
	@GetMapping(value = "/v1/getProcedureMapping/{studyId}")
	ResponseEntity<Response> getProcedureMapping(@PathVariable("studyId") int studyId) {
		try {
			List<ProcedureMappingDTO> procedureMapList = procedureMapService.getProcedureMapping(studyId);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("ProcedureMapping List Fetched Successfully");
			successResponse.setPayload(procedureMapList);
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
	
	@PostMapping(value = "/v1/saveProcedureMapping")
	ResponseEntity<Response> saveProcedureMappings(@RequestBody List<ProcedureMappingDTO> procedureMapList){
		List<ProcedureMappingDTO> procedureMapResponse;
		try {
			procedureMapResponse = procedureMapService.saveProcedureMapping(procedureMapList);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("ProcedureMapping List Saved Successfully");
			successResponse.setPayload(procedureMapResponse);
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
