package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.log.Log;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CreateAProduct {

	@Test
	public static void create_A_Product() {
		
		String payloadPath = ".\\src\\main\\java\\data\\payload.json";
		
//		HashMap<String, String> payload = new HashMap<String, String>();
//		payload.put("name","DatBai2.0");
//		payload.put("price","301");
//		payload.put("description","DatBai2.0 is amaaaaaazing!");
//		payload.put("category_id", "2");
		
		Response response = 
				given()
//					.log().all()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("ContentType","application/json;")
					.body(new File (payloadPath))
				.when()
					.post("/create.php")
				.then() //.assertThat().statusCode(200);
				.log().headers()
					.extract().response();
		
//		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		long expectedResponseTime = 2000;
//		System.out.println("Response time: " + responseTime);
//		if(responseTime <= expectedResponseTime){
//			System.out.println("Response time is within range.");
//		}else{
//			System.out.println("Response time is out of range.");
//		}
//		
//		int statusCode = response.statusCode();
//		System.out.println("status code: " + statusCode);
//		Assert.assertEquals(statusCode, 201);
//		
//		String responseBody = response.getBody().asString();
//		System.out.println("Response: " + responseBody);
//		JsonPath jp = new JsonPath(responseBody);
//		String successMessage = jp.getString("message");
//		System.out.println("Message: " + successMessage);
//		Assert.assertEquals(successMessage, "Product was created.");
		
	}

}
