  Feature: Capstone_Project_API
  I want to use this feature file to validate API for reading/creating/updating/deleting user details
  
  
    @capstone_tescase_api_1
    Scenario Outline: capstone apitest to read data (GET API)
    Given For getting the user details user provides the authentication details for <userid> <password>
    When Send a GET HTTP request for getting particular <username>
    Then I receive valid GET Response with HTTP response code as 200
    Examples: 
     |  userid      | password |  username | 
     |  postman     | password |  aman     |   
     
   
    @capstone_tescase_api_2
    Scenario Outline: capstone apitest to add data (POST API)
    Given I Set POST api endpoint for creating a new record <authusername> <authpassword> <id> <username> <firstName> <lastName> <email> <password> <phone> 
    When Send a POST HTTP request for creating a new record
    Then I receive valid POST Response with HTTP response code as 200
    Examples: 
     | authusername   | authpassword |  id     | username |  firstName |   lastName | email        |  password | phone      | 
     |  postman       |   password   |  333    | aman     |  test11    |   test22   |test@test.com | test123   | 1234567890 | 
    
    
    @capstone_tescase_api_3
    Scenario Outline: capstone apitest to add data (POST API)
    Given User reads data from excel having <CustomerNumber> 
    Then After reading from excel I Set POST api endpoint for creating a new record
    When Send a POST HTTP request for creating a new record
    Then I receive valid POST Response with HTTP response code as 200
    
    When as per excel input I Send a GET HTTP request for getting provided username
    Then I receive valid GET Response with HTTP response code as 200
    Examples: 
    | CustomerNumber   | 
    |     1            | 
    
    @capstone_tescase_api_4
    Scenario Outline: capstone apitest to update data (PUT API)
    Given I Set POST api endpoint for updating a new record <authusername> <authpassword> <id> <username> <firstName> <lastName> <email> <password> <phone> 
    When Send a PUT HTTP request for updating a record for <username>
    Then I receive valid POST Response with HTTP response code as 200
    Examples: 
     | authusername   | authpassword |  id     | username |  firstName  |   lastName  | email         |  password  | phone      | 
     |  postman       |   password   |  333    | aman     |  test112    |   test223   |test1@test.com | test1234   | 1234567890 | 
       
    
    @capstone_tescase_api_5
    Scenario Outline: capstone apitest to delete data (DELETE API)
    Given For getting the user details user provides the authentication details for <userid> <password>
    When Send a DELETE HTTP request for deleting particular <username>
    Then I receive valid GET Response with HTTP response code as 200
    Examples: 
     |  userid      | password |  username | 
     |  postman     | password |  aman     |   
     
     
    @capstone_tescase_api_6
    Scenario Outline: capstone apitest to read data (GET API)
    Given For getting the pet details user provides the authentication details for <userid> <password>
    When Send a GET HTTP request for particular <petid>
    Then I receive valid GET Response with HTTP response code as 200
    Examples: 
     |  userid     | password |  petid | 
     |  postman    | password |  1     |   
    
    #@capstone_Project_TC1
    #Scenario Outline: User Logins into the Banking Application and request for new account creation
   	#Given User reads all the input data having <CustomerNumber> 
   	#Given I Set POST api endpoint for creating a new record <authusername> <authpassword>
   #When Send a POST HTTP request for creating a new record
    #Then I receive valid POST Response with HTTP response code as 200
   
   # Examples: 
   # | CustomerNumber   | 
   # |     3            | 
 