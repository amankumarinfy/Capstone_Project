package Utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import Pages.capstone_Project_Page;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class utils {
	capstone_Project_Page page;
	String salutation,first_name,middle_name,last_name,dob,address,email_id,contact_code,contact_number,user_id,security_question,security_answer,user_name,password_read;
	String account_type, state, city, branch;
	protected WebDriver driver;
	public utils(WebDriver driver) {
		this.driver = driver;
	}
	public utils() {
	}
	
	final Logger logger = LoggerFactory.getLogger(utils.class);
	
	/*----------------------------------------------------------------*/
	 public String user_information_input_file(String filepath,String CustomerNumber) throws IOException {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			System.out.println("Total Number of rows in excel sheet are: "+(rowCount+1));
			DataFormatter formatter = new DataFormatter();
			int rownumber=0;
			for(int i=0;i<rowCount;i++)
			{
				Row customernumber = sheet.getRow(i+1);
				Cell customernumberdata = customernumber.getCell(0);
		        String customernumbervalue=formatter.formatCellValue(customernumberdata);	 
		        
		        if(customernumbervalue.equals(CustomerNumber))
		        {
		        	rownumber=i+1;
		        	break;
		        }
			}
				
			System.out.println("Row number being checked:  "+rownumber);
			
			Row inputdata = sheet.getRow(rownumber);
			Cell salutationcell = inputdata.getCell(1);
	        String salutationvalue=formatter.formatCellValue(salutationcell);
			System.out.println("Row: "+(rownumber+1)+" salutationdata value: "+salutationvalue);
			salutation=salutationvalue;
			
			Cell first_namecell = inputdata.getCell(2);
	        String first_namevalue=formatter.formatCellValue(first_namecell);
			System.out.println("Row: "+(rownumber+1)+" first_namedata value: "+first_namevalue);
			first_name=first_namevalue;
			
			Cell middle_namecell = inputdata.getCell(3);
	        String middle_namevalue=formatter.formatCellValue(middle_namecell);
			System.out.println("Row: "+(rownumber+1)+" middle_namedata value: "+middle_namevalue);
			middle_name=middle_namevalue;
			
			Cell last_namecell = inputdata.getCell(4);
	        String last_namevalue=formatter.formatCellValue(last_namecell);
			System.out.println("Row: "+(rownumber+1)+" last_namedata value: "+last_namevalue);
			last_name=last_namevalue;
					 
			Cell dobcell = inputdata.getCell(5);
	        String dobvalue=formatter.formatCellValue(dobcell);
			System.out.println("Row: "+(rownumber+1)+" dobdata value: "+dobvalue);
			dob=dobvalue;
			
			Cell addresscell = inputdata.getCell(6);
	        String addressvalue=formatter.formatCellValue(addresscell);
			System.out.println("Row: "+(rownumber+1)+" addressdata value: "+addressvalue);
			address=addressvalue;
			
			Cell email_idcell = inputdata.getCell(7);
	        String email_idvalue=formatter.formatCellValue(email_idcell);
			System.out.println("Row: "+(rownumber+1)+" email_iddata value: "+email_idvalue);
			email_id=email_idvalue;
			
			Cell contact_codecell = inputdata.getCell(8);
	        String contact_codevalue=formatter.formatCellValue(contact_codecell);
			System.out.println("Row: "+(rownumber+1)+" contact_codedata value: "+contact_codevalue);
			contact_code=contact_codevalue;
			
			Cell contact_numbercell = inputdata.getCell(9);
	        String contact_numbervalue=formatter.formatCellValue(contact_numbercell);
			System.out.println("Row: "+(rownumber+1)+" contact_numberdata value: "+contact_numbervalue);
			contact_number=contact_numbervalue;
			
			Cell user_idcell = inputdata.getCell(10);
	        String user_idvalue=formatter.formatCellValue(user_idcell);
			System.out.println("Row: "+(rownumber+1)+" user_iddata value: "+user_idvalue);
			user_id=user_idvalue;
			
			Cell security_questioncell = inputdata.getCell(11);
	        String security_questionvalue=formatter.formatCellValue(security_questioncell);
			System.out.println("Row: "+(rownumber+1)+" security_questiondata value: "+security_questionvalue);
			security_question=security_questionvalue;
			
			Cell securyty_answercell = inputdata.getCell(12);
	        String security_answervalue=formatter.formatCellValue(securyty_answercell);
			System.out.println("Row: "+(rownumber+1)+" security_answervalue value: "+security_answervalue);
			security_answer=security_answervalue;	
			
			Cell accounttypecell = inputdata.getCell(13);
	        String accounttypevalue=formatter.formatCellValue(accounttypecell);
			System.out.println("Row: "+(rownumber+1)+" accounttypedata value: "+accounttypevalue);
			account_type=accounttypevalue;	
			
			Cell statecell = inputdata.getCell(14);
	        String statevalue=formatter.formatCellValue(statecell);
			System.out.println("Row: "+(rownumber+1)+" statedata value: "+statevalue);
			state=statevalue;	
			
			Cell citycell = inputdata.getCell(15);
	        String cityvalue=formatter.formatCellValue(citycell);
			System.out.println("Row: "+(rownumber+1)+" citydata value: "+cityvalue);
			city=cityvalue;	
			
			Cell branchcell = inputdata.getCell(16);
	        String branchvalue=formatter.formatCellValue(branchcell);
			System.out.println("Row: "+(rownumber+1)+" branchdata value: "+branchvalue);
			branch=branchvalue;	
			
			workbook.close();	
			return first_name;
			
		}
	 
	 
	 public void store_user_login_information(String filepath, String CustomerNumber, String custId, String user, String username, String password) throws IOException {
			FileInputStream inputStream = new FileInputStream(filepath);
			System.out.println("URL is :"+filepath);
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
//			int rownumber=0;
//			DataFormatter formatter = new DataFormatter();
//			for(int i=0;i<rowCount;i++)
//			{
//				Row customernumber = sheet.getRow(i+1);
//				Cell customernumberdata = customernumber.getCell(0);
//		        String customernumbervalue=formatter.formatCellValue(customernumberdata);	 
//		        
//		        if(customernumbervalue.equals(CustomerNumber))
//		        {
//		        	rownumber=i+1;
//		        	break;
//		        }
//			}
			
			//int newrowcount=rowCount+1;
			int newrowcount=rowCount+1;
			String rowCountstr=String.valueOf(newrowcount);

			System.out.println("S.No to be stored: "+ rowCountstr);
			System.out.println("Cust Id to be stored: "+ custId);
			System.out.println("User to be stored: "+ user);
			System.out.println("Username to be stored: "+ username);
		    System.out.println("Password to be stored: : "+ password);
			
		    XSSFRow row = sheet.getRow(newrowcount);
		    row = sheet.createRow(newrowcount);
		    row.createCell(0).setCellValue(rowCountstr);
		    row.createCell(1).setCellValue(custId);
		    row.createCell(2).setCellValue(user);
			row.createCell(3).setCellValue(username);
			row.createCell(4).setCellValue(password);
			
			FileOutputStream outputStream = new FileOutputStream(filepath);
			wb.write(outputStream);
			wb.close();
		}
	 
	 public void store_user_login_information_user_input_file(String filepath, String CustomerNumber ,String custId, String username, String password) throws IOException {
			FileInputStream inputStream = new FileInputStream(filepath);
			System.out.println("URL is :"+filepath);
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			
		
			int rownumber=0;
			DataFormatter formatter = new DataFormatter();
			for(int i=0;i<rowCount;i++)
			{
				Row customernumber = sheet.getRow(i+1);
				Cell customernumberdata = customernumber.getCell(0);
		        String customernumbervalue=formatter.formatCellValue(customernumberdata);	 
		        
		        if(customernumbervalue.equals(CustomerNumber))
		        {
		        	rownumber=i+1;
		        	break;
		        }
			}

			//System.out.println("S.No to be stored: "+ rowCountstr);
			System.out.println("Cust Id to be stored: "+ custId);
			System.out.println("Username to be stored: "+ username);
		    System.out.println("Password to be stored: : "+ password);
			
		    XSSFRow row = sheet.getRow(rownumber);
		    //row = sheet.createRow(rowCount);
		    //row.createCell(0).setCellValue(rowCountstr);
		    row.createCell(17).setCellValue(custId);
			row.createCell(18).setCellValue(username);
			row.createCell(19).setCellValue(password);
			
			FileOutputStream outputStream = new FileOutputStream(filepath);
			wb.write(outputStream);
			wb.close();
		}
	 
	 public String read_salutation_value() throws IOException { 	
			return salutation;	
		}
	 
	 public String read_first_name_value() throws IOException { 	
			return first_name;	
		}
	 
	 public String read_middle_name_value() throws IOException { 	
			return middle_name;	
		}
	 	 
	 public String read_last_name_value() throws IOException { 	
			return last_name;	
		}
	 
	 public String read_dob_value() throws IOException { 	
			return dob;	
		}
	 
	 public String read_address_value() throws IOException { 	
			return address;	
		}
	 
	 public String read_email_id_value() throws IOException { 	
			return email_id;	
		}
	 
	 public String read_contact_code_value() throws IOException { 	
			return contact_code;	
		}
	 
	 public String read_contact_number_value() throws IOException { 	
			return contact_number;	
		}
	 
	 public String read_user_id_value() throws IOException { 	
			return user_id;	
		}
	 

	 public String read_account_type_value() throws IOException { 	
			return account_type;	
		}
	 
	 public String read_state_value() throws IOException { 	
			return state;	
		}
	 
	 public String read_city_value() throws IOException { 	
			return city;	
		}
	 
	 public String read_branch_value() throws IOException { 	
			return branch;	
		}
	 
	 public String read_security_question_value() throws IOException { 	
			return security_question;	
		}
	 
	 public String read_security_answer_value() throws IOException { 	
			return security_answer;	
		}
	 
	 
	 
	 
	 public String user_information_input_file_read_login(String filepath,String CustomerID) throws IOException {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			System.out.println("Total Number of rows in excel sheet are: "+(rowCount+1));
			DataFormatter formatter = new DataFormatter();
			int rownumber=0;
			for(int i=0;i<rowCount;i++)
			{
				Row customernumber = sheet.getRow(i+1);
				Cell customernumberdata = customernumber.getCell(17);
		        String customernumbervalue=formatter.formatCellValue(customernumberdata);	 
		        
		        if(customernumbervalue.equals(CustomerID))
		        {
		        	rownumber=i+1;
		        	break;
		        }
		        else
		        
		        {
		        	System.out.println("CUSTOMER ID NOT FOUND!!!!!!!!");
		        }
		        
			}
				
			System.out.println("Row number being checked:  "+rownumber);
			
			Row inputdata = sheet.getRow(rownumber);
			Cell salutationcell = inputdata.getCell(1);
	        String salutationvalue=formatter.formatCellValue(salutationcell);
			System.out.println("Row: "+(rownumber+1)+" salutationdata value: "+salutationvalue);
			salutation=salutationvalue;
			
			Cell first_namecell = inputdata.getCell(2);
	        String first_namevalue=formatter.formatCellValue(first_namecell);
			System.out.println("Row: "+(rownumber+1)+" first_namedata value: "+first_namevalue);
			first_name=first_namevalue;
			
			Cell middle_namecell = inputdata.getCell(3);
	        String middle_namevalue=formatter.formatCellValue(middle_namecell);
			System.out.println("Row: "+(rownumber+1)+" middle_namedata value: "+middle_namevalue);
			middle_name=middle_namevalue;
			
			Cell last_namecell = inputdata.getCell(4);
	        String last_namevalue=formatter.formatCellValue(last_namecell);
			System.out.println("Row: "+(rownumber+1)+" last_namedata value: "+last_namevalue);
			last_name=last_namevalue;
					 
			Cell dobcell = inputdata.getCell(5);
	        String dobvalue=formatter.formatCellValue(dobcell);
			System.out.println("Row: "+(rownumber+1)+" dobdata value: "+dobvalue);
			dob=dobvalue;
			
			Cell addresscell = inputdata.getCell(6);
	        String addressvalue=formatter.formatCellValue(addresscell);
			System.out.println("Row: "+(rownumber+1)+" addressdata value: "+addressvalue);
			address=addressvalue;
			
			Cell email_idcell = inputdata.getCell(7);
	        String email_idvalue=formatter.formatCellValue(email_idcell);
			System.out.println("Row: "+(rownumber+1)+" email_iddata value: "+email_idvalue);
			email_id=email_idvalue;
			
			Cell contact_codecell = inputdata.getCell(8);
	        String contact_codevalue=formatter.formatCellValue(contact_codecell);
			System.out.println("Row: "+(rownumber+1)+" contact_codedata value: "+contact_codevalue);
			contact_code=contact_codevalue;
			
			Cell contact_numbercell = inputdata.getCell(9);
	        String contact_numbervalue=formatter.formatCellValue(contact_numbercell);
			System.out.println("Row: "+(rownumber+1)+" contact_numberdata value: "+contact_numbervalue);
			contact_number=contact_numbervalue;
			
			Cell user_idcell = inputdata.getCell(10);
	        String user_idvalue=formatter.formatCellValue(user_idcell);
			System.out.println("Row: "+(rownumber+1)+" user_iddata value: "+user_idvalue);
			user_id=user_idvalue;
			
			Cell security_questioncell = inputdata.getCell(11);
	        String security_questionvalue=formatter.formatCellValue(security_questioncell);
			System.out.println("Row: "+(rownumber+1)+" security_questiondata value: "+security_questionvalue);
			security_question=security_questionvalue;
			
			Cell security_answercell = inputdata.getCell(12);
	        String security_answervalue=formatter.formatCellValue(security_answercell);
			System.out.println("Row: "+(rownumber+1)+" security_answerdata value: "+security_answervalue);
			security_answer=security_answervalue;	
			
			Cell user_namecell = inputdata.getCell(18);
	        String user_namevalue=formatter.formatCellValue(user_namecell);
			System.out.println("Row: "+(rownumber+1)+" user_namevalue value: "+user_namevalue);
			user_name=user_namevalue;	
			
			Cell password_cell = inputdata.getCell(19);
	        String password_value=formatter.formatCellValue(password_cell);
			System.out.println("Row: "+(rownumber+1)+" password_value value: "+password_value);
			password_read=password_value;	
			
			
			Cell accounttypecell = inputdata.getCell(13);
	        String accounttypevalue=formatter.formatCellValue(accounttypecell);
			System.out.println("Row: "+(rownumber+1)+" accounttypedata value: "+accounttypevalue);
			account_type=accounttypevalue;	
			
			Cell statecell = inputdata.getCell(14);
	        String statevalue=formatter.formatCellValue(statecell);
			System.out.println("Row: "+(rownumber+1)+" statedata value: "+statevalue);
			state=statevalue;	
			
			Cell citycell = inputdata.getCell(15);
	        String cityvalue=formatter.formatCellValue(citycell);
			System.out.println("Row: "+(rownumber+1)+" citydata value: "+cityvalue);
			city=cityvalue;	
			
			Cell branchcell = inputdata.getCell(16);
	        String branchvalue=formatter.formatCellValue(branchcell);
			System.out.println("Row: "+(rownumber+1)+" branchdata value: "+branchvalue);
			branch=branchvalue;	
			
			workbook.close();	
			return user_name;
			
		}
	 
	 public String read_user_name_value() throws IOException { 	
			return user_name;	
		}
	 
	 public String read_customer_password_value() throws IOException { 	
			return password_read;	
		}
	 
	 
	 public String testbasiauthentication(String userid, String password) {
		 //technicaluserid="test";
		 //String technicalpassword="abc123";
		 
		 Response response=given().auth().basic(userid, password).get("https://postman-echo.com/basic-auth");
//		 	Response response = given().auth().preemptive()
//				.basic(technicaluserid, technicalpassword)
//				.formParam("grant_type", "implicit")
//				.formParam("scope", "api://"+technicaluserid+"/.write").when()
//				.post("https://petstore.swagger.io/oauth/authorize/v2/token");
//		 	JsonPath json = response.jsonPath();
//		 	String accessToken = json.get("access_token").toString();
	
	       String rbdy = response.asString();
	       
	       JsonPath json = response.jsonPath();
			String status = json.getString("authenticated");
			 System.out.println("Data from the GET API- "+status);
	       System.out.println("Data from the GET API- "+rbdy);
	   	   //Assert.assertEquals("true", rbdy);
		 	return rbdy;
	}
    /*----------------------------------------------------------------*/ 	 	
}
