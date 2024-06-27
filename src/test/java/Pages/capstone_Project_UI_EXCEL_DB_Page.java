package Pages;
import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.utils;
import Utilities.hooks;

public class capstone_Project_UI_EXCEL_DB_Page {

protected WebDriver driver;
utils utils = new utils();
hooks hooks;

String uniqueusername, userpwd, user, transactionpassword;
String gen_cust_id;
int uniquenumber,uniquieid;
int p;

/*---------------------------XPaths---------------------------*/
	//By login_link= By.xpath("//div[@id='content']/div[2]/div[1]/a[1]");
	By login_link = By.xpath("//div[@class='item user']/a");
	By about_us_link = By.xpath("//div[@class='item locate']/a");
	By contact_us_link = By.xpath("//div[@class='item shop']/a");
		
	By home_link_login_screen = By.xpath("//div[@id='templatemo_wrapper']/div[1]/div[2]/a[1]");
	By about_us_login_screen = By.xpath("//div[@id='templatemo_wrapper']/div[1]/div[2]/a[2]");
	By contact_us_login_screen = By.xpath("//div[@id='templatemo_wrapper']/div[1]/div[2]/a[3]");
	By userid_text = By.xpath("//table[@id='tblLogin']/tbody/tr[2]/td[2]/span[1]");
	By userid_textbox = By.xpath("//table[@id='tblLogin']/tbody/tr[2]/td[3]/input[1]");
	By password_text = By.xpath("//table[@id='tblLogin']/tbody/tr[3]/td[2]/span[1]");
	By password_textbox = By.xpath("//table[@id='tblLogin']/tbody/tr[3]/td[3]/input[1]");
	By login_button = By.xpath("//table[@id='tblLogin']/tbody/tr[5]/td[3]/input[1]");

	By sign_up_link = By.xpath("//table[@id='tblLogin']/tbody/tr[7]/td[2]/a[1]");
	By forgot_unlock_pwd_link = By.xpath("//table[@id='tblLogin']/tbody/tr[7]/td[3]/a[1]");
	By Loading_CircularProgressIcon = By.xpath("//div[@class='MuiCircularProgress-root MuiCircularProgress-indeterminate' and @role='progressbar']");
	
	By salutation_text = By.xpath("//div[@id='register']/div[2]/table[1]/tbody[1]/tr[4]/td[1]/span[1]");
	By salutation_dropdown = By.xpath("//div[@id='register']/div[2]/table[1]/tbody[1]/tr[4]/td[1]/select[1]");
	By salutation_dropdown_list = By.xpath("//div[@id='register']/div[2]/table[1]/tbody[1]/tr[4]/td[1]/select[1]/option");
	By first_name_textbox = By.xpath("//div[@id='register']/div[2]/table[1]/tbody[1]/tr[4]/td[2]/input[1]");
	By middle_name_textbox = By.xpath("//div[@id='register']/div[2]/table[1]/tbody[1]/tr[4]/td[3]/input[1]");
	By last_name_textbox = By.xpath("//div[@id='register']/div[2]/table[1]/tbody[1]/tr[4]/td[4]/input[1]");
	By dob_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[2]/td[1]/span[1]");
	By dob_textbox = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[2]/td[2]/input[1]");
	By dob_date_header = By.xpath("//div[@id='body_calDOB_title']");
	By dob_date_header_prev = By.xpath("//div[@id='body_calDOB_prevArrow']");
	By dob_date_header_next = By.xpath("//div[@id='body_calDOB_nextArrow']");
	//body_calDOB_title
	By datepickervalues = By.xpath("//div[@id='body_calDOB_body']/div[1]/table[1]/tbody[1]/tr/td/div");
	By monthpickervalues = By.xpath("//div[@id='body_calDOB_months']/table[1]/tbody[1]/tr/td/div[1]");
	By yearpickervalues = By.xpath("//div[@id='body_calDOB_years']/table[1]/tbody[1]/tr/td/div[1]");
	
	
	By address_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[5]/td[1]/span[1]");
	//By address_textbox = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[5]/td[3]/textarea[1]");
	By address_textbox = By.xpath("//textarea[@id='body_txtAddress']");
	
	
	By email_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[8]/td[1]/span[1]");
	By email_textbox = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[8]/td[3]/input[1]");
	
	By contact_no_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[11]/td[1]/span[1]");
	By contact_code = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[11]/td[3]/select");
	By contact_code_list = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[11]/td[3]/select[1]/option");
	By contact_number_textbox = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[11]/td[4]/input");
	
	By user_id_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[15]/td[1]/span[1]");
	By user_id_text_box = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[15]/td[3]/input");
	By check_userid_button = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[15]/td[4]/input");
	By message_validation = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[18]/td[1]/span[1]");
	
	By login_pwd_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[19]/td[1]/span[1]");
	By login_pwd_text_box = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[19]/td[3]/input");
	
	By confirm_login_pwd_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[19]/td[4]/span[1]");
	By confirm_login_pwd_text_box = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[19]/td[6]/input");
	
	By transaction_pwd_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[22]/td[1]/span[1]");
	By transaction_pwd_text_box = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[22]/td[3]/input");
	
