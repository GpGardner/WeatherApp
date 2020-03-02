package com.tts.WeatherApp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.tts.WeatherApp.model.ZipCodes;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCodes,Long> {
	
}
