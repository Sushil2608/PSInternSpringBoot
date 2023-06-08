package com.springBoot.PS_Intern.api.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springBoot.PS_Intern.api.model.Candidate;
import com.springBoot.PS_Intern.service.CandidateService;


@RestController
@RequestMapping("/api")
public class CandidateController {
	
	Logger logger=LoggerFactory.getLogger(CandidateController.class);
	private CandidateService candidateService;
	
	@Autowired
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	
	//POST REQUEST
	@PostMapping(value = "/candidate")
	public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate) {
		logger.info("Request received to save Candidate with id={} onto Database",candidate.getId());		
		return new ResponseEntity<Candidate>(candidateService.saveCandidate(candidate), HttpStatus.CREATED);
	}
	
	//GET REQUEST
	@GetMapping("/candidate/{id}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") long candidateId) {
		logger.info("Request received to get Candidate with id={} onto Database",candidateId);
		return new ResponseEntity<Candidate>(candidateService.getCandidateById(candidateId), HttpStatus.OK);
	}
	
	//UPDATE REQUEST
	@PutMapping("/candidate/{id}")
	public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") long candidateId, @RequestBody Candidate candidate) {
		logger.info("Request received to update Candidate with id={} onto Database",candidate.getId());
		return new ResponseEntity<Candidate>(candidateService.updateCandidate(candidate, candidateId), HttpStatus.OK);
	}
	
	//DELETE REQUEST
	@DeleteMapping("/candidate/{id}")
	public ResponseEntity<String> deleteCandidate(@PathVariable("id") long candidateId) {
		candidateService.deleteCandidate(candidateId);
		logger.info("Request received to delete Candidate with id={} onto Database",candidateId);
		return new ResponseEntity<String>("Candidate Deleted Successfully", HttpStatus.OK);
	}
}
