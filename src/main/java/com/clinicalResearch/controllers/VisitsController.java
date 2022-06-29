package com.clinicalResearch.controllers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.clinicalResearch.Exceptions.DataNotFoundException;
import com.clinicalResearch.Exceptions.clinicalResearchException;
import com.clinicalResearch.dtos.ErrorResponse;
import com.clinicalResearch.dtos.Response;
import com.clinicalResearch.dtos.SuccessResponse;
import com.clinicalResearch.dtos.VisitsDTO;
import com.clinicalResearch.services.VisitService;
import com.clinicalResearch.utility.ConvertEntityToDto;


@RestController
@Controller
public class VisitsController {
	
	@Autowired
	VisitService visitService;
	@Autowired
	ConvertEntityToDto convertEntityToDto;
	
	@GetMapping(value = "/v1/getVisits/{studyId}")
	ResponseEntity<Response> getAllVisits(@PathVariable("studyId") int studyId) {
		try {
			List<VisitsDTO> visits = convertEntityToDto.convertVisitEntityListToDTOList(visitService.getAllVisits(studyId));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("Visit List Fetched Successfully");
			successResponse.setPayload(visits);
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
	
	@PostMapping(value = "/v1/saveVisit")
	ResponseEntity<Response> saveAndUpdateVisit(@RequestBody List<VisitsDTO> visitDTO) {
		List<VisitsDTO> visitDto;
		try {
			visitDto = convertEntityToDto.convertVisitEntityListToDTOList(visitService.saveAndUpdateVisit(visitDTO));
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("Visit Saved Successfully");
			successResponse.setPayload(visitDto);
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
	
	@DeleteMapping(value = "/v1/deleteVisit/{studyId}/{visitUuid}")
	public ResponseEntity<Response> deleteVisit(@PathVariable("studyId") int studyId,@PathVariable("visitUuid") String visitUuid){
		try {
			visitService.deleteVisit(studyId,visitUuid);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("Visit Deleted Successfully");
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

}
