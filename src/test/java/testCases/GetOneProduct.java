package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetOneProduct {

	@Test
	public static void get_A_Product() {
		
		//https://techfios.com/api-prod/api/product/read.php
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("ContentType","application/json; charset=UTF-8")
					.queryParam("id", "2740")
				.when()
					.get("/read_one.php")
				.then() //.assertThat().statusCode(200);
					.extract().response();
		
		
		int statusCode = response.statusCode();
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		long expectedResponseTime = 2000;
		String responseBody = response.getBody().asPrettyString();
		JsonPath jp = new JsonPath(responseBody);
		
		System.out.println("status code: " + statusCode);
		System.out.println("Response time: " + responseTime);
		if(responseTime <= expectedResponseTime){
			System.out.println("Response time is within range.");
		}else{
			System.out.println("Response time is out of range.");
		}
		
		System.out.println("Response: " + responseBody);
		
		String productName = jp.getString("name");
		System.out.println("Product name: " + productName);
		Assert.assertEquals(productName, "SID's Amazing Pillow 3.0");
		
		String productDesc = jp.getString("description");
		System.out.println("Product description: " + productDesc);
		Assert.assertEquals(productDesc, "The best pillow for amazing programmers.");
		
		String productPrice = jp.getString("price");
		System.out.println("Product price: " + productPrice);
		Assert.assertEquals(productPrice, "299");
	}
	
}
