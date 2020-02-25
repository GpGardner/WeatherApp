package com.tts.WeatherApp.repository;



import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.tts.WeatherApp.model.ZipCodes;


public interface ZipCodeRepository extends CrudRepository<ZipCodes,Long> {

	void save(String zipCode);

	
//	List<ZipCodes>findAll(String ZipCodes);
	

}
