package com.springBoot.PS_Intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.PS_Intern.api.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}
