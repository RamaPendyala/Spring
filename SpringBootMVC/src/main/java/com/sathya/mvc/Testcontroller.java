package com.sathya.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Testcontroller {
@GetMapping("/test")
public String getInfo()
{
	return "greet";
}

}


