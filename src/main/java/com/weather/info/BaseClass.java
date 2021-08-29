package com.weather.info;

import org.testng.annotations.BeforeSuite;

import utils.BaseUrl;

public class BaseClass {

	@BeforeSuite
	public void setUp() {
		
		BaseUrl.initializeProperties();
	}
 }
