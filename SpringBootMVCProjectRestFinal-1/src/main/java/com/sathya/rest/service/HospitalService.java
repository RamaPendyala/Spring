package com.sathya.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sathya.rest.models.Hospital;

import com.sathya.rest.repository.HospitalRepository;

@Service
public class HospitalService {
@Autowired
HospitalRepository hospitalRepository;

public Hospital saveHospital(Hospital hospital) {
	Hospital saveHos = hospitalRepository.save(hospital);
	return saveHos;
}

public List<Hospital> saveAllHospitals(List<Hospital> hospitals) {
	List <Hospital> hosps = hospitalRepository.saveAll(hospitals);
	return hosps ;
}

public List<Hospital> getAllHospitals() {
	List<Hospital> hosps = hospitalRepository.findAll();
	return hosps;
}

public Optional<Hospital> getById(Long id) {
Optional<Hospital> hosps = hospitalRepository.findById(id);
	return hosps;
}



}
