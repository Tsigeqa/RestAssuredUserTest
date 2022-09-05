package api.test;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {
	
	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setUpData() {
		faker=new Faker();
		userPayload= new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		// logs
		
		logger =LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=1)
	public void testPostUser() {
		 logger.info("***********creating user**********");
		Response response =UserEndPoints2.createUsers(userPayload);
		response.then().log().all();
		assertEquals(response.statusCode(), 200);
		
		
	}
	@Test(priority=2)
	
	public void testGetByUserName() {
		
		Response response =UserEndPoints2.readUsers(this.userPayload.getUsername());
		
		response.then().log();
		assertEquals(response.getStatusCode(), 404);
	}
	@Test
	public void testUpdateUserByName() {
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response =UserEndPoints2.updateUsers(this.userPayload.getUsername(),userPayload);
		response.then().log().body().statusCode(200);
		//checking data after apdate
		
		Response responseAterUpdate =UserEndPoints2.readUsers(this.userPayload.getUsername());
	assertEquals(responseAterUpdate.statusCode(), 200);	
		
	}
	
	@Test 
	public void testDeleteUser() {
		
		Response response = UserEndPoints2.deleteUsers(this.userPayload.getUsername());
		
		assertEquals(response.statusCode(), 204);
	}

}
