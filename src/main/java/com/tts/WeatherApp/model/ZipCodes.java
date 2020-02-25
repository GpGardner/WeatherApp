package com.tts.WeatherApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ZipCodes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long search_id;
	private String zipCodes;

}
