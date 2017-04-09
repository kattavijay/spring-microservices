package com.examples.common.util;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.builder.RequestSpecBuilder;

public class ServiceCalls {
	
	
	public Response goGet(String url)
	{
		System.out.println("inside doget");
		Response resp =null;
		try
		{
		resp = given().when().get(url);
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return resp;
		
	}
	
	public Response goPost(String url,String input)
	{
		
		Response resp=null;
		
		try
		{
			RequestSpecBuilder builder = new RequestSpecBuilder();
			builder.setBody(input);
			builder.setContentType("application/json; charset=UTF-8");
			
			RequestSpecification requestSpec = builder.build();
			
			resp = given().spec(requestSpec).when().post(url);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return resp;
	}
	

}
