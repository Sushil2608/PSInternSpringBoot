package com.springBoot.PS_Intern.service;

import com.springBoot.PS_Intern.api.model.Candidate;

public interface CandidateService {
	Candidate saveCandidate(Candidate candidate);
	Candidate getCandidateById(long id);
	Candidate updateCandidate(Candidate candidate, long id);
	void deleteCandidate(long id);
}
