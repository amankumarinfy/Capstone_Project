Feature: Capstone_Project
  I want to use this feature file to validate banking application (In Essence Bank)

   @capstone_Project_TC1
   Scenario Outline: User Logins into the Banking Application and request for new account creation
   Given User reads all the input data having <CustomerNumber> 
   Then User launches the In Essence banking application
   And User clicks on Login button to navigate to Login screen 
   And User clicks on Sign Up button to navigate to Registration screen
   Then User fills all the <CustomerNumber> information i.e Salutation, First Name, Middle Name, Last Name, DOB, Address, Email Id, Contact Code and Contact Number  
   Then User logs in application with generated credentials
   #And User set and validates the User Id
   #And User sets the Login password
   #And User sets the transaction password
   #And User sets the security question 
   #And User sets the security answer
   
   Examples: 
    | CustomerNumber   | 
    |     3            | 
    
    
   @capstone_Project_TC2
   Scenario Outline: User Logins into the Banking Application and request for new account creation
   Given User launches the In Essence banking application
   And User clicks on Login button to navigate to Login screen
   Then <customerid> login into the In Essence application
   Then request for new account access 
   And User fills Account type information
   And User fills State information
   And User fills City information
   And User fills Branch information
   And User uploads all required proofs
   And User clicks on Submit button to submit all the information
   #And User validates the Account Request status screen to check the account access request
   #And User selects the status <type> 
   #And User validates that account request id is visible and is having status as pending
   
   Examples: 
    | customerid  | type |
    | 20482       |      |
       
    @capstometescaseapi_3
    Scenario Outline: capstone apitest to read data (GET API)
    Given For getting the pet details user provides the authentication details for <userid> <password>
    When Send a GET HTTP request for particular <petid>
    Then I receive valid GET Response with HTTP response code as 200
   
    Examples: 
     |  userid     | password |  petid | 
     |  postman    | password |  2    |   
          
    @capstometescaseapi_4
    Scenario Outline: capstone apitest to read data (GET API)
    Given For getting the user details user provides the authentication details for <userid> <password>
    When Send a GET HTTP request for getting particular <username>
    Then I receive valid GET Response with HTTP response code as 200
   
    Examples: 
     |  userid      | password |  username | 
     |  postman     | password |  aman     |   
     
    @capstometescaseapi_5
    Scenario Outline: capstone apitest to add data (POST API)
    Given I Set POST api endpoint for creating a new record <authusername> <authpassword> <id> <username> <firstName> <lastName> <email> <password> <phone> 
    When Send a POST HTTP request for creating a new record
    Then I receive valid POST Response with HTTP response code as 200
   
    Examples: 
     | authusername   | authpassword |  id     | username |  firstName |   lastName | email        |  password | phone      | 
     |  postman       |   password   |  333    | aman     |  test11    |   test22   |test@test.com | test123   | 1234567890 | 
    
    
    @capstometescaseapi_6
    Scenario Outline: capstone apitest to update data (PUT API)
    Given I Set POST api endpoint for updating a new record <authusername> <authpassword> <id> <username> <firstName> <lastName> <email> <password> <phone> 
    When Send a PUT HTTP request for updating a record for <username>
    Then I receive valid POST Response with HTTP response code as 200
   
    Examples: 
     | authusername   | authpassword |  id     | username |  firstName  |   lastName  | email         |  password  | phone      | 
     |  postman       |   password   |  333    | aman     |  test112    |   test223   |test1@test.com | test1234   | 1234567890 | 
    
    
    @capstometescaseapi_7
    Scenario Outline: capstone apitest to read data (DELETE API)
    Given For getting the user details user provides the authentication details for <userid> <password>
    When Send a DELETE HTTP request for deleting particular <username>
    Then I receive valid GET Response with HTTP response code as 200
   
    Examples: 
     |  userid      | password |  username | 
     |  postman     | password |  aman     |   
     
     
    #@capstone_Project_TC1
    #Scenario Outline: User Logins into the Banking Application and request for new account creation
   	#Given User reads all the input data having <CustomerNumber> 
   	#Given I Set POST api endpoint for creating a new record <authusername> <authpassword>
   #When Send a POST HTTP request for creating a new record
    #Then I receive valid POST Response with HTTP response code as 200
   
   # Examples: 
   # | CustomerNumber   | 
   # |     3            | 
    
    @capstone_database_validation
  Scenario: validate dtabase values
    Given User read the database value