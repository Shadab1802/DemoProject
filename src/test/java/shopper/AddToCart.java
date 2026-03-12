package shopper;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class AddToCart extends ProductViewAction{
	@Test()
	public void addToCart() {
		HashMap<String, String> map = new HashMap<>();
		map.put("productId", products.get(4).toString());
		map.put("quantity", "4");
		
		Response res = given()
		.contentType("application/json")
		.relaxedHTTPSValidation()
		.auth().oauth2(jwtToken)
		.pathParams("shopperId",shopperId)
		.baseUri(baseURL)
		.body(map)
		.when()
		.post("/shoppers/{shopperId}/carts");

		res.then().assertThat().statusCode(201);
		System.out.println("added to cart ");
	}
	
}
