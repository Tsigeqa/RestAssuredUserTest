package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	// method to get resource form properties file
	public static ResourceBundle getURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // load properties files
		
		return routes;
	}
	
	
	
public static  Response createUsers(User payload) {
		
	String post_url =getURL().getString("post_url");
		Response response =given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		
		.when()
		  .post(post_url);
		
		return response;
		
	}
public static  Response readUsers(String userName) {
		
	String get_url =getURL().getString("get_url");
		Response response =given()
		   .pathParam("username", userName)
		  
		
		.when()
		  .get(get_url);
		
		return response;
		
	}
public static  Response updateUsers(String userName ,User payload) {
	String updat_url =getURL().getString("update_url");
	Response response =given()
	   .contentType(ContentType.JSON)
	   .accept(ContentType.JSON)
	   .pathParam("username", payload)
	   .body(payload)
	
	.when()
	  .put(updat_url);
	
	return response;
	
}
public static  Response deleteUsers(String userName) {
	String delete_url =getURL().getString("delete_url");
	Response response =given()
	   .pathParam("username", userName)
	  
	
	.when()
	  .delete(delete_url);
	
	return response;
	
}

}



