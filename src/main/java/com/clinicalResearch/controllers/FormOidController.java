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
import com.clinicalResearch.dtos.FormOIDsDTO;
import com.clinicalResearch.dtos.Response;
import com.clinicalResearch.dtos.SuccessResponse;
import com.clinicalResearch.services.FormOIdsService;

@RestController
@Controller
public class FormOidController {
	@Autowired
	FormOIdsService fOidService;
	
	@GetMapping(value = "/v1/getFormOids/{studyId}")
	ResponseEntity<Response> getFormOids(@PathVariable("studyId") int studyId){
		try {
			List<FormOIDsDTO> formOidsResponse = fOidService.getFormOids(studyId);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("FormOids List Fetched Successfully");
			successResponse.setPayload(formOidsResponse);
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
	
	@PostMapping(value = "/v1/saveFormOids")
	ResponseEntity<Response> saveFormOids(@RequestBody List<FormOIDsDTO> formOidDtoList){
		try {
			List<FormOIDsDTO> formOidsResponse = fOidService.saveFormOids(formOidDtoList);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("FormOids List Saved Successfully");
			successResponse.setPayload(formOidsResponse);
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
