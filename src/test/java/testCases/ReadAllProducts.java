package testCases;

//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ReadAllProducts {

	@Test
	public static void read_All_Products() {
		
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("ContentType","application/json; charset=UTF-8")
				.when()
					.get("/read.php")
				.then() //.assertThat().statusCode(200);
					.extract().response();
		
		
		int statusCode = response.statusCode();
		System.out.println("Response: " + response.asPrettyString());
		System.out.println("status code: " + statusCode);
		
	}
	
}
