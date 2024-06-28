package Utilities;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.capstone_Project_UI_EXCEL_DB_Page;
import io.restassured.response.Response;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hooks {
	capstone_Project_UI_EXCEL_DB_Page page;
	utils utils;
	Response response;
	String responseString;
	String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyJ9.eyJhdWQiOiJhNTViMDA0Zi0zZTkzLTQzNGYtODAwYi00NzZlZGI3NjAyZGIiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNDFjYjU0NzgtMWY4YS00YThlLWEyYjctNThiYmMxMTk4YzUyL3YyLjAiLCJpYXQiOjE2MjY3ODMyMDEsIm5iZiI6MTYyNjc4MzIwMSwiZXhwIjoxNjI2Nzg3MTAxLCJhaW8iOiJFMlpnWVBoL2RQTUZwajkyVHAzVHZuMzRrbjdtSndBPSIsImF6cCI6ImE1NWIwMDRmLTNlOTMtNDM0Zi04MDBiLTQ3NmVkYjc2MDJkYiIsImF6cGFjciI6IjEiLCJvaWQiOiI5ZDE2Y2FlNS0wZGM3LTRjY2YtYjUwMC03NjFiMGUxNWJmMjUiLCJyaCI6IjAuQVRrQWVGVExRWW9mamtxaXQxaTd3Um1NVWs4QVc2V1RQazlEZ0F0SGJ0dDJBdHM1QUFBLiIsInJvbGVzIjpbImRwbW0ud2FyZWhvdXNlLndyaXRlIiwiZHBtbS5pbnZlbnRvcnkucmVhZCIsImRwbW0ub3JkZXJzLndyaXRlIiwiZHBtbS5vcmRlcnMucmVhZCIsImRwbW0uaW52ZW50b3J5LndyaXRlIiwiZHBtbS53YXJlaG91c2UucmVhZCIsImRwbW0udXNlcm1nbXQud3JpdGUiLCJkcG1tLnVzZXJtZ210LnJlYWQiXSwic3ViIjoiOWQxNmNhZTUtMGRjNy00Y2NmLWI1MDAtNzYxYjBlMTViZjI1IiwidGlkIjoiNDFjYjU0NzgtMWY4YS00YThlLWEyYjctNThiYmMxMTk4YzUyIiwidXRpIjoib1cyMFpkSHRTRS1GY1pHQm0wamhBQSIsInZlciI6IjIuMCJ9.A0XLcIUsTbtCeYNiSg5Wtui8-HTLNkpJlR4kKS5uJKbMJTi5J75LA2FMvPuW6hJ4SpDlRVbNo06P-L7HxduQgEVr_xGPDPiQSqrZw4TLuMCkMGsfV1g8n8vmeiWwhg-jYLffHaWaiTLt4v0_TLrfpxwxn--a_cBfGz4HgI_fTj92eEQdu4RDivMZgbiyXwF7jAoNFsp9SpfOg10gOZU4rX_V93mG0BFgb60jgS-cNk9CHLq5nWQwO6HHhTOg20_mEuqtCHhlKD2FmrnHFJA9YQduUTVgJgvFEQ081cG7UpWW4-OJ6RZiJYKmQQL4pE3NvpGjctRFld3m8gphWgXcgg";
	
	String[] salutation_a,first_name_a,middle_name_a,last_name_a,dob_a,address_a,email_id_a,contact_code_a,contact_number_a,user_id_a,security_question_a,security_answer_a,user_name_a,password_read_a;
	String[] customer_number_a, customer_id_a, account_type_a, state_a, city_a, branch_a, regisstatus_a;;
	
    EdgeDriver driver = null;
    ChromeDriver driverc = null;
	WebDriver driverw=null;
    
    private Scenario takescreenshot;
	
    public EdgeDriver startedgeBrowser_in_essence() throws IOException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.edge.driver", projectPath + "/src/test/resources/Drivers/msedgedriver_126.exe");	
		try {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_126.exe");
			Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");
			Thread.sleep(500);
			driver = new EdgeDriver();
		} catch (Exception e) {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_126.exe");
			Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");   
		}
		try
		{
		driver.navigate().to("http://10.82.180.36/Common/HomePage.aspx");
		}catch (Exception e) {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_126.exe");
			Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");
		}
		driver.manage().window().maximize();
		page = new capstone_Project_UI_EXCEL_DB_Page(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}catch (Exception e) {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_126.exe");
			Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");
		}
		return driver;
	}
     
    public ChromeDriver startBrowser_in_essence_chrome() throws IOException {
		ChromeOptions options= new ChromeOptions();
		//options.addArguments("--incognito");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver_126.exe");

		try {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
			Thread.sleep(500);
			driverc = new ChromeDriver(options);
		} catch (Exception e) { 
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
		}

		try
		{
			driverc.navigate().to("http://10.82.180.36/Common/HomePage.aspx");
		}catch (Exception e) {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
		}
		driverc.manage().window().maximize();
		page = new capstone_Project_UI_EXCEL_DB_Page(driverc);
		driverc.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
			driverc.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}catch (Exception e) {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
		}
		return driverc;
	}
    
    public ChromeDriver startBrowser_google_chrome() throws IOException {
 		//ChromeOptions options= new ChromeOptions();
 		//options.addArguments("--incognito");
 		String projectPath = System.getProperty("user.dir");
 		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver_126.exe");

 		try {
 			//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
 			//Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
 			Thread.sleep(500);
 			driverc = new ChromeDriver();
 		} catch (Exception e) { 
 			//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
 			//Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
 		}

 		try
 		{
 			driverc.navigate().to("http://google.com");
 		}catch (Exception e) {
 			//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
 			//Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
 		}
 		driverc.manage().window().maximize();
 		page = new capstone_Project_UI_EXCEL_DB_Page(driverc);
 		driverc.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 		try
 		{
 			driverc.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
 		}catch (Exception e) {
 			//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
 			//Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
 		}
 		return driverc;
 	}
    
    public WebDriver startBrowser_google_chrome_n() throws IOException {
    	  WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
          //options.addArguments("--no-sandbox");
          //options.addArguments("--disable-dev-shm-usage");
          options.addArguments("--headless");
          driverw = new ChromeDriver(options);
          //driverc = new ChromeDriver(options);
          driverw.navigate().to("https://google.com");
          driverw.manage().window().maximize();
          driverw.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
    	  
		return driverw;
 	}
    
    public EdgeDriver startedgeBrowser_google_edge() throws IOException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.edge.driver", projectPath + "/src/test/resources/Drivers/msedgedriver_126.exe");	
		try {
			//Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_126.exe");
			//Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");
			Thread.sleep(500);
			driver = new EdgeDriver();
		} catch (Exception e) {
			//Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_126.exe");
			//Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");   
		}
		try
		{
		driver.navigate().to("http://google.com");
		}catch (Exception e) {
			//Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_126.exe");
			//Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");
		}
		driver.manage().window().maximize();
		page = new capstone_Project_UI_EXCEL_DB_Page(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}catch (Exception e) {
			//Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_126.exe");
			//Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");
		}
		return driver;
	}
     
    public String genarate_unique_username() throws IOException, InterruptedException {
    	double num = Math.floor(Math.random()*89999999+10000000);
		String randomnumber = String.valueOf(num);
		StringBuilder randomunique = new StringBuilder(randomnumber);
		//randomunique.setCharAt(4, '5');
		String randnumnew=randomunique.substring(2,7);
		System.out.println("randusernamenew: "+randnumnew);
		return randnumnew;
		   
    }
     
    public String genarate_unique_password() throws IOException, InterruptedException {
		//String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String character = "@#$&*";
		//String number = "1234567890";
		String userpwd = RandomStringUtils.random( 13, character+lower+character);
		System.out.println("randuserpassword: "+userpwd);
		boolean isMatch = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$").matcher(userpwd).find(); 
		System.out.println(isMatch);
		return userpwd;
    }
    
  
    public void embedScreenshotStep(Scenario scenario) {
	    takescreenshot = scenario;		
	}
    
	public void i_take_a_screenshot() throws Throwable {	
		try 
			{
        		if(this.driverw!=null)
        			{
        				byte[] screenshot = ((TakesScreenshot)driverw).getScreenshotAs(OutputType.BYTES);
        				//takescreenshot.embed(screenshot, "image/png");
        			}
        	else if (this.driverw==null)
        			{
        		
        			}
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
        } catch (ClassCastException cce) 
			{
            cce.printStackTrace();
			}
    }
	
	
	public void databaseconnectiontest() throws ClassNotFoundException,SQLException { 
		//String dbUrl ="jdbc:sqlserver://150.45.89.226:2150;"+"encrypt=true;trustServerCertificate=true";
		//RestAssured.proxy("150.45.87.133", 8080);
		String dbUrl ="jdbc:sqlserver://PUNITP304691L\\MSSQLSERVER ;databaseName=CAPSTONE_PROJECT;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		//String username = "ITLINFOSYS\\aman.kumar40"; 
		//String password = ""; 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection con =DriverManager.getConnection(dbUrl);
		Statement stmt = con.createStatement(); 
	
		//-----------------------------------------Read Data--------------------------------------------------------
		
		String datatwo_querytwo ="select * from CAPSTONE_PROJECT.dbo.TestTable;"; 
		ResultSet resultsettwo= stmt.executeQuery(datatwo_querytwo);	
		while (resultsettwo.next())
		{ 
			String id = resultsettwo.getString(1); 
			//String updatedstatus = resultsettwo.getString(14);
			System.out.println("testssssssss"+id); 
			//Assert.assertEquals("aman", updatedstatus);
		} 
		con.close();
	}
		
	
	public void database_create_table(String tablename) throws ClassNotFoundException,SQLException { 
		String dbUrl ="jdbc:sqlserver://PUNITP304691L\\MSSQLSERVER ;databaseName=CAPSTONE_PROJECT;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection con =DriverManager.getConnection(dbUrl);
		Statement stmt = con.createStatement(); 
	
		//-----------------------------------------Create Table--------------------------------------------------------
		
		String createtablequery ="CREATE TABLE CAPSTONE_PROJECT.dbo."+tablename+" (customer_number varchar(30), salutation varchar(30), first_name varchar(30), middle_name varchar(30), last_name varchar(30), dob varchar(30), address varchar(30), email_id varchar(30), contact_code varchar(30), contact_number varchar(30), user_id varchar(30), security_question varchar(30), security_answer varchar(30), account_type varchar(30), state varchar(30), city varchar(30), branch varchar(50), customer_id varchar(30), user_name varchar(30), password_read varchar(30), user_registration varchar(30))"; 
		stmt.executeUpdate(createtablequery);	
		con.close();
	}
	
	public void database_inserts_value_in_table(String databasename, String customer_number, String salutation, String first_name, String middle_name, String last_name, String dob, String address, String email_id, String contact_code, String contact_number, String user_id, String security_question, String security_answer, String account_type, String state, String city, String branch, String customer_id, String user_name, String password_read, String user_registration	) throws ClassNotFoundException,SQLException { 
		String dbUrl ="jdbc:sqlserver://PUNITP304691L\\MSSQLSERVER ;databaseName=CAPSTONE_PROJECT;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection con =DriverManager.getConnection(dbUrl);
		Statement stmt = con.createStatement(); 
	
		//-----------------------------------------Insert Data--------------------------------------------------------
		
		PreparedStatement createtablequery =con.prepareStatement("Insert into CAPSTONE_PROJECT.dbo."+databasename+" (customer_number, salutation, first_name, middle_name, last_name, dob, address, email_id,contact_code, contact_number, user_id, security_question, security_answer, account_type, state, city, branch, customer_id, user_name, password_read, user_registration) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
		createtablequery.setString(1,customer_number);
		createtablequery.setString(2,salutation);
		createtablequery.setString(3,first_name);
		createtablequery.setString(4,middle_name);
		createtablequery.setString(5,last_name);
		createtablequery.setString(6,dob);
		createtablequery.setString(7,address);
		createtablequery.setString(8,email_id);
		createtablequery.setString(9,contact_code);
		createtablequery.setString(10,contact_number);
		createtablequery.setString(11,user_id);
		createtablequery.setString(12,security_question);
		createtablequery.setString(13,security_answer);
		createtablequery.setString(14,account_type);
		createtablequery.setString(15,state);
		createtablequery.setString(16,city);
		createtablequery.setString(17,branch);
		createtablequery.setString(18,customer_id);
		createtablequery.setString(19,user_name);
		createtablequery.setString(20,password_read);
		createtablequery.setString(21,user_registration);
		createtablequery.executeUpdate();	
		con.close();
	}
	
	public void database_inserts_value_in_table_UI(String customer_number, String salutation, String first_name, String middle_name, String last_name, String dob, String address, String email_id, String contact_code, String contact_number, String user_id, String security_question, String security_answer, String account_type, String state, String city, String branch, String customer_id, String user_name, String password_read, String user_registration	) throws ClassNotFoundException,SQLException { 
		String dbUrl ="jdbc:sqlserver://PUNITP304691L\\MSSQLSERVER ;databaseName=CAPSTONE_PROJECT;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection con =DriverManager.getConnection(dbUrl);
		Statement stmt = con.createStatement(); 
	
		//-----------------------------------------Insert Data--------------------------------------------------------
		
		PreparedStatement createtablequery =con.prepareStatement("Insert into CAPSTONE_PROJECT.dbo.CAPSTONETABLEDUMMYONE (customer_number, salutation, first_name, middle_name, last_name, dob, address, email_id,contact_code, contact_number, user_id, security_question, security_answer, account_type, state, city, branch, customer_id, user_name, password_read, user_registration) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
		createtablequery.setString(1,customer_number);
		createtablequery.setString(2,salutation);
		createtablequery.setString(3,first_name);
		createtablequery.setString(4,middle_name);
		createtablequery.setString(5,last_name);
		createtablequery.setString(6,dob);
		createtablequery.setString(7,address);
		createtablequery.setString(8,email_id);
		createtablequery.setString(9,contact_code);
		createtablequery.setString(10,contact_number);
		createtablequery.setString(11,user_id);
		createtablequery.setString(12,security_question);
		createtablequery.setString(13,security_answer);
		createtablequery.setString(14,account_type);
		createtablequery.setString(15,state);
		createtablequery.setString(16,city);
		createtablequery.setString(17,branch);
		createtablequery.setString(18,customer_id);
		createtablequery.setString(19,user_name);
		createtablequery.setString(20,password_read);
		createtablequery.setString(21,user_registration);
		createtablequery.executeUpdate();	
		con.close();
	}
	
	public void database_read_compare_values(String databasename, String customer_number, String salutation, String first_name, String middle_name, String last_name, String dob, String address, String email_id, String contact_code, String contact_number, String user_id, String security_question, String security_answer, String account_type, String state, String city, String branch, String customer_id, String user_name, String password_read, String user_registration	) throws ClassNotFoundException,SQLException { 
		String dbUrl ="jdbc:sqlserver://PUNITP304691L\\MSSQLSERVER ;databaseName=CAPSTONE_PROJECT;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection con =DriverManager.getConnection(dbUrl);
		Statement stmt = con.createStatement(); 
	
		//-----------------------------------------Insert Data--------------------------------------------------------
		
		PreparedStatement readtablequery =con.prepareStatement("Select customer_number, salutation, first_name, middle_name, last_name, dob, address, email_id,contact_code, contact_number, user_id, security_question, security_answer, account_type, state, city, branch, customer_id, user_name, password_read, user_registration from CAPSTONE_PROJECT.dbo."+databasename+" where customer_number=?"); 

		readtablequery.setString(1,customer_number);
		
		ResultSet resultset=readtablequery.executeQuery();
		while (resultset.next())
		{ 
			String customernumber = resultset.getString(1); 
			System.out.println("customernumber as read from db: "+customernumber); 
			Assert.assertEquals(customer_number, customernumber);
			
			String salu = resultset.getString(2); 
			System.out.println("salutation as read from db: "+salu); 
			Assert.assertEquals(salutation, salu);
			
			String fn = resultset.getString(3); 
			System.out.println("first_name as read from db: "+fn); 
			Assert.assertEquals(first_name, fn);
			
			String mn = resultset.getString(4); 
			System.out.println("middle_name as read from db: "+mn); 
			Assert.assertEquals(middle_name, mn);
			
			String ln = resultset.getString(5); 
			System.out.println("last_name as read from db: "+ln); 
			Assert.assertEquals(last_name, ln);
			
			String db = resultset.getString(6); 
			System.out.println("dob as read from db: "+db); 
			Assert.assertEquals(dob, db);
			
			String add = resultset.getString(7); 
			System.out.println("address as read from db: "+add); 
			Assert.assertEquals(address, add);
			
			String emid = resultset.getString(8); 
			System.out.println("email_id as read from db: "+emid); 
			Assert.assertEquals(email_id, emid);
			
			String ccd = resultset.getString(9); 
			System.out.println("contact_code as read from db: "+ccd); 
			Assert.assertEquals(contact_code, ccd);
			
			String cn = resultset.getString(10); 
			System.out.println("contact_number as read from db: "+cn); 
			Assert.assertEquals(contact_number, cn);
			
			String uid = resultset.getString(11); 
			System.out.println("user_id as read from db: "+uid); 
			Assert.assertEquals(user_id, uid);
			
			String sq = resultset.getString(12); 
			System.out.println("security_question as read from db: "+sq); 
			Assert.assertEquals(security_question, sq);
			
			String sa = resultset.getString(13); 
			System.out.println("security_answer as read from db: "+sa); 
			Assert.assertEquals(security_answer, sa);
			
			String acty = resultset.getString(14); 
			System.out.println("account_type as read from db: "+acty); 
			Assert.assertEquals(account_type, acty);
			
			String st = resultset.getString(15); 
			System.out.println("state as read from db: "+st); 
			Assert.assertEquals(state, st);
			
			String ct = resultset.getString(16); 
			System.out.println("city as read from db: "+ct); 
			Assert.assertEquals(city, ct);
			
			String br = resultset.getString(17); 
			System.out.println("branch as read from db: "+br); 
			Assert.assertEquals(branch, br);
			
			String cid = resultset.getString(18); 
			System.out.println("customer_id as read from db: "+cid); 
			Assert.assertEquals(customer_id, cid);
			
			String un = resultset.getString(19); 
			System.out.println("user_name as read from db: "+un); 
			Assert.assertEquals(user_name, un);
			
			String pwd = resultset.getString(20); 
			System.out.println("password_read as read from db: "+pwd); 
			Assert.assertEquals(password_read, pwd);
			
			String usreg = resultset.getString(21); 
			System.out.println("user_registration as read from db: "+usreg); 
			Assert.assertEquals(user_registration, usreg);
			
		} 
		
		con.close();
	}

	
	public void database_readall_values() throws ClassNotFoundException,SQLException { 
		String dbUrl ="jdbc:sqlserver://PUNITP304691L\\MSSQLSERVER ;databaseName=CAPSTONE_PROJECT;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection con =DriverManager.getConnection(dbUrl);
		Statement stmt = con.createStatement(); 
	
		//-----------------------------------------Select Data--------------------------------------------------------
		
		PreparedStatement readtablequery =con.prepareStatement("Select customer_number, salutation, first_name, middle_name, last_name, dob, address, email_id,contact_code, contact_number, user_id, security_question, security_answer, account_type, state, city, branch, customer_id, user_name, password_read, user_registration from CAPSTONE_PROJECT.dbo.CAPSTONETABLEDUMMYONE"); 

		//readtablequery.setString(1,customer_number);
		
		ResultSet resultsetone=readtablequery.executeQuery();
		int rowCount = 0;
		while ( resultsetone.next() )
		{
		    rowCount++;
		}
		
		System.out.println("Total number of rows in the result set are: " + rowCount);  
		
		customer_number_a=new String[rowCount];
		salutation_a=new String[rowCount];
		first_name_a=new String[rowCount];
		middle_name_a=new String[rowCount];
		last_name_a=new String[rowCount];
		dob_a=new String[rowCount];
		address_a=new String[rowCount];
		email_id_a=new String[rowCount];
		contact_code_a=new String[rowCount];
		contact_number_a=new String[rowCount];
		user_id_a=new String[rowCount];
		security_question_a=new String[rowCount];
		security_answer_a=new String[rowCount];
		user_name_a=new String[rowCount];
		password_read_a=new String[rowCount];
		account_type_a=new String[rowCount];
		state_a=new String[rowCount];
		city_a=new String[rowCount];
		branch_a=new String[rowCount];
		customer_id_a=new String[rowCount];
		regisstatus_a=new String[rowCount];
		

		ResultSet resultsettwo=readtablequery.executeQuery();
		int rowread=0;
		while (resultsettwo.next())
		{ 
			customer_number_a[rowread] = resultsettwo.getString(1); 
			System.out.println("customernumber as read from db: "+customer_number_a[rowread]); 
				
			salutation_a[rowread] = resultsettwo.getString(2); 
			System.out.println("salutation as read from db: "+ salutation_a[rowread]); 
				
			first_name_a[rowread] = resultsettwo.getString(3); 
			System.out.println("first_name as read from db: "+ first_name_a[rowread]); 
					
			middle_name_a[rowread] = resultsettwo.getString(4); 
			System.out.println("middle_name as read from db: "+ middle_name_a[rowread]); 
	
			last_name_a[rowread] = resultsettwo.getString(5); 
			System.out.println("last_name as read from db: "+ last_name_a[rowread]); 
			
			dob_a[rowread] = resultsettwo.getString(6); 
			System.out.println("dob as read from db: "+ dob_a[rowread]); 
		
			address_a[rowread] = resultsettwo.getString(7); 
			System.out.println("address as read from db: "+ address_a[rowread]); 
		
			email_id_a[rowread] = resultsettwo.getString(8); 
			System.out.println("email_id as read from db: "+email_id_a[rowread]); 
			
			contact_code_a[rowread] = resultsettwo.getString(9); 
			System.out.println("contact_code as read from db: "+ contact_code_a[rowread]); 
			
			contact_number_a[rowread] = resultsettwo.getString(10); 
			System.out.println("contact_number as read from db: "+ contact_number_a[rowread]); 
			
			user_id_a[rowread] = resultsettwo.getString(11); 
			System.out.println("user_id as read from db: "+ user_id_a[rowread]); 
	
			security_question_a[rowread] = resultsettwo.getString(12); 
			System.out.println("security_question as read from db: "+ security_question_a[rowread]); 
			
			security_answer_a[rowread] = resultsettwo.getString(13); 
			System.out.println("security_answer as read from db: "+ security_answer_a[rowread]); 
			
			account_type_a[rowread] = resultsettwo.getString(14); 
			System.out.println("account_type as read from db: "+account_type_a[rowread]); 
			
			state_a[rowread] = resultsettwo.getString(15); 
			System.out.println("state as read from db: "+state_a[rowread]); 
		
			city_a[rowread] = resultsettwo.getString(16); 
			System.out.println("city as read from db: "+city_a[rowread]); 

			branch_a[rowread] = resultsettwo.getString(17); 
			System.out.println("branch as read from db: "+branch_a[rowread]); 
			
			customer_id_a[rowread] = resultsettwo.getString(18); 
			System.out.println("customer_id as read from db: "+customer_id_a[rowread]); 
			
			user_name_a[rowread] = resultsettwo.getString(19); 
			System.out.println("user_name as read from db: "+user_name_a[rowread]); 
			
			password_read_a[rowread] = resultsettwo.getString(20); 
			System.out.println("password_read as read from db: "+password_read_a[rowread]); 
			
			regisstatus_a[rowread] = resultsettwo.getString(21); 
			System.out.println("user_registration as read from db: "+regisstatus_a[rowread]); 
			
			rowread++;
			
		} 
		
		//System.out.println("Total number of rows in the result set are: " + totalrecords);
		
		con.close();
	}
	
	 public String[] read_custnumber_value_a() throws IOException { 	
			return customer_number_a;	
		}
	 
	 public String[] read_salutation_value_a() throws IOException { 	
			return salutation_a;	
		}
	 
	 public String[] read_first_name_value_a() throws IOException { 	
			return first_name_a;	
		}
	 
	 public String[] read_middle_name_value_a() throws IOException { 	
			return middle_name_a;	
		}
	 	 
	 public String[] read_last_name_value_a() throws IOException { 	
			return last_name_a;	
		}
	 
	 public String[] read_dob_value_a() throws IOException { 	
			return dob_a;	
		}
	 
	 public String[] read_address_value_a() throws IOException { 	
			return address_a;	
		}
	 
	 public String[] read_email_id_value_a() throws IOException { 	
			return email_id_a;	
		}
	 
	 public String[] read_contact_code_value_a() throws IOException { 	
			return contact_code_a;	
		}
	 
	 public String[] read_contact_number_value_a() throws IOException { 	
			return contact_number_a;	
		}
	 
	 public String[] read_user_id_value_a() throws IOException { 	
			return user_id_a;	
		}
	 
	 public String[] read_account_type_value_a() throws IOException { 	
			return account_type_a;	
		}
	 
	 public String[] read_state_value_a() throws IOException { 	
			return state_a;	
		}
	 
	 public String[] read_city_value_a() throws IOException { 	
			return city_a;	
		}
	 
	 public String[] read_branch_value_a() throws IOException { 	
			return branch_a;	
		}
	 
	 public String[] read_security_question_value_a() throws IOException { 	
			return security_question_a;	
		}
	 
	 public String[] read_security_answer_value_a() throws IOException { 	
			return security_answer_a;	
		}
	 
	 public String[] read_custid_value_a() throws IOException { 	
			return customer_id_a;	
		}
	 
	 public String[] read_user_name_value_a() throws IOException { 	
			return user_name_a;	
		}
	 
	 public String[] read_customer_password_value_() throws IOException { 	
			return password_read_a;	
		}
	 
	 public String[] read_regisstatus_value_a() throws IOException { 	
			return regisstatus_a;	
		}

	   
	
//	 public void captureScreenshot() throws InterruptedException, IOException {
//		 //ChromeOptions options= new ChromeOptions();
//	     
//	        // Add arguments to Chrome Options
//	    
////	        chromeOptions.addArguments("--headless");
////	        chromeOptions.addArguments("start-maximized");
////	        chromeOptions.addArguments("--disable-gpu");
////	        chromeOptions.addArguments("--start-fullscreen");
////	        chromeOptions.addArguments("--disable-extensions");
////	        chromeOptions.addArguments("--disable-popup-blocking");
////	        chromeOptions.addArguments("--disable-notifications");
////	        chromeOptions.addArguments("--window-size=1920,1080");
////	        chromeOptions.addArguments("--no-sandbox");
////	        chromeOptions.addArguments("--dns-prefetch-disable");
////	        chromeOptions.addArguments("enable-automation");
////	        chromeOptions.addArguments("disable-features=NetworkService");
//
//	        File outputFile = ((TakesScreenshot) driverc).getScreenshotAs(OutputType.FILE);
//	        String imageDetails = "D:\\Images";
//	        File screenShot = new File(imageDetails).getAbsoluteFile();
//	        FileUtils.copyFile(outputFile, screenShot);
//	        System.out.println("Screenshot saved: {}" + imageDetails);
//	    }
	
	
		@After
	    public void afterScenario(){
			if (this.driverw==null)
			{
			
			}
			else {
			driverw.close();
	        driverw.quit();
			}
	  }
}
