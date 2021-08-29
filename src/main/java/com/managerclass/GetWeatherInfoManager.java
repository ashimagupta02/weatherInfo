package com.managerclass;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.responseDto.WeatherResponse;

import io.restassured.response.Response;
import utils.BaseUrl;
import utils.Endpoints;
import static io.restassured.RestAssured.*;

public class GetWeatherInfoManager {
	
	private Map<String, String> queryParams = new HashMap<String, String>();
	private Response response;
	WeatherResponse weatherRes;
	
	public WeatherResponse getResponsePojo() {
		return weatherRes;
	}
	
	public void setCityName(String cityName) {
		queryParams.put("q", cityName);

	}

	public void setAppId(String appid) {
		queryParams.put("appid", appid);

	}

	public void setUnit(String units) {
		queryParams.put("units", units);

	}

	public void execute() {

		String url = BaseUrl.url_2 + Endpoints.DATA;
		response = given().queryParams(queryParams).get(url);
		
		System.out.println("Weather Response :" + response.asString());
		Gson gson = new Gson();
		weatherRes = gson.fromJson(response.asString(), WeatherResponse.class);
	}
}
