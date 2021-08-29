package com.responseDto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {

	private Coord coord;	
	private List<Weather> weather = null;	
	private String base;	
	private Main main;
	private Integer visibility;
	private Wind wind;
	private Clouds clouds;
	private Integer dt;
	private Sys sys;
	private Integer timezone;
	private Integer id;	
	private String name;
	private Integer cod;



}
