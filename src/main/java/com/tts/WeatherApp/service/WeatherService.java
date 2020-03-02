package com.tts.WeatherApp.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.model.ZipCodes;
import com.tts.WeatherApp.repository.ZipCodeRepository;


@Service
public class WeatherService {
    
	
	
	
	@Value("${api_key}")
    private String apiKey;
	
	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	
	//Method to make HTTP request to that specific URL and see the info in Request
    
    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        
        
        ZipCodes zipCodeHistory = new ZipCodes();
        zipCodeHistory.setZipCodes(zipCode);
        zipCodeRepository.save(zipCodeHistory);
        
        
        try {
        	
            return restTemplate.getForObject(url, Response.class);
            
        }
        catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }
        
    }
    
    public Iterable<ZipCodes> findAllZipCode() {
		return zipCodeRepository.findAll();
	}
    
}







