package StepDefinitions;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Pages.capstone_Project_UI_EXCEL_DB_Page;
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
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class capstone_Project_UI_EXCEL_DB_Step {
		EdgeDriver driver;
		//ChromeDriver driver;
		utils utils;
		capstone_Project_UI_EXCEL_DB_Page page;
		hooks hooks;
		String customer_number, salutation,first_name,middle_name,last_name,dob,address,email_id,contact_code,contact_number,user_id,security_question,security_answer;
		String user_name, password_read, account_type, state, city, branch;
		String customer_id, user_registration;
		
		String[] salutation_a,first_name_a,middle_name_a,last_name_a,dob_a,address_a,email_id_a,contact_code_a,contact_number_a,user_id_a,security_question_a,security_answer_a,user_name_a,password_read_a;
		String[] account_type_a, state_a, city_a, branch_a, regisstatus_a;
		String[] customer_number_a, customer_id_a;
		
		String partnumberAPI;
		boolean resultviemoredetails; 
		
		final Logger logger = LoggerFactory.getLogger(capstone_Project_UI_EXCEL_DB_Step.class);
		RequestSpecification request;
		Response response;
		String responseString, requestspec;
		
		@Before()
		public void embedScreenshotStep(Scenario scenario) {
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.edge.driver", projectPath + "/src/test/resources/Drivers/msedgedriver_126.exe");	
			driver = new EdgeDriver();
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
		
			
		@Given("User reads all the customer input data from excel sheet")
		public void user_reads_all_cust_info_once() throws InterruptedException, IOException {
			utils = new utils(driver);
			utils.user_information_input_file_all_data(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx");
			customer_number_a = utils.read_custnumber_value_a(); 
			salutation_a = utils.read_salutation_value_a();
			first_name_a = utils.read_first_name_value_a();
			middle_name_a = utils.read_middle_name_value_a();
			last_name_a = utils.read_last_name_value_a();
			dob_a = utils.read_dob_value_a();
			address_a = utils.read_address_value_a();
			email_id_a = utils.read_email_id_value_a();
			contact_code_a = utils.read_contact_code_value_a();
			contact_number_a = utils.read_contact_number_value_a();
			user_id_a = utils.read_first_name_value_a();
			security_question_a = utils.read_security_question_value_a();
			security_answer_a = utils.read_security_answer_value_a();
			account_type_a = utils.read_account_type_value_a();
			state_a = utils.read_state_value_a();
			city_a = utils.read_city_value_a();
			branch_a = utils.read_branch_value_a();
			customer_id_a = utils.read_custid_value_a(); 
			regisstatus_a=utils.read_regisstatus_value_a();
		}
		
		@Then("User does the registration of each customer and stores the login details in the customer info sheet")
		public void user_resgister_all() throws InterruptedException, IOException {
			page.user_signs_up_all(salutation_a,first_name_a,middle_name_a,last_name_a,dob_a,address_a,email_id_a,contact_code_a,contact_number_a,user_id_a,security_question_a,security_answer_a,user_name_a,password_read_a,account_type_a, state_a, city_a, branch_a,regisstatus_a);	
		}
		
		@Then("User completes the registration and then saves all the information in excel sheeta and database")
		public void user_resgister_all_database() throws InterruptedException, IOException, NumberFormatException, ClassNotFoundException, SQLException {
			page.user_signs_up_all_saves_in_database(customer_number_a, salutation_a, first_name_a, middle_name_a, last_name_a, dob_a, address_a, email_id_a, contact_code_a, contact_number_a, user_id_a, security_question_a, security_answer_a, account_type_a, state_a, city_a, branch_a, customer_id_a, user_name_a, password_read_a, regisstatus_a);	
		}
		
		@Then("User validates the negative test case for existing users")
		public void user_validates_existing_test_case() throws InterruptedException, IOException, NumberFormatException, ClassNotFoundException, SQLException {
			page.user_validates_negative_testcase(customer_number_a, salutation_a, first_name_a, middle_name_a, last_name_a, dob_a, address_a, email_id_a, contact_code_a, contact_number_a, user_id_a, security_question_a, security_answer_a, account_type_a, state_a, city_a, branch_a, customer_id_a, user_name_a, password_read_a, regisstatus_a);	
		}
		
		@Then("User launches the In Essence banking application")
		public void user_launches_inessence_application() throws InterruptedException, IOException {
			//driver = hooks.startBrowser_in_essence_chrome();
		}
		
		@Then("User launches external google ui website")
		public void user_launches_google_ui() throws InterruptedException, IOException {
			//utils = new utils(driver);
			driver = hooks.startedgeBrowser_google_edge();
		}
		
		@When("User provides username and password")
		public void user_logs_into_parts_availability_screen() throws InterruptedException {
			page = new capstone_Project_UI_EXCEL_DB_Page(driver);
		}
			
		@And("User clicks on Login button to navigate to Login screen")
		public void user_navigates_login_screen() throws InterruptedException, IOException {
			page=new capstone_Project_UI_EXCEL_DB_Page(driver);
			page.navigate_login_page();
		}
		
		@And("User clicks on Sign Up button to navigate to Registration screen")
		public void user_sign_up_for_new_account() throws InterruptedException, IOException {
			page.navigate_sign_up_page();
		}
			
		@Then("User sets Salutation")
		public void user_set_salutation() throws InterruptedException, IOException {
			page.set_salutation(salutation);
		}
		
		@Then("User sets First Name")
		public void set_first_name() throws InterruptedException, IOException {
			page.set_first_name(first_name);
		}
		
		@Then("User sets Middle Name")
		public void set_middle_name() throws InterruptedException, IOException {
			page.set_middle_name(middle_name);
		}
		
		@Then("User sets Last Name")
		public void set_last_name() throws InterruptedException, IOException {
			page.set_last_name(last_name);
		}
		
		@Then("User sets DOB")
		public void set_dob() throws InterruptedException, IOException {
			page.set_dob(dob);
		}
		
		@Then("User sets Address")
		public void set_address() throws InterruptedException, IOException {
			page.set_address(address);
		}
		
		@Then("User sets Email Id")
		public void set_email_id() throws InterruptedException, IOException {
			page.set_email_id(email_id);
		}
		
		@Then("User sets Contact Code")
		public void set_contact_code() throws InterruptedException, IOException {
			page.set_contact_code(contact_code);
		}
		
		@Then("User sets Contact Number")
		public void set_contact_number() throws InterruptedException, IOException {
			page.set_contact_number(contact_number);
		}
		
		@Then("User sets UserId")
		public void set_user_id() throws InterruptedException, IOException {
			page.set_user_id(user_id);
		}
		
		@And("User validates available UserId and accoridingly sets Login and Transaction passwords")
		public void validate_user_id_set_login_transaction_password() throws InterruptedException, IOException {
			page.check_user_id();
		}
		
		@Then("User sets Security Question")
		public void set_security_question() throws InterruptedException, IOException {
			page.set_security_question(security_question);
		}
		
		@Then("User sets Security Answer")
		public void set_security_answer() throws InterruptedException, IOException {
			page.set_security_answer(security_answer);	
		}
		
		@Then("User clicks on Submit button to submit all details for {}")
		public void user_fills_customer_information(String CustomerNumber) throws InterruptedException, IOException {
			page.click_submit_button(CustomerNumber);
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
			page.set_exist_account_type(type);
		}
		
		@And("User selects request status as Pending")
		public void user_status_type_pending() throws InterruptedException, IOException {
			page.set_exist_account_type("Pending");
		}

		
		@And("User validates that request id is visible and is having status as {}")
		public void user_validates_request_id ( String reqstatus) throws InterruptedException, IOException {
			page.validate_request_status( reqstatus,account_type);
		}
		
		@And("User validates new request id is visible with all details")
		public void user_validates_request_id_status () throws InterruptedException, IOException {
			page.validate_request_status("Open",account_type);
		}
	  
		@Given("User read the database value") 
		public void User_update_the_database() throws InterruptedException, ClassNotFoundException, SQLException { 
		  	hooks.databaseconnectiontest(); 
		}
	  
		@Then("User create the database table with name {}") 
	  	public void User_create_database_table(String databasename) throws InterruptedException, ClassNotFoundException, SQLException { 
		  	hooks.database_create_table(databasename); 
		}
	  
		@Given("User reads all the input data to be saved in databse having {}")
		public void user_reads_all_cust_info_database(String CustomerNumber) throws InterruptedException, IOException {
			utils = new utils(driver);
			utils.user_information_input_file_database(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx",CustomerNumber);
			customer_number=utils.read_customer_id_value_();
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
			customer_id=utils.read_cust_id_value();	
			user_name = utils.read_user_name_value();
			password_read = utils.read_customer_password_value();
			user_registration = utils.read_user_regis_status();	
		}
	  
		@And("User inserts all the values into the database {}") 
		public void user_inserts_value_in_database_table(String databasename) throws InterruptedException, ClassNotFoundException, SQLException { 
			hooks.database_inserts_value_in_table(databasename, customer_number, salutation, first_name, middle_name, last_name, dob, address, email_id,contact_code, contact_number, user_id, security_question, security_answer, account_type, state, city, branch, customer_id, user_name, password_read, user_registration); 
		}
	  
		@Then("User reads value from database back and verifies that inserted data is matched with the provide input data into the database {}") 
		public void User_read_database_values(String databasename) throws InterruptedException, ClassNotFoundException, SQLException { 
		  	hooks.database_read_compare_values(databasename, customer_number, salutation, first_name, middle_name, last_name, dob, address, email_id,contact_code, contact_number, user_id, security_question, security_answer, account_type, state, city, branch, customer_id, user_name, password_read, user_registration); 
		}
		
		@Then("User reads all the customer input data from database") 
		public void User_customer_input_database_values() throws InterruptedException, ClassNotFoundException, SQLException, IOException { 
		  	hooks.database_readall_values();	
		  	customer_number_a = hooks.read_custnumber_value_a(); 
			salutation_a = hooks.read_salutation_value_a();
			first_name_a = hooks.read_first_name_value_a();
			middle_name_a = hooks.read_middle_name_value_a();
			last_name_a = hooks.read_last_name_value_a();
			dob_a = hooks.read_dob_value_a();
			address_a = hooks.read_address_value_a();
			email_id_a = hooks.read_email_id_value_a();
			contact_code_a = hooks.read_contact_code_value_a();
			contact_number_a = hooks.read_contact_number_value_a();
			user_id_a = hooks.read_first_name_value_a();
			security_question_a = hooks.read_security_question_value_a();
			security_answer_a = hooks.read_security_answer_value_a();
			account_type_a = hooks.read_account_type_value_a();
			state_a = hooks.read_state_value_a();
			city_a = hooks.read_city_value_a();
			branch_a = hooks.read_branch_value_a();
			customer_id_a = hooks.read_custid_value_a(); 
			user_name_a = hooks.read_user_name_value_a();
			password_read_a = hooks.read_customer_password_value_();
			regisstatus_a=hooks.read_regisstatus_value_a();
		}
	  	
		/*------------------------------------------------------------------------------------*/
		
		@After
	    public void afterScenario(){
			if (this.driver==null)
			{
				
			}
			else {
			driver.close();
	        driver.quit();
		}
	 }	
}