package api.endpoints;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


////it contains CURD operations Create,Read,Update,Delete

public class UserEndPoints {
	
	public static  Response createUsers(User payload) {
		
		Response response =given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		
		.when()
		  .post(Routes.post_url);
		
		return response;
		
	}
public static  Response readUsers(String userName) {
		
		Response response =given()
		   .pathParam("username", userName)
		  
		
		.when()
		  .get(Routes.get_url);
		
		return response;
		
	}
public static  Response updateUsers(String userName ,User payload) {
	
	Response response =given()
	   .contentType(ContentType.JSON)
	   .accept(ContentType.JSON)
	   .pathParam("username", payload)
	   .body(payload)
	
	.when()
	  .put(Routes.update_url);
	
	return response;
	
}
public static  Response deleteUsers(String userName) {
	
	Response response =given()
	   .pathParam("username", userName)
	  
	
	.when()
	  .delete(Routes.delete_url);
	
	return response;
	
}

}
