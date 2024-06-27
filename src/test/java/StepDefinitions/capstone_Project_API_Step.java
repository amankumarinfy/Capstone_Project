package StepDefinitions;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Pages.capstone_Project_UI_EXCEL_DB_Page;
import Utilities.hooks;
import Utilities.utils;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.path.json.JsonPath;

public class capstone_Project_API_Step {
		EdgeDriver driver;
		//ChromeDriver driver;
		utils utils;
		capstone_Project_UI_EXCEL_DB_Page page;
		hooks hooks;
		
		String partnumberAPI;
		boolean resultviemoredetails; 
		
		final Logger logger = LoggerFactory.getLogger(capstone_Project_API_Step.class);
		RequestSpecification request;
		Response response;
		String responseString, requestspec;
		String id_e,username_e,firstname_e,lastname_e,email_e,Password_e,phone_e,authusername_e, authpawd_e;
		
		@Before()
		public void embedScreenshotStep(Scenario scenario) {
		hooks = new hooks();
		hooks.embedScreenshotStep(scenario);
		}
    
    	@AfterStep
    	public void i_take_a_screenshot() throws Throwable {
    	hooks.i_take_a_screenshot();
    	}
			
		
    	/*-------------------------------------API--------------------------------------------*/

		
    	@Before 
    	public void beforescenario()
    	{
    		String projectPath = System.getProperty("user.dir");
    		System.setProperty("webdriver.edge.driver", projectPath + "/src/test/resources/Drivers/msedgedriver_126.exe");
    		//driver = new EdgeDriver();
    		//driver.close();
    	    //driver.quit();
    		// driver = new ChromeDriver(chromeOptions);
    	}
    	
    	@Given("For getting the pet details user provides the authentication details for {} {}")
		public void UsersetsAuthorizationDetails(String userid,String password) {  	
		utils = new utils();
		//RestAssured.proxy("150.45.87.133", 8080);
		request = RestAssured.given().auth().basic(userid, password); 
		Response res = request.get("https://postman-echo.com/basic-auth");
		ResponseBody<?> body = res.body();
		String rbdy = body.asString();
		System.out.println("Data from the GET API- "+rbdy.substring(20,25));
		Assert.assertEquals("true", rbdy.substring(21,25));    
		}
		  
		  
		  @Given("For getting the user details user provides the authentication details for {} {}")
		  public void UserprovidesAuthorizationDetails(String userid,String password) {  	
		  utils = new utils();
		  //RestAssured.proxy("150.45.87.133", 8080);
		  request = RestAssured.given().auth().basic(userid, password); 
		  Response res = request.get("https://postman-echo.com/basic-auth");
		  ResponseBody<?> body = res.body();
		  String rbdy = body.asString();
		  System.out.println("Data from the GET API- "+rbdy.substring(20,25));
		  Assert.assertEquals("true", rbdy.substring(21,25));    
		  }
 	  
		  @When("Send a GET HTTP request for particular {}")
		  public void sendGETRequestforParticularpetid(String petid) {
			response = request.when().log().all().get("https://petstore.swagger.io/v2/pet/"+petid+"");
			String responseString = response.getBody().asPrettyString();
			System.out.println(responseString);
		  }
		  
		  @When("Send a GET HTTP request for getting particular {}")
		  public void sendGETRequestforParticulauser(String username) {
			response = request.when().log().all().get("https://petstore.swagger.io/v2/user/"+username+"");
			responseString = response.getBody().asPrettyString();
		  }
		  
		  @When("as per excel input I Send a GET HTTP request for getting provided username")
		  public void sendGETRequestforParticulauser_excel() {
			response = request.when().log().all().get("https://petstore.swagger.io/v2/user/"+username_e+"");
			responseString = response.getBody().asPrettyString();
		  }
		  
		  @When("Send a DELETE HTTP request for deleting particular {}")
		  public void sendDELETERequestforParticulauser(String username) {
			response = request.when().log().all().delete("https://petstore.swagger.io/v2/user/"+username+"");
			responseString = response.getBody().asPrettyString();
		  }

