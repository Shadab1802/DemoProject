package pojo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ShopperLogin extends BaseClass{
	@Test
	public void loginTest() {

		ShopperPojo data = new ShopperPojo("bredmi250@gmail.com", "Shadab@123", "SHOPPER");

		Response res = 
				given()
				.contentType("application/json")
				.relaxedHTTPSValidation()
				.body(data)
				.when()
				.post("https://www.shoppersstack.com/shopping/users/login");

		res.then().log().all();

	}
}
