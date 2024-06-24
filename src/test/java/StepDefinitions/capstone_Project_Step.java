package StepDefinitions;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import Pages.capstone_Project_Page;
import Utilities.hooks;
import Utilities.utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.TakesScreenshot;

public class capstone_Project_Step {
		//EdgeDriver driver;
		ChromeDriver driver = null;
		utils utils;
		capstone_Project_Page page;
		hooks hooks;
		String salutation,first_name,middle_name,last_name,dob,address,email_id,contact_code,contact_number,user_id,security_question,security_answer;
		String user_name, password_read, account_type, state, city, branch;
		String partnumberAPI;
		boolean resultviemoredetails; 
		
		final Logger logger = LoggerFactory.getLogger(capstone_Project_Step.class);
		RequestSpecification request;
		Response response;
		String responseString, requestspec;
		
		@Before()
		public void embedScreenshotStep(Scenario scenario) {
		hooks = new hooks();
		hooks.embedScreenshotStep(scenario);
		}
    
    	@AfterStep
    	public void i_take_a_screenshot() throws Throwable {
    	hooks.i_take_a_screenshot();
    	}
		
       /*-----------------------------------------------------------------*/
		
		@Given("User reads all the input data having {}")
		public void user_reads_all_cust_info(String CustomerNumber) throws InterruptedException, IOException {
			utils = new utils(driver);
			utils.user_information_input_file(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx",CustomerNumber);
			salutation = utils.read_salutation_value();
			first_name = utils.read_first_name_value();
			middle_name = utils.read_middle_name_value();
			last_name = utils.read_last_name_value();
			dob = utils.read_dob_value();
			address = utils.read_address_value();
			email_id = utils.read_email_id_value();
			contact_code = utils.read_contact_code_value();
			contact_number = utils.read_contact_number_value();
			user_id = utils.read_first_name_value();
			security_question = utils.read_security_question_value();
			security_answer = utils.read_security_answer_value();
			account_type = utils.read_account_type_value();
			state = utils.read_state_value();
			city = utils.read_city_value();
			branch = utils.read_branch_value();
		}
		
		@Then("User launches the In Essence banking application")
		public void user_launches_inessence_application() throws InterruptedException, IOException {
			driver = hooks.startBrowser_in_essence_chrome();
		}
			
		@And("User clicks on Login button to navigate to Login screen")
		public void user_navigates_login_screen() throws InterruptedException, IOException {
			page=new capstone_Project_Page(driver);
			page.navigate_login_page();
		}
		
		@And("User clicks on Sign Up button to navigate to Registration screen")
		public void user_sign_up_for_new_account() throws InterruptedException, IOException {
			page.navigate_sign_up_page();
		}
		
		@Then("User fills all the {} information i.e Salutation, First Name, Middle Name, Last Name, DOB, Address, Email Id, Contact Code and Contact Number")
		public void user_fills_customer_information(String CustomerNumber) throws InterruptedException, IOException {
			page.set_salutation(salutation);
			page.set_first_name(first_name);
			page.set_middle_name(middle_name);
			page.set_last_name(last_name);
			page.set_dob(dob);
			page.set_address(address);
			page.set_email_id(email_id);
			page.set_contact_code(contact_code);
			page.set_contact_number(contact_number);
			page.set_user_id(user_id);
			page.check_user_id();
			page.set_security_question(security_question);
			page.set_security_answer(security_answer);	
			page.click_submit_button(CustomerNumber);
		}
		
		@And("User set and validates the User Id")
		public void user_validate_user_id() throws InterruptedException, IOException {
			page.navigate_sign_up_page();
		}
		
		@And("User sets the Login password")
		public void user_sets_login_password() throws InterruptedException, IOException {
			page.navigate_sign_up_page();
		}
		
		@And("User sets the transaction password")
		public void user_sets_transaction_password() throws InterruptedException, IOException {
			page.navigate_sign_up_page();
		}
		
		@And("User sets the security question")
		public void user_sets_security_question() throws InterruptedException, IOException {
			page.navigate_sign_up_page();
		}
		
		@And("User sets the security answer")
		public void user_sets_security_answer() throws InterruptedException, IOException {
			page.navigate_sign_up_page();
		}
		
		@Then("User logs in application with generated credentials")
		public void user_log_in() throws InterruptedException, IOException {
			page.navigate_log_in_page();
		}
		
		@Then("{} login into the In Essence application")
		public void user_opens_the_dpmm_application_delaercode(String CustomerId) throws InterruptedException, IOException {
			utils = new utils(driver);
			utils.user_information_input_file_read_login(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx",CustomerId);
			user_name = utils.read_user_name_value();
			password_read = utils.read_customer_password_value();
			account_type=utils.read_account_type_value();
			state=utils.read_state_value();
			city=utils.read_city_value();
			branch=utils.read_branch_value();

			page.navigate_log_in_page_already_gen_credentials(user_name,password_read);
		}
		
		@Then("request for new account access")
		public void user_slaunches_inessence_application() throws InterruptedException, IOException {
			page.new_account_access();
		}
		
		@And("User fills Account type information")
		public void user_sets_account_information() throws InterruptedException, IOException {
			page.set_account_type(account_type);
		}
		
		@And("User fills State information")
		public void user_sets_state_information() throws InterruptedException, IOException {
			page.set_state(state);
		}
		
		@And("User fills City information")
		public void user_sets_city_information() throws InterruptedException, IOException {
			page.set_city(city);
		}
		
		@And("User fills Branch information")
		public void user_sets_branch_information() throws InterruptedException, IOException {
			page.set_branch(branch);
		}
		
		@And("User uploads all required proofs")
		public void user_uploads_proofs() throws InterruptedException, IOException, AWTException {
			page.uploadproofs_File(System.getProperty("user.dir")+"/files/Test_Upload_Sample.zip");
		}
		
		@And("User clicks on Submit button to submit all the information")
		public void user_clicks_submit() throws InterruptedException, IOException, AWTException {
			page.user_clicks_submit_button();
		}
		
		
		@Then("User validates the Account Request status screen to check the account access request")
		public void user_validate_account_request_status() throws InterruptedException, IOException {
			page.validate_account_request_status();
		}
		
		@And("User selects the status {}")
		public void user_status_type(String type) throws InterruptedException, IOException {
			page.set_account_type(type);
		}
		
		@And("User validates that account request id is visible and is having status as pending")
		public void user_validates_request_id () throws InterruptedException, IOException {
			//page.set_account_type();
		}
		
		
		
		/*-------------------------------------API--------------------------------------------*/

		  @Given("For getting the pet details user provides the authentication details for {} {}")
		  public void UsersetsAuthorizationDetails(String userid,String password) {  	
		  utils = new utils();
		  RestAssured.proxy("150.45.87.133", 8080);
		  request = RestAssured.given().auth().basic(userid, password); 
		  Response res = request.get("https://postman-echo.com/basic-auth");
		  ResponseBody body = res.body();
		  String rbdy = body.asString();
		  System.out.println("Data from the GET API- "+rbdy.substring(20,25));
		  Assert.assertEquals("true", rbdy.substring(21,25));    
		  }
		  
		  
		  @Given("For getting the user details user provides the authentication details for {} {}")
		  public void UserprovidesAuthorizationDetails(String userid,String password) {  	
		  utils = new utils();
		  RestAssured.proxy("150.45.87.133", 8080);
		  request = RestAssured.given().auth().basic(userid, password); 
		  Response res = request.get("https://postman-echo.com/basic-auth");
		  ResponseBody body = res.body();
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
			JsonPath json = response.jsonPath();
			System.out.println(responseString);
			String status = json.getString("status");
			System.out.println("The actual status from response is: " + status);
		   }
		  	  
		  @Given("I Set POST api endpoint for creating a new record {} {} {} {} {} {} {} {} {}")
		  public void setPostEndpointforcreatingusername(String authusername, String authpawd, String id, String username, String firstname, String lastname, String email, String Password, String phone) {
			 utils = new utils();	 
			 RestAssured.proxy("150.45.87.133", 8080);
			 request = RestAssured.given().auth().basic(authusername, authpawd); 
			 requestspec=payload.addnewdata(id,username,firstname,lastname,email,Password,phone);
			 Response res = request.get("https://postman-echo.com/basic-auth");
			 ResponseBody body = res.body();
			 String rbdy = body.asString();
			 System.out.println("Data from the GET API- "+rbdy.substring(20,25));
			 Assert.assertEquals("true", rbdy.substring(21,25));
			}
		  
		  @Given("I Set POST api endpoint for creating a new record {} {}")
		  public void setPostEndpointforcreatingusernameviaexcel(String authusername, String authpawd) {
			 utils = new utils();	 
			 RestAssured.proxy("150.45.87.133", 8080);
			 request = RestAssured.given().auth().basic(authusername, authpawd); 
			 //requestspec=payload.addnewdata(id,username,firstname,lastname,email,Password,phone);
			 Response res = request.get("https://postman-echo.com/basic-auth");
			 ResponseBody body = res.body();
			 String rbdy = body.asString();
			 System.out.println("Data from the GET API- "+rbdy.substring(20,25));
			 Assert.assertEquals("true", rbdy.substring(21,25));
			}
		  
		  @Given("I Set POST api endpoint for updating a new record {} {} {} {} {} {} {} {} {}")
		  public void setPostEndpointforupdatinguser(String authusername, String authpawd, String id, String username, String firstname, String lastname, String email, String Password, String phone) {
			 utils = new utils();	 
			 RestAssured.proxy("150.45.87.133", 8080);
			 request = RestAssured.given().auth().basic(authusername, authpawd); 
			 requestspec=payload.updatenewdata(id,username,firstname,lastname,email,Password,phone);
			 Response res = request.get("https://postman-echo.com/basic-auth");
			 ResponseBody body = res.body();
			 String rbdy = body.asString();
			 System.out.println("Data from the GET API- "+rbdy.substring(20,25));
			 Assert.assertEquals("true", rbdy.substring(21,25));
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
		  
		  
		  @Given("User read the database value") public void
		  User_update_the_database() throws InterruptedException,
		  ClassNotFoundException, SQLException { 
		   hooks.databaseconnectiontest(); 
		   }
		
		/*------------------------------------------------------------------------------------*/
		
//		@After
//	    public void afterScenario(){
//			if (this.driver==null)
//			{
//				
//			}
//			else {
//			driver.close();
//	        driver.quit();
//			}
//	  }	
}