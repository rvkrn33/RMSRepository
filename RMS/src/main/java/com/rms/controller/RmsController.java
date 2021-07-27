package com.rms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.exceptions.BusinessException;
import com.rms.exceptions.DataNotFoundException;
import com.rms.model.Rate;
import com.rms.service.RmsService;

@RestController
@RequestMapping("/api")
public class RmsController {

	//TODO: Need to add logs
	@Autowired
	private RmsService rmsService;
	
	@GetMapping("/rate/{rateId}")
	public ResponseEntity<Rate> getRate(@PathVariable long rateId) throws DataNotFoundException {
		
		Optional<Rate> rate=rmsService.getRate(rateId);
		if(rate.isPresent()) {
			System.out.println(rate);
			return new ResponseEntity<Rate>(rate.get(),HttpStatus.OK);
		}
		else
			throw new DataNotFoundException("data Not found");
	
	}
	
	//Validation Needed
	@PostMapping("/rate")
	public ResponseEntity<String> saveRate(@RequestBody Rate rate) throws BusinessException{
		try {
			rmsService.saveRate(rate);
		}catch(Exception e) {
			throw new BusinessException("Internal Server Error. Please contact admin");
		}
			return new ResponseEntity<String>("Rate added",HttpStatus.CREATED);
	}
	
	@PutMapping("/rate")
	public ResponseEntity<String> updateRate(@RequestBody Rate rate) throws BusinessException{
		try {
			rmsService.updateRate(rate);
		}catch(Exception e) {
			throw new BusinessException("Internal Server Error. Please contact admin");
		}
			return new ResponseEntity<String>("Rate added",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/rate/{rateId}")
	public ResponseEntity<String> deleteRate(@PathVariable long rateId) throws DataNotFoundException{
		Optional<Rate> rate=rmsService.getRate(rateId);
		if(rate.isPresent()) {
			System.out.println(rate);
			rmsService.deleteRate(rateId);
			return new ResponseEntity<String>("Data Succussfully Deleted",HttpStatus.OK);
		}
		else
		{
			throw new DataNotFoundException("data Not found");
		}
	
	}
}

