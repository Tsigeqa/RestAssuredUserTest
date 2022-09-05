package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID,String userName,String fName,
			String lName,String userEmail,String password,String phone) {
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		Response response =UserEndPoints.createUsers(userPayload);
		response.then().log().all();
		assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority =2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName) {
		
     Response response = UserEndPoints.deleteUsers(userName);
		
		assertEquals(response.statusCode(), 204);
	}

}
