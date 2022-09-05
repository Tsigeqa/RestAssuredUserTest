package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import api.payload.User;

public class NewClass {
	
	Faker faker;
	
	public Logger logger;
	
	@BeforeClass
	public void setUpData() {
		faker=new Faker();
	
		
		// logs
		
		logger =LogManager.getLogger(this.getClass());
		
	}

}
