package StepDefinitions;

public class payload {

	public static String addnewdata(String id, String username, String firstname, String lastname, String email, String Password, String phone) {
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"id\": \""+id+"\",\r\n"
				+ "    \"username\": \""+username+"\",\r\n"
				+ "    \"firstName\": \""+firstname+"\",\r\n"
				+ "    \"lastName\": \""+lastname+"\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n"
				+ "    \"password\": \""+Password+"\",\r\n"
				+ "    \"phone\": \""+phone+"\",\r\n"
				+ "    \"userStatus\": 1\r\n"
				+ "  }\r\n"
				+ "]";
	}
	
	
	public static String updatenewdata(String id, String username, String firstname, String lastname, String email, String Password, String phone) {
		return 
				"  {\r\n"
				+ "    \"id\": \""+id+"\",\r\n"
				+ "    \"username\": \""+username+"\",\r\n"
				+ "    \"firstName\": \""+firstname+"\",\r\n"
				+ "    \"lastName\": \""+lastname+"\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n"
				+ "    \"password\": \""+Password+"\",\r\n"
				+ "    \"phone\": \""+phone+"\",\r\n"
				+ "    \"userStatus\": 1\r\n"
				+ "  }\r\n";	
	}
}