	By confirm_transaction_pwd_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[22]/td[4]/span[1]");
	By confirm_transaction_pwd_text_box = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[22]/td[6]/input");
	
	By security_question_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[28]/td[1]/span[1]");
	By security_question_code = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[28]/td[3]/select");
	By security_question_list = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[28]/td[3]/select[1]/option");
	
	By security_answer_text = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[28]/td[4]/span[1]");
	By security_answer_text_box = By.xpath("//div[@id='register']/div[2]/table[2]/tbody[1]/tr[28]/td[4]/input[1]");
	
	By submit_button = By.xpath("//input[@name='ctl00$body$btnSubmit']");
	By reset_button = By.xpath("//input[@name='ctl00$body$btnReset']");
	By successregis_message = By.xpath("//span[@id='body_lblInsertMessage']");
	
	
	By home_link = By.xpath("//div[@id='header_right']/a[1]");
	By loginscreen_userid_text = By.xpath("//span[@id='body_lblUserID']");
	By loginscreen_userid_text_box = By.xpath("//input[@id='body_txtUserID']");
	
	By loginscreen_pwd_text = By.xpath("//span[@id='body_lblPassword']");
	By loginscreen_pwd_text_box = By.xpath("//input[@id='body_txtPassword']");
	
	By btn_login = By.xpath("//input[@id='body_btnLogin']");
	
	
	By open_new_account = By.xpath("//a[contains(text(),'Open New Account')]");
	By account_req_status = By.xpath("//a[contains(text(),'Account Request Status')]");
	By add_payee = By.xpath("//a[contains(text(),'Add Payee')]");
	By view_transactions = By.xpath("//a[contains(text(),'View Transactions')]");
	By transfer_money = By.xpath("//a[contains(text(),'Transfer Money')]");
	By cheque_book = By.xpath("//a[contains(text(),'Cheque Book')]");
	By change_user_id = By.xpath("//a[contains(text(),'Change User ID')]");
	

	By lblAccountType = By.xpath("//span[@id='body_cph_MyAccount_lblAccountType']");
	By ddlAccountType = By.xpath("//select[@id='body_cph_MyAccount_ddlAccountType']");
	By ddlAccountType_li = By.xpath("//select[@id='body_cph_MyAccount_ddlAccountType']/option");
	
	By lblState = By.xpath("//span[@id='body_cph_MyAccount_lblState']");
	By ddlState = By.xpath("//select[@id='body_cph_MyAccount_ddlState']");
	By ddlState_li = By.xpath("//select[@id='body_cph_MyAccount_ddlState']/option");
	
	By lblCity = By.xpath("//span[@id='body_cph_MyAccount_lblCity']");
	By ddlCity = By.xpath("//select[@id='body_cph_MyAccount_ddlCity']");
	By ddlCity_li = By.xpath("//select[@id='body_cph_MyAccount_ddlCity']/option");
	
	By lblBranch = By.xpath("//span[@id='body_cph_MyAccount_lblBranch']");
	By ddlBranch = By.xpath("//select[@id='body_cph_MyAccount_ddlBranch']");
	By ddlBranch_li = By.xpath("//select[@id='body_cph_MyAccount_ddlBranch']/option");
	
	By lblFileUpload = By.xpath("//span[@id='body_cph_MyAccount_lblFileUpload']");
	By FileUpload_btn = By.xpath("//input[@id='body_cph_MyAccount_fupUpload']");
	By lblFilesize = By.xpath("//span[@id='body_cph_MyAccount_lblFileSize']");
	By lbluploadproof = By.xpath("//span[@id='body_cph_MyAccount_lblUploadFiles']");
	By btn_submit = By.xpath("//input[@id='body_cph_MyAccount_btnUpdate']");
	By btn_reset = By.xpath("//input[@id='body_cph_MyAccount_btnReset']");
	
	By btn_MyAccount = By.xpath("//a[@id='GeneralTabMenu_Accounts_li_Cust']");
	By successaccountrequest_message = By.xpath("//span[@id='body_cph_MyAccount_lblUpdate']");
	
	
	By account_request_id = By.xpath("//table[@id='body_cph_MyAccount_gvViewAccountRequestStatus']/tbody/tr[2]/td[1]");
	By request_raised_on = By.xpath("//table[@id='body_cph_MyAccount_gvViewAccountRequestStatus']/tbody/tr[2]/td[2]");
	By request_type = By.xpath("//table[@id='body_cph_MyAccount_gvViewAccountRequestStatus']/tbody/tr[2]/td[3]");
	By account_type = By.xpath("//table[@id='body_cph_MyAccount_gvViewAccountRequestStatus']/tbody/tr[2]/td[4]");

	By ddlAccount_req_type_li = By.xpath("//select[@name='ctl00$ctl00$body$cph_MyAccount$ddlStatusType']/option");
	
	/*-----------------------------------------------------------------------*/
	

	
	/*---------------------------Methods---------------------------------------------------------------*/		
	public capstone_Project_UI_EXCEL_DB_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigate_login_page() {
		driver.findElement(login_link).click();
		//WebDriverWait wait = new WebDriverWait(driver,100);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Loading_CircularProgressIcon)));
	}
	
	public void navigate_sign_up_page() {
		driver.findElement(sign_up_link).click();
	}
	
