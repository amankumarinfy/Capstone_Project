package Utilities;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import Pages.capstone_Project_Page;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.TakesScreenshot;

public class hooks {
	capstone_Project_Page page;
	utils utils;
	Response response;
	String responseString;
	String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Im5PbzNaRHJPRFhFSzFqS1doWHNsSFJfS1hFZyJ9.eyJhdWQiOiJhNTViMDA0Zi0zZTkzLTQzNGYtODAwYi00NzZlZGI3NjAyZGIiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNDFjYjU0NzgtMWY4YS00YThlLWEyYjctNThiYmMxMTk4YzUyL3YyLjAiLCJpYXQiOjE2MjY3ODMyMDEsIm5iZiI6MTYyNjc4MzIwMSwiZXhwIjoxNjI2Nzg3MTAxLCJhaW8iOiJFMlpnWVBoL2RQTUZwajkyVHAzVHZuMzRrbjdtSndBPSIsImF6cCI6ImE1NWIwMDRmLTNlOTMtNDM0Zi04MDBiLTQ3NmVkYjc2MDJkYiIsImF6cGFjciI6IjEiLCJvaWQiOiI5ZDE2Y2FlNS0wZGM3LTRjY2YtYjUwMC03NjFiMGUxNWJmMjUiLCJyaCI6IjAuQVRrQWVGVExRWW9mamtxaXQxaTd3Um1NVWs4QVc2V1RQazlEZ0F0SGJ0dDJBdHM1QUFBLiIsInJvbGVzIjpbImRwbW0ud2FyZWhvdXNlLndyaXRlIiwiZHBtbS5pbnZlbnRvcnkucmVhZCIsImRwbW0ub3JkZXJzLndyaXRlIiwiZHBtbS5vcmRlcnMucmVhZCIsImRwbW0uaW52ZW50b3J5LndyaXRlIiwiZHBtbS53YXJlaG91c2UucmVhZCIsImRwbW0udXNlcm1nbXQud3JpdGUiLCJkcG1tLnVzZXJtZ210LnJlYWQiXSwic3ViIjoiOWQxNmNhZTUtMGRjNy00Y2NmLWI1MDAtNzYxYjBlMTViZjI1IiwidGlkIjoiNDFjYjU0NzgtMWY4YS00YThlLWEyYjctNThiYmMxMTk4YzUyIiwidXRpIjoib1cyMFpkSHRTRS1GY1pHQm0wamhBQSIsInZlciI6IjIuMCJ9.A0XLcIUsTbtCeYNiSg5Wtui8-HTLNkpJlR4kKS5uJKbMJTi5J75LA2FMvPuW6hJ4SpDlRVbNo06P-L7HxduQgEVr_xGPDPiQSqrZw4TLuMCkMGsfV1g8n8vmeiWwhg-jYLffHaWaiTLt4v0_TLrfpxwxn--a_cBfGz4HgI_fTj92eEQdu4RDivMZgbiyXwF7jAoNFsp9SpfOg10gOZU4rX_V93mG0BFgb60jgS-cNk9CHLq5nWQwO6HHhTOg20_mEuqtCHhlKD2FmrnHFJA9YQduUTVgJgvFEQ081cG7UpWW4-OJ6RZiJYKmQQL4pE3NvpGjctRFld3m8gphWgXcgg";
	
    EdgeDriver driver = null;
    ChromeDriver driverc = null;
    
    private Scenario takescreenshot;
	
    public EdgeDriver startedgeBrowser_in_essence() throws IOException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.edge.driver", projectPath + "/src/test/resources/Drivers/msedgedriver_124.exe");	
		try {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_124.exe");
			Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");
			Thread.sleep(500);
			driver = new EdgeDriver();
		} catch (Exception e) {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_124.exe");
			Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");   
		}
		try
		{
		driver.navigate().to("http://10.82.180.36/Common/HomePage.aspx");
		}catch (Exception e) {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_124.exe");
			Runtime.getRuntime().exec("taskkill /IM msedge.exe /F");
		}
		driver.manage().window().maximize();
		page = new capstone_Project_Page(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}catch (Exception e) {
			Runtime.getRuntime().exec("taskkill /F /IM msedgedriver_124.exe");
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
			//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			//Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
			Thread.sleep(500);
			driverc = new ChromeDriver(options);
		} catch (Exception e) { 
			//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			//Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
		}

		try
		{
			driverc.navigate().to("http://10.82.180.36/Common/HomePage.aspx");
		}catch (Exception e) {
			//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			//Runtime.getRuntime().exec("taskkill /IM chrome.exe /F");
		}
		driverc.manage().window().maximize();
		page = new capstone_Project_Page(driverc);
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
			String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String lower = "abcdefghijklmnopqrstuvwxyz";
		    String character = "@#$&*";
		    String number = "1234567890";
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
      try {
        	if(this.driverc!=null)
        	{
            byte[] screenshot = ((TakesScreenshot)driverc).getScreenshotAs(OutputType.BYTES);
            takescreenshot.embed(screenshot, "image/png");
        	}
        	else if (this.driverc==null)
        			{}
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
        } catch (ClassCastException cce) {
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
	public void afterScenario() 
	
	{
		
	   driver.close();
	   driver.quit();
	}
	
	
	
}
