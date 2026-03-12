package shopper;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class ShopperLoginTest {
	String shopperId;
	String jwtToken;
	
	@Test(enabled = false)
	public void loginTest() {
		

		given()
		.contentType("application/json")
		.relaxedHTTPSValidation()
		.body("{\r\n"
				+ "  \"email\": \"bredmi250@gmail.com\",\r\n"
				+ "  \"password\": \"Shadab@123\",\r\n"
				+ "  \"role\": \"SHOPPER\"\r\n"
				+ "}")
		
		.when()
		.post("https://www.shoppersstack.com/shopping/users/login")
		
		
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	
	
	
//	@Test(dependsOnMethods = "loginTest",invocationCount = 5,enabled = false)
	@Test(dependsOnMethods = "loginTest2")
	public void fetchData() {
		
		Response res = given()
		.contentType("application/json")
		.auth().oauth2(jwtToken)
		.pathParam("shopperId",shopperId)
		.baseUri("https://www.shoppersstack.com/shopping")
		.relaxedHTTPSValidation()
		
		.when()
		.get("/shoppers/{shopperId}");
		
		System.out.println(res.prettyPrint());
	}
	
	@Test
	public void loginTest2() {
		HashMap<String,String> map =  new HashMap<String,String>();
		
		map.put("email", "bredmi250@gmail.com");
		map.put("password", "Shadab@123");
		map.put("role", "SHOPPER");
		
		Response res = given()
		.contentType("application/json")
		.relaxedHTTPSValidation()
		.body(map)
		
		.when()
		.post("https://www.shoppersstack.com/shopping/users/login");
		
		shopperId = res.jsonPath().getString("data.userId");
		jwtToken = res.jsonPath().getString("data.jwtToken");
		
		System.out.println(shopperId+ " "+jwtToken);
	}
	
	
	
}
