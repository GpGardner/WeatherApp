package com.tts.WeatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.model.ZipCodes;
import com.tts.WeatherApp.service.WeatherService;

@Controller
public class WeatherController {
    
	@Autowired
    private WeatherService weatherService;
	
//	@GetMapping(value="/")
//	public String getIndex(Model model) {
//	    Response response = weatherService.getForecast("43210");
//	    model.addAttribute("data", response);
//	    return "index";
//	}
	
	@GetMapping(value="/")
	public String getIndex(Model model) {
		Iterable<ZipCodes> zipCodeList = weatherService.findAllZipCode();
		model.addAttribute("zipCodesHistory", zipCodeList);
		model.addAttribute("request", new Request());
		
		return "index";
	}
	
	@PostMapping(value="/")
	public String postIndex(Request request, Model model) {
		Response data = weatherService.getForecast(request.getZipCode());
		model.addAttribute("data", data);
		Iterable<ZipCodes> zipCodeList = weatherService.findAllZipCode();
		model.addAttribute("zipCodePost", zipCodeList);
		return "index";
	}
	
}