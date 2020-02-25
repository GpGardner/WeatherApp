package com.tts.WeatherApp.service;




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
	
	private ZipCodeRepository zipCodeRepository;
	
	public void save(String zipCode) {

		zipCodeRepository.save(zipCode);
		
	}


	
	//Method to make HTTP request to that specific URL and see the info in Request
    
    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        zipCode.save(zipCode);
//        zipCodeRepository.save(zipCode);
        
        try {
            return restTemplate.getForObject(url, Response.class);
            
        }
        catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }
    
    }
    
    
		//	public List<ZipCodes> getZip() {
		//	
		//	return (List<ZipCodes>) zipCodeRepository.findAll();
		//}
		
		//public void save(ZipCodes zipCodes) {
		//    zipCodeRepository.save(zipCodes);
		//}
    
}







