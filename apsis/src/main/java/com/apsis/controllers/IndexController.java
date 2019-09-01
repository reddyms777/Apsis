package com.apsis.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apsis.Exception.DuplicateException;
import com.apsis.Exception.NotFoundException;
import com.apsis.dto.ResponseDTO;
import com.apsis.models.Counter;
import com.apsis.services.CounterService;


@RestController
public class IndexController {
	
	@Autowired
	private CounterService counterService;
	
	
	/**
	 * To create the new counter
	 * @param request
	 * @param response
	 * @param counterName
	 * @return
	 */
	@PostMapping("/counter/create")
    public ResponseEntity<Object> createCounter(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("counterName") String counterName) {
		try {
			Counter counter = counterService.createCounter(counterName);
			return new ResponseEntity<>(
					new ResponseDTO("Sucess", null, counter)
					, HttpStatus.OK);
		} catch (DuplicateException ex) {
			return new ResponseEntity<>(
					new ResponseDTO(ex.getMessage(), ex.getCode(), null)
					, HttpStatus.OK);
		}
		
    }
	
	/**
	 * To increase the counter value
	 * @param request
	 * @param response
	 * @param counterName
	 * @return
	 */
	@PostMapping("/counter/increase")
    public ResponseEntity<Object> increaseCounter(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("counterName") String counterName) {
		try {
			Counter counter = counterService.increaseCounter(counterName);
			return new ResponseEntity<>(
					new ResponseDTO("Sucess", null, counter)
					, HttpStatus.OK);
		} catch (NotFoundException ex) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
    }
	
	
	/**
	 * To get the specified counter
	 * @param request
	 * @param response
	 * @param counterName
	 * @return
	 */
	@GetMapping("/counter/{counterName}")
    public ResponseEntity<Object> getCounter(HttpServletRequest request, HttpServletResponse response,
    		@PathVariable("counterName") String counterName) {
		Counter counter = counterService.getCounter(counterName);
		if(counter == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(
					new ResponseDTO("Sucess", null, counter)
					, HttpStatus.OK);
		}
    }
	
	/**
	 * To get all counters
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/counter")
    public ResponseEntity<Object> getAllCounter(HttpServletRequest request, HttpServletResponse response) {
		counterService.getAllCounter();
		return new ResponseEntity<>(
				new ResponseDTO("Sucess", null, counterService.getAllCounter()), 
				HttpStatus.OK);
    }
}