	public void user_fill_customer_information() {
		//driver.findElement(sign_up_link).click();	
	}
	
	public void set_salutation(String salutation) throws InterruptedException {
		Thread.sleep(200);
		String value=salutation;
		driver.findElement(salutation_dropdown).click();
		List<WebElement> dropdownValues = driver.findElements(salutation_dropdown_list);
		for (WebElement i : dropdownValues) {
			if (i.getAttribute("value").equals(value)) {
				i.click();
				break;
			}
		}
	}
	
	public void set_first_name(String first_name) {
		user=first_name;
		driver.findElement(first_name_textbox).sendKeys(first_name);	
	}
	
	public void set_middle_name(String middle_name) {
		driver.findElement(middle_name_textbox).sendKeys(middle_name);	
	}
	
	public void set_last_name(String last_name) {
		driver.findElement(last_name_textbox).sendKeys(last_name);		
	}
	
	public void set_dob(String dob) throws InterruptedException{
		driver.findElement(dob_textbox).sendKeys(dob);			
//		Thread.sleep(500);
//		String dateVal = dob;
//		System.out.println("current date is:" + dob);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate dateofbirthcust = LocalDate.parse(dateVal, formatter);
//	
//		System.out.println("Month of dob: "+dateofbirthcust.getMonth());
//		System.out.println("Year of dob: "+dateofbirthcust.getYear());
//		int dayOfMonth = dateofbirthcust.getDayOfMonth();
//		String datevaluetobechecked=Integer.toString(dayOfMonth);
//		System.out.println("Day of dob: "+datevaluetobechecked);
//	
//		String monthtobechecked=dateofbirthcust.getMonth().toString();
//		String strOne = monthtobechecked.substring(0,1).toUpperCase();
//	    String strTwo = monthtobechecked.substring(1,3).toLowerCase();
//	    String updatedmonthtobechecked=strOne+strTwo;
//	    System.out.println("updatedmonthtobechecked: "+updatedmonthtobechecked);
//	    
//	    int yeartchecked=dateofbirthcust.getYear();
//	    String yeartobechecked=String.valueOf(yeartchecked);
//	    System.out.println("updatedyeartobechecked: "+yeartobechecked);
//	      
//	    
//	    driver.findElement(dob_textbox).click();
//	    Thread.sleep(100);
//	    driver.findElement(dob_date_header).click();
//	    Thread.sleep(100);
//	    driver.findElement(dob_textbox).click();
//	    Thread.sleep(100);
//	    driver.findElement(dob_date_header).click();
//	    Thread.sleep(100);
//
//		List<WebElement> dropdownValuesYear = driver.findElements(yearpickervalues);
//		for (WebElement i : dropdownValuesYear) {
//			Thread.sleep(100);
//			dropdownValuesYear = driver.findElements(yearpickervalues);
//			Thread.sleep(100);
//			System.out.println("all options in yearlist: "+i.getText());
//			if (i.getText().equals(yeartobechecked)) {
//				i.click();
//				break;
//			}
//			else
//			{
//				driver.findElement(dob_date_header_prev).click();
//			}
//		}
//		
//		Thread.sleep(100);
//		List<WebElement> dropdownValuesMonth = driver.findElements(monthpickervalues);
//		for (WebElement i : dropdownValuesMonth) {
//			System.out.println("all options in monthlist: "+i.getText());
//			if (i.getText().equals(updatedmonthtobechecked)) {
//				i.click();
//				break;
//			}
//		}
//		
//		Thread.sleep(100);
//		List<WebElement> dropdownValuesDate = driver.findElements(datepickervalues);//datepickervaluesbackwardtabvalues
//		for (WebElement i : dropdownValuesDate) {
//			System.out.println("all options in datelist: "+i.getText());
//			if (i.getText().equals(datevaluetobechecked)) {
//				i.click();
//				break;
//			}
//		}	
	}
	
	public void set_address(String address) {
		driver.findElement(address_textbox).sendKeys(address);
	}
	
	public void set_email_id(String email_id) {
		driver.findElement(email_textbox).sendKeys(email_id);
	}
	
	public void set_contact_code(String contactcode) {
		String value=contactcode;
		driver.findElement(contact_code).click();
		List<WebElement> dropdownValues = driver.findElements(contact_code_list);
		for (WebElement i : dropdownValues) {
			if (i.getAttribute("value").equals(value)) {
				i.click();
				break;
			}
		}
	}
	
	public void set_contact_number(String contact_number) {
		driver.findElement(contact_number_textbox).sendKeys(contact_number);
	}
	
	public void set_user_id(String user_id) throws IOException, InterruptedException {
		hooks = new hooks();	
		uniqueusername=(user_id+hooks.genarate_unique_username());	
		uniquieid=Integer.parseInt(hooks.genarate_unique_username());
		driver.findElement(user_id_text_box).sendKeys(uniqueusername);
		uniquenumber=Integer.parseInt((hooks.genarate_unique_username().substring(0,1)));
	}
	
