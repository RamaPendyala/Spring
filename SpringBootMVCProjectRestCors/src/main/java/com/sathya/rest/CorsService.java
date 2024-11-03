package com.sathya.rest;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CorsService {
@Cacheable("names")
public List<String> getNames() {
	System.out.println("fecth the names");
	return List.of("Chikke","Lakshmi","hema");
	
}
}
