package com.sathya.rest.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sathya.rest.models.Hospital;
import com.sathya.rest.service.HospitalService;
@RequestMapping("/api/v1")
@Controller
public class HospitalController {
@Autowired
HospitalService hospitalService;

@PostMapping("/saveHos")
public ResponseEntity <Hospital>saveHospital(@RequestBody Hospital hospital) {
	Hospital saveHos = hospitalService.saveHospital(hospital);
	return ResponseEntity.status(HttpStatus.CREATED)
			             .header("hospitalStatus", "Hospital saved Successfully")
			             .body(saveHos);
}


@PostMapping("/saveAll")
public ResponseEntity<List<Hospital>> saveAllEmployees(@RequestBody List<Hospital>hospitals){
	List<Hospital> hosps=
			hospitalService.saveAllHospitals(hospitals);
	return ResponseEntity.status(HttpStatus.CREATED)
			             .header("success", "AllemployeesSaved")
			             .body(hosps);
	
}

@GetMapping("getAll")
public ResponseEntity<List<Hospital>> getAllEmployees()
{
	List<Hospital> hosps = 
			hospitalService.getAllHospitals();
	return ResponseEntity.status(HttpStatus.OK)
			             .header("status","Data reading is Successfully")
			             .body(hosps);

}
@GetMapping("getbyid/{id}")
public ResponseEntity<?>getById(@PathVariable Long id)
{
	Optional<Hospital>optionalhosps = hospitalService.getById(id);
   if(optionalhosps.isPresent())
   {
	   return ResponseEntity.status(HttpStatus.OK)
			                .body(optionalhosps);
			   
   }
   else
   {
	   return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                  .body("hos is not found"+id);
   }
	
}
}
