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
import com.clinicalResearch.dtos.ItemOIDsDTO;
import com.clinicalResearch.dtos.Response;
import com.clinicalResearch.dtos.SuccessResponse;
import com.clinicalResearch.services.ItemOidsService;

@RestController
@Controller
public class ItemOIDsController {
	
	@Autowired
	ItemOidsService itemOidService;
	
	@GetMapping(value = "/v1/getItemOids/{studyId}/{formOid}")
	ResponseEntity<Response> getItemOids(@PathVariable("studyId") int studyId ,
			@PathVariable("formOid") String formOid) {
		List<ItemOIDsDTO> itemOidsList;
		try {
			itemOidsList = itemOidService.getItemOids(studyId, formOid);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("ItemOids List Fetched Successfully");
			successResponse.setPayload(itemOidsList);
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
	
	@PostMapping(value = "/v1/saveItemOids")
	ResponseEntity<Response> saveItemOids(@RequestBody List<ItemOIDsDTO> itemOidsList){
		try {
			List<ItemOIDsDTO> itemOidsResponse = itemOidService.saveItemOid(itemOidsList);
			SuccessResponse successResponse = new SuccessResponse();
			successResponse.setCode(200);
			successResponse.setMessage("ItemOids List Saved Successfully");
			successResponse.setPayload(itemOidsResponse);
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
