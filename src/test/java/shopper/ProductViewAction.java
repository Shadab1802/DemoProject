package shopper;

import org.testng.annotations.BeforeClass;
import base.BaseClass;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

public class ProductViewAction extends BaseClass{
	
//	private int productId;
	protected List<Integer> products;
	@BeforeClass
	public void fetchAllProducts() {
		
		Response res = given()
		.auth().oauth2(jwtToken)
		.relaxedHTTPSValidation()
		.contentType("application/json")
		
		.baseUri(baseURL)
		.when()
		.get("/products/alpha");
		
		res.then().assertThat().statusCode(200);
//		productId = res.jsonPath().getInt("data[0].productId");
//		System.out.println(productId);
//		System.out.println(res.prettyPrint());
		
		products = res.jsonPath().getList("data.productId");
		
//		System.out.println(products.get(1));
	}
}
