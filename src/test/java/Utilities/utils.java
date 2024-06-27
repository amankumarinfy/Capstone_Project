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
import Pages.capstone_Project_UI_EXCEL_DB_Page;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class utils {
	capstone_Project_UI_EXCEL_DB_Page page;
	String read_customer_id_value, salutation,first_name,middle_name,last_name,dob,address,email_id,contact_code,contact_number,user_id,security_question,security_answer,user_name,password_read;
	String customer_id, user_registration;
	String[] salutation_a,first_name_a,middle_name_a,last_name_a,dob_a,address_a,email_id_a,contact_code_a,contact_number_a,user_id_a,security_question_a,security_answer_a,user_name_a,password_read_a;
	String[] customer_number_a, customer_id_a;
	
	String account_type, state, city, branch;
	String[] account_type_a, state_a, city_a, branch_a, regisstatus_a;
	
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
	 
	 public String user_information_input_file_database(String filepath,String CustomerNumber) throws IOException {
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
			
			
			Row customer_iddata = sheet.getRow(rownumber);
			Cell customer_idcell = customer_iddata.getCell(0);
	        String customer_idvalue=formatter.formatCellValue(customer_idcell);
			System.out.println("Row: "+(rownumber+1)+" customer_iddata value: "+customer_idvalue);
			read_customer_id_value =customer_idvalue;
			
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
			
			Cell customeridcell = inputdata.getCell(17);
	        String customeridvalue=formatter.formatCellValue(customeridcell);
			System.out.println("Row: "+(rownumber+1)+" branchdata value: "+customeridvalue);
			customer_id=customeridvalue;	
			// user_registration;
			
			Cell user_namecell = inputdata.getCell(18);
	        String user_namevalue=formatter.formatCellValue(user_namecell);
			System.out.println("Row: "+(rownumber+1)+" user_namevalue value: "+user_namevalue);
			user_name=user_namevalue;	
			
			Cell password_cell = inputdata.getCell(19);
	        String password_value=formatter.formatCellValue(password_cell);
			System.out.println("Row: "+(rownumber+1)+" password_value value: "+password_value);
			password_read=password_value;	
			
			Cell regisstatuscell = inputdata.getCell(20);
	        String regisstatusvalue=formatter.formatCellValue(regisstatuscell);
			System.out.println("Row: "+(rownumber+1)+" regisstatus value: "+regisstatusvalue);
			user_registration=regisstatusvalue;
			
			
			workbook.close();	
			return first_name;
			
		}
	 	 
	 public String[] user_information_input_file_all_data(String filepath) throws IOException {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			
			
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
			
			System.out.println("Total Number of rows in excel sheet are: "+(rowCount+1));
			DataFormatter formatter = new DataFormatter();
			int rownumber=1;
			for(int i=0;i<rowCount;i++)
			{
				
			System.out.println("Row number being checked:  "+(i+1));
			
			
			Row cndata = sheet.getRow(i+1);
			Cell cncell = cndata.getCell(0);
	        String cnvalue=formatter.formatCellValue(cncell);
			System.out.println("Row: "+(i+1)+" cndata value: "+cnvalue);
			customer_number_a[i]=cnvalue;
			
			Row inputdata = sheet.getRow(i+1);
			Cell salutationcell = inputdata.getCell(1);
	        String salutationvalue=formatter.formatCellValue(salutationcell);
			System.out.println("Row: "+(i+1)+" salutationdata value: "+salutationvalue);
			salutation_a[i]=salutationvalue;
			
			Cell first_namecell = inputdata.getCell(2);
	        String first_namevalue=formatter.formatCellValue(first_namecell);
			System.out.println("Row: "+(i+1)+" first_namedata value: "+first_namevalue);
			first_name_a[i]=first_namevalue;
			
			Cell middle_namecell = inputdata.getCell(3);
	        String middle_namevalue=formatter.formatCellValue(middle_namecell);
			System.out.println("Row: "+(i+1)+" middle_namedata value: "+middle_namevalue);
			middle_name_a[i]=middle_namevalue;
			
			Cell last_namecell = inputdata.getCell(4);
	        String last_namevalue=formatter.formatCellValue(last_namecell);
			System.out.println("Row: "+(i+1)+" last_namedata value: "+last_namevalue);
			last_name_a[i]=last_namevalue;
					 
			Cell dobcell = inputdata.getCell(5);
	        String dobvalue=formatter.formatCellValue(dobcell);
			System.out.println("Row: "+(i+1)+" dobdata value: "+dobvalue);
			dob_a[i]=dobvalue;
			
			Cell addresscell = inputdata.getCell(6);
	        String addressvalue=formatter.formatCellValue(addresscell);
			System.out.println("Row: "+(rownumber+1)+" addressdata value: "+addressvalue);
			address_a[i]=addressvalue;
			
			Cell email_idcell = inputdata.getCell(7);
	        String email_idvalue=formatter.formatCellValue(email_idcell);
			System.out.println("Row: "+(i+1)+" email_iddata value: "+email_idvalue);
			email_id_a[i]=email_idvalue;
			
			Cell contact_codecell = inputdata.getCell(8);
	        String contact_codevalue=formatter.formatCellValue(contact_codecell);
			System.out.println("Row: "+(rownumber+1)+" contact_codedata value: "+contact_codevalue);
			contact_code_a[i]=contact_codevalue;
			
			Cell contact_numbercell = inputdata.getCell(9);
	        String contact_numbervalue=formatter.formatCellValue(contact_numbercell);
			System.out.println("Row: "+(i+1)+" contact_numberdata value: "+contact_numbervalue);
			contact_number_a[i]=contact_numbervalue;
			
			Cell user_idcell = inputdata.getCell(10);
	        String user_idvalue=formatter.formatCellValue(user_idcell);
			System.out.println("Row: "+(i+1)+" user_iddata value: "+user_idvalue);
			user_id_a[i]=user_idvalue;
			
			Cell security_questioncell = inputdata.getCell(11);
	        String security_questionvalue=formatter.formatCellValue(security_questioncell);
			System.out.println("Row: "+(i+1)+" security_questiondata value: "+security_questionvalue);
			security_question_a[i]=security_questionvalue;
			
			Cell securyty_answercell = inputdata.getCell(12);
	        String security_answervalue=formatter.formatCellValue(securyty_answercell);
			System.out.println("Row: "+(i+1)+" security_answervalue value: "+security_answervalue);
			security_answer_a[i]=security_answervalue;	
			
			Cell accounttypecell = inputdata.getCell(13);
	        String accounttypevalue=formatter.formatCellValue(accounttypecell);
			System.out.println("Row: "+(i+1)+" accounttypedata value: "+accounttypevalue);
			account_type_a[i]=accounttypevalue;	
			
			Cell statecell = inputdata.getCell(14);
	        String statevalue=formatter.formatCellValue(statecell);
			System.out.println("Row: "+(i+1)+" statedata value: "+statevalue);
			state_a[i]=statevalue;	
			
			Cell citycell = inputdata.getCell(15);
	        String cityvalue=formatter.formatCellValue(citycell);
			System.out.println("Row: "+(i+1)+" citydata value: "+cityvalue);
			city_a[i]=cityvalue;	
			
			Cell branchcell = inputdata.getCell(16);
	        String branchvalue=formatter.formatCellValue(branchcell);
			System.out.println("Row: "+(i+1)+" branchdata value: "+branchvalue);
			branch_a[i]=branchvalue;
			
			Cell cidcell = inputdata.getCell(17);
	        String cidvalue=formatter.formatCellValue(cidcell);
			System.out.println("Row: "+(i+1)+" cidvalue value: "+cidvalue);
			customer_id_a[i]=cidvalue;
			
			Cell user_namecell = inputdata.getCell(18);
	        String user_namevalue=formatter.formatCellValue(user_namecell);
			System.out.println("Row: "+(rownumber+1)+" user_namevalue value: "+user_namevalue);
			user_name_a[i]=user_namevalue;	
			
			Cell password_cell = inputdata.getCell(19);
	        String password_value=formatter.formatCellValue(password_cell);
			System.out.println("Row: "+(rownumber+1)+" password_value value: "+password_value);
			password_read_a[i]=password_value;	
			
			Cell regisstatuscell = inputdata.getCell(20);
	        String regisstatusvalue=formatter.formatCellValue(regisstatuscell);
			System.out.println("Row: "+(i+1)+" regisstatus value: "+regisstatusvalue);
			regisstatus_a[i]=regisstatusvalue;

			}
			workbook.close();	
			return first_name_a;		
		}
	 
	  
	 public void store_user_login_information(String filepath, String CustomerNumber, String custId, String user, String username, String password, String regisstatus) throws IOException {
			FileInputStream inputStream = new FileInputStream(filepath);
			System.out.println("URL is :"+filepath);
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
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
			row.createCell(5).setCellValue(regisstatus);
			FileOutputStream outputStream = new FileOutputStream(filepath);
			wb.write(outputStream);
			wb.close();
		}
	 
	 public void store_user_login_information_user_input_file(String filepath, String CustomerNumber ,String custId, String username, String password, String regisstatus) throws IOException {
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

			System.out.println("Cust Id to be stored: "+ custId);
			System.out.println("Username to be stored: "+ username);
		    System.out.println("Password to be stored: : "+ password);
			
		    XSSFRow row = sheet.getRow(rownumber);
		    row.createCell(17).setCellValue(custId);
			row.createCell(18).setCellValue(username);
			row.createCell(19).setCellValue(password);
			row.createCell(20).setCellValue(regisstatus);
			
			FileOutputStream outputStream = new FileOutputStream(filepath);
			wb.write(outputStream);
			wb.close();
		}
	 
	 
	 /*--*/
	 
	 public void store_user_login_information_all(String filepath, String CustomerNumber, String custId, String user, String username, String password, String registatus) throws IOException {
			FileInputStream inputStream = new FileInputStream(filepath);
			System.out.println("URL is :"+filepath);
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();

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
			row.createCell(5).setCellValue(registatus);
			FileOutputStream outputStream = new FileOutputStream(filepath);
			wb.write(outputStream);
			wb.close();
		}
	 
	 public void store_user_login_information_user_input_file_all(String filepath, String CustomerNumber ,String custId, String username, String password, String regisstatus) throws IOException {
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

			System.out.println("Cust Id to be stored: "+ custId);
			System.out.println("Username to be stored: "+ username);
		    System.out.println("Password to be stored: : "+ password);
			
		    XSSFRow row = sheet.getRow(rownumber);
		    row.createCell(17).setCellValue(custId);
			row.createCell(18).setCellValue(username);
			row.createCell(19).setCellValue(password);
			row.createCell(20).setCellValue(regisstatus);
			
			FileOutputStream outputStream = new FileOutputStream(filepath);
			wb.write(outputStream);
			wb.close();
		}
	 
	 public String read_customer_id_value_() throws IOException { 	
			return read_customer_id_value;	
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
	 
	 public String[] read_regisstatus_value_a() throws IOException { 	
			return regisstatus_a;	
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
	 
	 
	 
	 public String user_information_input_file_read_login_API(String filepath,String CustomerID) throws IOException {
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
			
			Row customer_iddata = sheet.getRow(rownumber);
			Cell customer_idcell = customer_iddata.getCell(0);
	        String customer_idvalue=formatter.formatCellValue(customer_idcell);
			System.out.println("Row: "+(rownumber+1)+" customer_iddata value: "+customer_idvalue);
			read_customer_id_value =customer_idvalue;

			
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
	 
	 public String read_cust_id_value() throws IOException { 	
			return customer_id;	
		}
	 
	 public String read_user_regis_status() throws IOException { 	
			return user_registration;	
		}
	 	 
	 public String testbasiauthentication(String userid, String password) {
		 Response response=given().auth().basic(userid, password).get("https://postman-echo.com/basic-auth");
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
