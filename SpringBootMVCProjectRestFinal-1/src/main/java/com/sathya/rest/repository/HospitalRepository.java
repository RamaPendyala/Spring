package com.sathya.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.rest.models.Hospital;

@Repository
public interface HospitalRepository  extends JpaRepository<Hospital, Long>{

}
