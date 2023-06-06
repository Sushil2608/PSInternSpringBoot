package com.springBoot.PS_Intern.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.PS_Intern.api.model.Candidate;
import com.springBoot.PS_Intern.exception.ResourceNotFoundException;
import com.springBoot.PS_Intern.repository.CandidateRepository;
import com.springBoot.PS_Intern.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	
	private CandidateRepository candidateRepository;
	
	@Autowired
	public CandidateServiceImpl(CandidateRepository candidateRepository) {
		super();
		this.candidateRepository = candidateRepository;
	}

	@Override
	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public Candidate getCandidateById(long id) {
		Optional<Candidate> candidate = candidateRepository.findById(id);
		if(candidate.isPresent())
			return candidate.get();
		throw new ResourceNotFoundException("Candidate", "Id", id);
		//can be written in one line like update
	}

	@Override
	public Candidate updateCandidate(Candidate candidate, long id) {
		//check whether employee with given id exists
		Candidate existingCandidate = candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Candidate", "Id", id));
		
		existingCandidate.setFirstName(candidate.getFirstName());
		existingCandidate.setLastName(candidate.getLastName());
		existingCandidate.setSkillset(candidate.getSkillset());
		existingCandidate.setCollegeName(candidate.getCollegeName());
		existingCandidate.setOrganisation(candidate.getOrganisation());
		existingCandidate.setDuration(candidate.getDuration());
		
		candidateRepository.save(existingCandidate);
		return existingCandidate;
	}

	@Override
	public void deleteCandidate(long id) {
		candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Candidate", "Id", id));
		candidateRepository.deleteById(id);
	}
	
}