		  @Then("I receive valid GET Response with HTTP response code as 200")
		  public void verifyGETResponse() {
			int statusCode = response.then().extract().statusCode();
			Assert.assertEquals(statusCode, 200);
			String statusLine = response.then().extract().statusLine();
			System.out.println("statusLine is " + statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			//JsonPath json = response.jsonPath();
			System.out.println(responseString);
			System.out.println("The actual status from response is: " + statusLine);
		   }
		  	  
		  @Given("I Set POST api endpoint for creating a new record {} {} {} {} {} {} {} {} {}")
		  public void setPostEndpointforcreatingusername(String authusername, String authpawd, String id, String username, String firstname, String lastname, String email, String Password, String phone) {
			 utils = new utils();	 
			 //RestAssured.proxy("150.45.87.133", 8080);
			 request = RestAssured.given().auth().basic(authusername, authpawd); 
			 requestspec=payload.addnewdata(id,username,firstname,lastname,email,Password,phone);
			 Response res = request.get("https://postman-echo.com/basic-auth");
			 ResponseBody<?> body = res.body();
			 String rbdy = body.asString();
			 System.out.println("Data from the GET API- "+rbdy.substring(20,25));
			 Assert.assertEquals("true", rbdy.substring(21,25));
			}
		  
		  
		  @Given("After reading from excel I Set POST api endpoint for creating a new record")
		  public void setPostEndpointforcreatingusername_excel() {
			 utils = new utils();	 
			 //RestAssured.proxy("150.45.87.133", 8080);
			 request = RestAssured.given().auth().basic(authusername_e, authpawd_e); 
			 requestspec=payload.addnewdata(id_e,username_e,firstname_e,lastname_e,email_e,Password_e,phone_e);
			 Response res = request.get("https://postman-echo.com/basic-auth");
			 ResponseBody<?> body = res.body();
			 String rbdy = body.asString();
			 System.out.println("Data from the GET API- "+rbdy.substring(20,25));
			 Assert.assertEquals("true", rbdy.substring(21,25));
			}
		  
//		  @Given("I Set POST api endpoint for creating a new record {} {}")
//		  public void setPostEndpointforcreatingusernameviaexcel(String authusername, String authpawd) {
//			 utils = new utils();	 
//			 //RestAssured.proxy("150.45.87.133", 8080);
//			 request = RestAssured.given().auth().basic(authusername, authpawd); 
//			 //requestspec=payload.addnewdata(id,username,firstname,lastname,email,Password,phone);
//			 Response res = request.get("https://postman-echo.com/basic-auth");
//			 ResponseBody body = res.body();
//			 String rbdy = body.asString();
//			 System.out.println("Data from the GET API- "+rbdy.substring(20,25));
//			 Assert.assertEquals("true", rbdy.substring(21,25));
//			}
		  
		  @Given("I Set POST api endpoint for updating a new record {} {} {} {} {} {} {} {} {}")
		  public void setPostEndpointforupdatinguser(String authusername, String authpawd, String id, String username, String firstname, String lastname, String email, String Password, String phone) {
			 utils = new utils();	 
			 //RestAssured.proxy("150.45.87.133", 8080);
			 request = RestAssured.given().auth().basic(authusername, authpawd); 
			 requestspec=payload.updatenewdata(id,username,firstname,lastname,email,Password,phone);
			 Response res = request.get("https://postman-echo.com/basic-auth");
			 ResponseBody<?> body = res.body();
			 String rbdy = body.asString();
			 System.out.println("Data from the GET API- "+rbdy.substring(20,25));
			 Assert.assertEquals("true", rbdy.substring(21,25));
			}
		  
		  
		  
		  @Given("User reads data from excel having {}")
			public void user_reads_all_cust_info(String CustomerNumber) throws InterruptedException, IOException {
				utils = new utils(driver);
				utils.user_information_input_file_read_login_API(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx",CustomerNumber);
				authusername_e="postman";
				authpawd_e="password";
				id_e=utils.read_customer_id_value_();
				firstname_e = utils.read_first_name_value();
				lastname_e = utils.read_last_name_value();
				email_e = utils.read_email_id_value();
				phone_e = utils.read_contact_number_value();
				username_e = utils.read_user_name_value();
				Password_e = utils.read_customer_password_value();
			}
			

		  @When("Send a POST HTTP request for creating a new record")
		  public void sendPostRequest() {
			  RestAssured.baseURI = "https://petstore.swagger.io/v2/";
			  RequestSpecification httpRequest = RestAssured.given();
		      httpRequest.header("Content-Type","application/json");
		      response = httpRequest.body(requestspec).post("user/createWithList");
		      System.out.println(response);
		      int statusCode = response.getStatusCode();
		      System.out.println("Response status code is "+statusCode);
		  }
		  
		  @When("Send a PUT HTTP request for updating a record for {}")
		  public void sendPUTRequest(String username) {
			  RestAssured.baseURI = "https://petstore.swagger.io/v2/";
			  RequestSpecification httpRequest = RestAssured.given();
		      httpRequest.header("Content-Type","application/json");
		      response = httpRequest.body(requestspec).put("user/"+username+"");
		      System.out.println(response);
		      int statusCode = response.getStatusCode();
		      System.out.println("Response status code is "+statusCode);
		  }
		    
		  @Then("I receive valid POST Response with HTTP response code as 200")
		  public void verifyPOSTResponse() {
			int statusCode = response.then().extract().statusCode();
			Assert.assertEquals(statusCode, 200);
			String statusLine = response.then().extract().statusLine();
			System.out.println("statusLine is " + statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			JsonPath json = response.jsonPath();
			String status = json.getString("status");
			System.out.println("The actual status from response is: " + status);
		   }
		/*------------------------------------------------------------------------------------*/
}