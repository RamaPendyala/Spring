package com.sathya.rest;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins="*")
@RestController
public class CorsController {
@Autowired
CorsService corsService;
@GetMapping("/getnames")
 public List<String> getnames()
 {
	
	return corsService.getNames();
 }
}


 