	public void check_user_id() throws IOException, InterruptedException {
		driver.findElement(check_userid_button).click();
		Thread.sleep(100);
		String messagevalidation=driver.findElement(message_validation).getText();
		if(messagevalidation.equals("The UserId is available to be used"))
		{	
		    userpwd = hooks.genarate_unique_password();
		    System.out.println("randuserpassword: "+userpwd);
		    set_login_id_password();
		    Thread.sleep(200);
		    set_confirm_login_password();
		    Thread.sleep(200);
		    set_transaction_password();
		    Thread.sleep(200);
		    set_confirm_transaction_password();  
		    Thread.sleep(200);
		}
		
		else if(messagevalidation.equals("The UserId is available to be used"))
		{
			 System.out.println("Please Use another Id ");
		}
	}
	
	public void set_login_id_password() throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(100);
		driver.findElement(login_pwd_text_box).clear();
		Thread.sleep(100);
		driver.findElement(login_pwd_text_box).click();
		Thread.sleep(100);
		driver.findElement(login_pwd_text_box).click();
		//js.executeScript("arguments[0].value ='" + uniquenumber+userpwd+ "';", driver.findElement(By.id("body_txtUserPassword")));
		//System.out.println("sendeys value: "+ uniquenumber+userpwd);	
		js.executeScript("arguments[0].value ='"+"Test@"+uniquieid+"';", driver.findElement(By.id("body_txtUserPassword")));	
		Thread.sleep(100);
		Thread.sleep(100);
	
	}
	
	public void set_confirm_login_password() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("$('#" + "body_txtConfirmUserPwd" + "').val('"+uniquenumber+userpwd+"');");	
		js.executeScript("arguments[0].value ='"+"Test@"+uniquieid+"';", driver.findElement(By.id("body_txtConfirmUserPwd")));	
		driver.findElement(login_pwd_text_box).click();
	}
	
	public void set_transaction_password() throws IOException, InterruptedException {
		transactionpassword=hooks.genarate_unique_password();
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(100);
		driver.findElement(transaction_pwd_text_box).clear();
		Thread.sleep(100);
		driver.findElement(transaction_pwd_text_box).click();
		Thread.sleep(100);
		driver.findElement(transaction_pwd_text_box).click();
		driver.findElement(transaction_pwd_text_box).click();
		js.executeScript("arguments[0].value ='"+"Test@123"+uniquenumber+"';", driver.findElement(By.name("ctl00$body$txtTransactionPwd")));	
	}
	
	public void set_confirm_transaction_password() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value ='"+"Test@123"+uniquenumber+"';", driver.findElement(By.name("ctl00$body$txtConfirmTranPwd")));
		driver.findElement(confirm_transaction_pwd_text_box).click();
	}
	
	public void set_security_question(String securityquestion) {
		String value=securityquestion;
		driver.findElement(security_question_code).click();
		List<WebElement> dropdownValues = driver.findElements(security_question_list);
		for (WebElement i : dropdownValues) {
			if (i.getAttribute("value").equals(value)) {
				i.click();
				break;
			}
		}
	}
	
	public void set_security_answer(String security_answer) {
		driver.findElement(security_answer_text_box).sendKeys(security_answer);	
	}
	
	public void click_submit_button(String CustomerNumber) throws InterruptedException, IOException {
		driver.findElement(submit_button).click();
		Thread.sleep(2500);
		//String exp_message = "Registration Successful. The CustomerId is 20435";
		String gen_message = driver.findElement(successregis_message).getText();
		String gen_text_message = driver.findElement(successregis_message).getText();
		System.out.println("messag: "+gen_message);
		int length = gen_message.length();
		String gen_only_text_message = gen_text_message.substring(1,42);
		String gen_cust_id= gen_message.substring(43,length);
		System.out.println("gen_only_text_message : "+ gen_only_text_message);
		System.out.println("gen_cust_id : "+ gen_cust_id);
		
		if(!(gen_cust_id.equals("")))
			{
			    String registrationstatus="Completed";
				utils.store_user_login_information(System.getProperty("user.dir")+"/files/User_Login_Information.xlsx", CustomerNumber, gen_cust_id, user,uniqueusername,"Test@"+""+uniquieid+"",registrationstatus);	
				utils.store_user_login_information_user_input_file(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx",CustomerNumber, gen_cust_id,uniqueusername,"Test@"+""+uniquieid+"",registrationstatus);		    
				//utils.store_user_login_information_user_input_file(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx", gen_cust_id,uniqueusername,uniquenumber+userpwd);		    
			}
	}
	
	
	public void user_signs_up_all(String[] salutation_a, String[] first_name_a, String[] middle_name_a, String[]last_name_a, String[] dob_a, String[] address_a, String[] email_id_a, String[] contact_code_a, String[] contact_number_a, String[] user_id_a, String[] security_question_a,String[] security_answer_a, String[] user_name_a, String[] password_read_a,String[] account_type_a, String[]state_a, String[] city_a, String[] branch_a, String[] regisstatus) throws InterruptedException, NumberFormatException, IOException {
		Thread.sleep(500);	
		int totalcustomers=first_name_a.length;
		System.out.println("Total number of customers are: "+totalcustomers);
	   
		for (p=0;p<totalcustomers;p++)
		{	
			System.out.println("Status of Registration is "+regisstatus[p].toString());
			if(((regisstatus[p].toString()).equals("")))
			{
			int customernumber=p+1;
			String CustomerNumber=String.valueOf(customernumber);
			/*--sets Salutation---*/
			Thread.sleep(200);
			String value=salutation_a[p];
			driver.findElement(salutation_dropdown).click();
			List<WebElement> dropdownValues = driver.findElements(salutation_dropdown_list);
			for (WebElement i : dropdownValues) {
			if (i.getAttribute("value").equals(value)) {
				i.click();
				break;
				}
			}
			
			/*--sets first name---*/
			Thread.sleep(100);
			user=first_name_a[p];
			driver.findElement(first_name_textbox).sendKeys(first_name_a[p]);	
		
			/*--sets middle name---*/
			Thread.sleep(100);
			driver.findElement(middle_name_textbox).sendKeys(middle_name_a[p]);
		
			/*--sets last name name---*/
			Thread.sleep(100);
			driver.findElement(last_name_textbox).sendKeys(last_name_a[p]);
		
			/*--sets dob name---*/
			Thread.sleep(100);
			driver.findElement(dob_textbox).sendKeys(dob_a[p]);
		
			/*--sets address name---*/
			Thread.sleep(100);
			driver.findElement(address_textbox).sendKeys(address_a[p]);
		
			/*--sets address name---*/
			Thread.sleep(100);
			driver.findElement(email_textbox).sendKeys(email_id_a[p]);
		
			/*--sets contact code---*/
			Thread.sleep(100);
			String value_cc=contact_code_a[p];
			driver.findElement(contact_code).click();
			List<WebElement> dropdownValues_cc = driver.findElements(contact_code_list);
			for (WebElement i : dropdownValues_cc) {
				if (i.getAttribute("value").equals(value_cc)) {
					i.click();
					break;
				}
			}
			
			/*--sets contact number---*/
			Thread.sleep(100);
			driver.findElement(contact_number_textbox).sendKeys(contact_number_a[p]);
			
			/*--sets user id---*/
			Thread.sleep(100);
			hooks = new hooks();
			uniqueusername=(user_id_a[p]+hooks.genarate_unique_username());	
			uniquieid=Integer.parseInt(hooks.genarate_unique_username());
			driver.findElement(user_id_text_box).sendKeys(uniqueusername);
			uniquenumber=Integer.parseInt((hooks.genarate_unique_username().substring(0,1)));
			
			/*--validates user id---*/
			Thread.sleep(100);
			driver.findElement(check_userid_button).click();
			Thread.sleep(500);
			String messagevalidation=driver.findElement(message_validation).getText();
			System.out.println("messagevalidation: "+messagevalidation);
			if(messagevalidation.equals("The UserId is available to be used"))
			{	
			    userpwd = hooks.genarate_unique_password();
			    System.out.println("randuserpassword: "+userpwd);
			    set_login_id_password();
			    Thread.sleep(200);
			    set_confirm_login_password();
			    Thread.sleep(200);
			    set_transaction_password();
			    Thread.sleep(200);
			    set_confirm_transaction_password();  
			    Thread.sleep(200);
			}
			
			else if(messagevalidation.equals("The UserId is available to be used"))
			{
				 System.out.println("Please Use another Id ");
			}
			
			/*--sets security question---*/
			Thread.sleep(100);
			String value_sq=security_question_a[p];
			driver.findElement(security_question_code).click();
			List<WebElement> dropdownValues_sq = driver.findElements(security_question_list);
			for (WebElement i : dropdownValues_sq) {
				if (i.getAttribute("value").equals(value_sq)) {
					i.click();
					break;
				}
			}
				
			/*--sets security answer---*/
			Thread.sleep(100);
			driver.findElement(security_answer_text_box).sendKeys(security_answer_a[p]);	
			
			/*--submit button and update excel---*/
			Thread.sleep(100);
			driver.findElement(submit_button).click();
			Thread.sleep(2000);
			String gen_message = driver.findElement(successregis_message).getText();
			String gen_text_message = driver.findElement(successregis_message).getText();
			System.out.println("messag: "+gen_message);
			int length = gen_message.length();
			String gen_only_text_message = gen_text_message.substring(1,42);
			String gen_cust_id= gen_message.substring(43,length);
			System.out.println("gen_only_text_message : "+ gen_only_text_message);
			System.out.println("gen_cust_id : "+ gen_cust_id);
			
			if(!(gen_cust_id.equals("")))
				{
				    String registrationstatus="Completed";
					utils.store_user_login_information_all(System.getProperty("user.dir")+"/files/User_Login_Information.xlsx", CustomerNumber, gen_cust_id, user,uniqueusername,"Test@"+""+uniquieid+"",registrationstatus);	
					utils.store_user_login_information_user_input_file_all(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx",CustomerNumber, gen_cust_id,uniqueusername,"Test@"+""+uniquieid+"",registrationstatus);		    
				}
			
			/*--Reset button---*/
			Thread.sleep(100);
			driver.findElement(reset_button).click();
			Thread.sleep(2000);
			}
			
			else if(((regisstatus[p].toString()).equals("Completed")))
			{
				System.out.println("Customer number:" + p +"is already registered, moving to next customer!!");
			}	
		}
	
	}
	
	
	
	public void user_signs_up_all_saves_in_database(String[] customer_number_a, String[] salutation_a, String[] first_name_a, String[] middle_name_a, String[] last_name_a, String[] dob_a, String[] address_a, String[] email_id_a, String[] contact_code_a, String[] contact_number_a, String[] user_id_a, String[] security_question_a, String[] security_answer_a, String[] account_type_a, String[] state_a, String[] city_a, String[] branch_a, String[] customer_id_a, String[] user_name_a, String[] password_read_a, String[] user_registration_a	) throws InterruptedException, NumberFormatException, IOException, ClassNotFoundException, SQLException {
		Thread.sleep(500);	
		int totalcustomers=first_name_a.length;
		System.out.println("Total number of customers are: "+totalcustomers);  
		for (p=0;p<totalcustomers;p++)
		{	
			System.out.println("Status of Registration is "+user_registration_a[p].toString());
			if(((user_registration_a[p].toString()).equals("")))
			{
			int customernumber=p+1;
			String CustomerNumber=String.valueOf(customernumber);
			/*--sets Salutation---*/
			Thread.sleep(200);
			String value=salutation_a[p];
			driver.findElement(salutation_dropdown).click();
			List<WebElement> dropdownValues = driver.findElements(salutation_dropdown_list);
			for (WebElement i : dropdownValues) {
			if (i.getAttribute("value").equals(value)) {
				i.click();
				break;
				}
			}
			
			/*--sets first name---*/
			Thread.sleep(100);
			user=first_name_a[p];
			driver.findElement(first_name_textbox).sendKeys(first_name_a[p]);	
		
			/*--sets middle name---*/
			Thread.sleep(100);
			driver.findElement(middle_name_textbox).sendKeys(middle_name_a[p]);
		
			/*--sets last name name---*/
			Thread.sleep(100);
			driver.findElement(last_name_textbox).sendKeys(last_name_a[p]);
		
			/*--sets dob name---*/
			Thread.sleep(100);
			driver.findElement(dob_textbox).sendKeys(dob_a[p]);
		
			/*--sets address name---*/
			Thread.sleep(100);
			driver.findElement(address_textbox).sendKeys(address_a[p]);
		
			/*--sets address name---*/
			Thread.sleep(100);
			driver.findElement(email_textbox).sendKeys(email_id_a[p]);
		
			/*--sets contact code---*/
			Thread.sleep(100);
			String value_cc=contact_code_a[p];
			driver.findElement(contact_code).click();
			List<WebElement> dropdownValues_cc = driver.findElements(contact_code_list);
			for (WebElement i : dropdownValues_cc) {
				if (i.getAttribute("value").equals(value_cc)) {
					i.click();
					break;
				}
			}
			
			/*--sets contact number---*/
			Thread.sleep(100);
			driver.findElement(contact_number_textbox).sendKeys(contact_number_a[p]);
			
			/*--sets user id---*/
			Thread.sleep(100);
			hooks = new hooks();
			uniqueusername=(user_id_a[p]+hooks.genarate_unique_username());	
			uniquieid=Integer.parseInt(hooks.genarate_unique_username());
			driver.findElement(user_id_text_box).sendKeys(uniqueusername);
			uniquenumber=Integer.parseInt((hooks.genarate_unique_username().substring(0,1)));
			
			/*--validates user id---*/
			Thread.sleep(100);
			driver.findElement(check_userid_button).click();
			Thread.sleep(500);
			String messagevalidation=driver.findElement(message_validation).getText();
			System.out.println("messagevalidation: "+messagevalidation);
			if(messagevalidation.equals("The UserId is available to be used"))
			{	
			    userpwd = hooks.genarate_unique_password();
			    System.out.println("randuserpassword: "+userpwd);
			    set_login_id_password();
			    Thread.sleep(200);
			    set_confirm_login_password();
			    Thread.sleep(200);
			    set_transaction_password();
			    Thread.sleep(200);
			    set_confirm_transaction_password();  
			    Thread.sleep(200);
			}
			
			else if(messagevalidation.equals("The UserId is available to be used"))
			{
				 System.out.println("Please Use another Id ");
			}
			
			/*--sets security question---*/
			Thread.sleep(100);
			String value_sq=security_question_a[p];
			driver.findElement(security_question_code).click();
			List<WebElement> dropdownValues_sq = driver.findElements(security_question_list);
			for (WebElement i : dropdownValues_sq) {
				if (i.getAttribute("value").equals(value_sq)) {
					i.click();
					break;
				}
			}
				
			/*--sets security answer---*/
			Thread.sleep(100);
			driver.findElement(security_answer_text_box).sendKeys(security_answer_a[p]);	
			
			/*--submit button and update excel---*/
			Thread.sleep(100);
			driver.findElement(submit_button).click();
			Thread.sleep(2000);
			String gen_message = driver.findElement(successregis_message).getText();
			String gen_text_message = driver.findElement(successregis_message).getText();
			System.out.println("messag: "+gen_message);
			int length = gen_message.length();
			String gen_only_text_message = gen_text_message.substring(1,42);
			String gen_cust_id= gen_message.substring(43,length);
			System.out.println("gen_only_text_message : "+ gen_only_text_message);
			System.out.println("gen_cust_id : "+ gen_cust_id);
			
			if(!(gen_cust_id.equals("")))
				{
				    String registrationstatus="Completed";
					utils.store_user_login_information_all(System.getProperty("user.dir")+"/files/User_Login_Information.xlsx", CustomerNumber, gen_cust_id, user,uniqueusername,"Test@"+""+uniquieid+"",registrationstatus);	
					utils.store_user_login_information_user_input_file_all(System.getProperty("user.dir")+"/files/User_Information_Input_File.xlsx",CustomerNumber, gen_cust_id,uniqueusername,"Test@"+""+uniquieid+"",registrationstatus);		    
					hooks.database_inserts_value_in_table_UI(customer_number_a[p], salutation_a[p], first_name_a[p], middle_name_a[p], last_name_a[p], dob_a[p], address_a[p], email_id_a[p],contact_code_a[p], contact_number_a[p], user_id_a[p], security_question_a[p], security_answer_a[p], account_type_a[p], state_a[p], city_a[p], branch_a[p], gen_cust_id,uniqueusername,"Test@"+""+uniquieid+"",registrationstatus); 	  
				}
			
			/*--Reset button---*/
			Thread.sleep(100);
			driver.findElement(reset_button).click();
			Thread.sleep(2000);
			}
			
			else if(((user_registration_a[p].toString()).equals("Completed")))
			{
				System.out.println("Customer number:" + p +"is already registered, moving to next customer!!");
			}	
		}
	
	}
	
	
	
	public void user_validates_negative_testcase(String[] customer_number_a, String[] salutation_a, String[] first_name_a, String[] middle_name_a, String[] last_name_a, String[] dob_a, String[] address_a, String[] email_id_a, String[] contact_code_a, String[] contact_number_a, String[] user_id_a, String[] security_question_a, String[] security_answer_a, String[] account_type_a, String[] state_a, String[] city_a, String[] branch_a, String[] customer_id_a, String[] user_name_a, String[] password_read_a, String[] user_registration_a	) throws InterruptedException, NumberFormatException, IOException, ClassNotFoundException, SQLException {
		Thread.sleep(500);	
		int totalcustomers=first_name_a.length;
		System.out.println("Total number of customers are: "+totalcustomers);  
		for (p=0;p<totalcustomers;p++)
		{	
			System.out.println("Status of Registration is "+user_registration_a[p].toString());
			if(((user_registration_a[p].toString()).equals("Completed")))
			{
			int customernumber=p+1;
			String CustomerNumber=String.valueOf(customernumber);
			/*--sets Salutation---*/
			Thread.sleep(200);
			String value=salutation_a[p];
			driver.findElement(salutation_dropdown).click();
			List<WebElement> dropdownValues = driver.findElements(salutation_dropdown_list);
			for (WebElement i : dropdownValues) {
			if (i.getAttribute("value").equals(value)) {
				i.click();
				break;
				}
			}
			
			/*--sets first name---*/
			Thread.sleep(100);
			user=first_name_a[p];
			driver.findElement(first_name_textbox).sendKeys(first_name_a[p]);	
		
			/*--sets middle name---*/
			Thread.sleep(100);
			driver.findElement(middle_name_textbox).sendKeys(middle_name_a[p]);
		
			/*--sets last name name---*/
			Thread.sleep(100);
			driver.findElement(last_name_textbox).sendKeys(last_name_a[p]);
		
			/*--sets dob name---*/
			Thread.sleep(100);
			driver.findElement(dob_textbox).sendKeys(dob_a[p]);
		
			/*--sets address name---*/
			Thread.sleep(100);
			driver.findElement(address_textbox).sendKeys(address_a[p]);
		
			/*--sets address name---*/
			Thread.sleep(100);
			driver.findElement(email_textbox).sendKeys(email_id_a[p]);
		
			/*--sets contact code---*/
			Thread.sleep(100);
			String value_cc=contact_code_a[p];
			driver.findElement(contact_code).click();
			List<WebElement> dropdownValues_cc = driver.findElements(contact_code_list);
			for (WebElement i : dropdownValues_cc) {
				if (i.getAttribute("value").equals(value_cc)) {
					i.click();
					break;
				}
			}
			
			/*--sets contact number---*/
			Thread.sleep(100);
			driver.findElement(contact_number_textbox).sendKeys(contact_number_a[p]);
			
			/*--sets user id---*/
			Thread.sleep(100);
			
			driver.findElement(user_id_text_box).sendKeys(user_name_a[p]);
			
			/*--validates user id---*/
			Thread.sleep(100);
			driver.findElement(check_userid_button).click();
			Thread.sleep(500);
			String messagevalidation=driver.findElement(message_validation).getText();
			System.out.println("messagevalidation: "+messagevalidation);
			
			Assert.assertEquals("The UserId has been used", messagevalidation);
			Thread.sleep(100);
			driver.findElement(reset_button).click();
			Thread.sleep(2000);
			}
		}
	
	}
	
	
	
	public void navigate_log_in_page() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(100);
		driver.findElement(home_link).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		Thread.sleep(100);
		driver.findElement(By.xpath("//body")).click();
		
		String first_handle = driver.getWindowHandle();
		new WebDriverWait(driver,5).until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allHandles = driver.getWindowHandles();
		for(String winHandle:allHandles)
		{
		    if (!first_handle.equalsIgnoreCase(winHandle))
		    {
		        driver.switchTo().window(winHandle);
		    }
		}
				
		Thread.sleep(1000);
		driver.findElement(login_link).click();
		Thread.sleep(2000);
		driver.findElement(loginscreen_userid_text_box).sendKeys(uniqueusername);
		Thread.sleep(100);
		driver.findElement(loginscreen_pwd_text_box).sendKeys("Test@"+""+uniquieid+"");
		Thread.sleep(100);
		driver.findElement(btn_login).click();
	}
	
	
	public void navigate_log_in_page_already_gen_credentials(String customer_id, String password_read) throws InterruptedException {
		driver.findElement(loginscreen_userid_text_box).sendKeys(customer_id);
		Thread.sleep(100);
		driver.findElement(loginscreen_pwd_text_box).sendKeys(password_read);
		Thread.sleep(100);
		driver.findElement(btn_login).click();
	}
	
	public void new_account_access() throws InterruptedException {
		driver.findElement(btn_MyAccount).click();
		Thread.sleep(100);
		driver.findElement(open_new_account).click();
	}
	
	
	public void set_account_type(String account_type) throws InterruptedException {
		Thread.sleep(500);
		List<WebElement> dropdownValuesaccttype = driver.findElements(ddlAccountType_li);
		for (WebElement i : dropdownValuesaccttype) {
			System.out.println("all options in ddlAccountType: "+i.getText());
			System.out.println("passed options : "+account_type);
			if (i.getText().equals(account_type)) {
				System.out.println("ddl value matched: ");
				i.click();
				break;
			}
		}
	}
	
	public void set_state(String state) throws InterruptedException {
		Thread.sleep(500);
		List<WebElement> dropdownValuesstate = driver.findElements(ddlState_li);
		for (WebElement i : dropdownValuesstate) {
			//System.out.println("all options in state: "+i.getText());
			System.out.println("passed options : "+state);
			if (i.getText().equals(state)) {
				i.click();
				break;
			}
		}
	}
	
	
	public void set_city(String city) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> dropdownValuescity = driver.findElements(ddlCity_li);
		for (WebElement i : dropdownValuescity) {
			//System.out.println("all options in city: "+i.getText());
			System.out.println("passed options : "+city);
			if (i.getText().equals(city)) {
				i.click();
				break;
			}
		}
	}
	
	public void set_branch(String branch) throws InterruptedException {
		Thread.sleep(500);
		List<WebElement> dropdownValuesbranch = driver.findElements(ddlBranch_li);
		for (WebElement i : dropdownValuesbranch) {
			System.out.println("all options in branch: "+i.getText());
			System.out.println("passed options : "+branch);
			if (i.getText().equals(branch)) {
				i.click();
				break;
			}
		}
	}
	
	public void uploadproofs_File(String filepath) throws InterruptedException, AWTException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[@type='file']")).sendKeys(filepath);	
	}
	
	public void user_clicks_submit_button() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(100);
		driver.findElement(btn_submit).click();
		Thread.sleep(500);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(100);
		String gen_message = driver.findElement(successaccountrequest_message).getText();
		String gen_text_message = driver.findElement(successaccountrequest_message).getText();
		System.out.println("messag: "+gen_message);
		int length = gen_message.length();
		String gen_only_text_message = gen_text_message.substring(0,52);
		gen_cust_id= gen_message.substring(53,length);
		System.out.println("gen_only_text_message : "+ gen_only_text_message);
		System.out.println("gen_cust_id : "+ gen_cust_id);
	}
	
	
	public void validate_account_request_status() throws InterruptedException {
		driver.findElement(btn_MyAccount).click();
		Thread.sleep(100);
		driver.findElement(account_req_status).click();
	}
	
	public void set_exist_account_type(String account_type) throws InterruptedException {
		Thread.sleep(500);
		List<WebElement> dropdownValuesaccttype = driver.findElements(ddlAccount_req_type_li);
		for (WebElement i : dropdownValuesaccttype) {
			System.out.println("all options in ddlAccountType: "+i.getText());
			System.out.println("passed options : "+account_type);
			if (i.getText().equals(account_type)) {
				System.out.println("ddl value matched: ");
				i.click();
				break;
			}
		}
	}
	
	public void validate_request_status(String reqstatus, String accounttype) throws InterruptedException {
		
		Thread.sleep(2000);
		String request_id = driver.findElement(account_request_id).getText();
		Assert.assertEquals(gen_cust_id, request_id);
		
		String req_raised_on= driver.findElement(request_raised_on).getText();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String todaysdate=dtf.format(localDate).toString();
		System.out.println("todaysdate: "+todaysdate);
		Assert.assertEquals(todaysdate, req_raised_on); 
		
		String req_type= driver.findElement(request_type).getText();
		Assert.assertEquals(reqstatus, req_type); 
		
		String acct_type= driver.findElement(account_type).getText();
		Assert.assertEquals(accounttype, acct_type); 	 
	}
		
/*-----------------------------------------------------------------------------------------*/	
}
