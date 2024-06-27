Feature: Capstone_Project_UI
  I want to use this feature file to validate banking application (In Essence Bank)
 
   @capstone_Project_TC1
   Scenario: User Logins into the Banking Application and request for new account creation
   Given User reads all the customer input data from excel sheet
   Then User launches the In Essence banking application
   And User clicks on Login button to navigate to Login screen 
   And User clicks on Sign Up button to navigate to Registration screen
   Then User does the registration of each customer and stores the login details in the customer info sheet
   
   @capstone_Project_TC2
   Scenario: User Logins into the Banking Application and request for new account creation
   Given User reads all the customer input data from excel sheet
   Then User launches the In Essence banking application
   And User clicks on Login button to navigate to Login screen 
   And User clicks on Sign Up button to navigate to Registration screen
   Then User completes the registration and then saves all the information in excel sheeta and database
   
   @capstone_Project_TC3
   Scenario: User validates the negative test case for existing users
   Given User reads all the customer input data from database
   Then User launches the In Essence banking application
   And User clicks on Login button to navigate to Login screen 
   And User clicks on Sign Up button to navigate to Registration screen
   Then User validates the negative test case for existing users

   @capstone_Project_TC4
   Scenario Outline: User Logins into the Banking Application and request for new account creation
   Given User reads all the input data having <CustomerNumber> 
   Then User launches the In Essence banking application
   And User clicks on Login button to navigate to Login screen 
   And User clicks on Sign Up button to navigate to Registration screen
   Then User sets Salutation
   Then User sets First Name
   Then User sets Middle Name 
   Then User sets Last Name 
   Then User sets DOB
   Then User sets Address
   Then User sets Email Id
   Then User sets Contact Code 
   Then User sets Contact Number 
   Then User sets UserId
   And User validates available UserId and accoridingly sets Login and Transaction passwords
   Then User sets Security Question
   Then User sets Security Answer 
   Then User clicks on Submit button to submit all details for <CustomerNumber>
   Then User logs in application with generated credentials
   Examples: 
    | CustomerNumber   | 
    |     1            | 
    |     2            |
   
     
   @capstone_Project_TC5
   Scenario Outline: User Logins into the Banking Application and request for new account creation
   Given User reads all the input data having <CustomerNumber> 
   Then User launches the In Essence banking application
   And User clicks on Login button to navigate to Login screen 
   And User clicks on Sign Up button to navigate to Registration screen
   Then User sets Salutation
   Then User sets First Name
   Then User sets Middle Name 
   Then User sets Last Name 
   Then User sets DOB
   Then User sets Address
   Then User sets Email Id
   Then User sets Contact Code 
   Then User sets Contact Number 
   Then User sets UserId
   And User validates available UserId and accoridingly sets Login and Transaction passwords
   Then User sets Security Question
   Then User sets Security Answer 
   Then User clicks on Submit button to submit all details for <CustomerNumber>
   Then User logs in application with generated credentials
   Then request for new account access 
   And User fills Account type information
   And User fills State information
   And User fills City information
   And User fills Branch information
   And User uploads all required proofs
   And User clicks on Submit button to submit all the information
   And User validates the Account Request status screen to check the account access request
   And User selects request status as Pending
   And User validates new request id is visible with all details
   Examples: 
    | CustomerNumber   | 
    |     1            | 
 
   
   @capstone_Project_TC6
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
   And User validates the Account Request status screen to check the account access request
   And User selects the status <type> 
   And User validates that request id is visible and is having status as <requesttype>
   Examples: 
    | customerid  | type        | requesttype |
    | 20527       | Pending     | Open        |
         
   @capstone_Project_TCdum
   Scenario Outline: User Logins into the Banking Application and request for new account creation
   Given User launches the In Essence banking application
   And User clicks on Login button to navigate to Login screen
   Then <customerid> login into the In Essence application
   
   Examples: 
    | customerid  | type        | requesttype |
    | 20527       | Pending     | Open        | 
 
    @capstone_database_validation_a
    Scenario: validate database values
    Given User read the database value
    
    @capstone_database_validation_b
    Scenario Outline: create database table
    Given User create the database table with name <databasename>
     Examples: 
    | databasename          |
    | CAPSTONETABLEDUMMYONE |
    
    @capstone_database_validation_c
    Scenario Outline: insert values into database table
    Given User reads all the input data to be saved in databse having <CustomerNumber> 
    #Then User create the database table with name <databasename>
    And User inserts all the values into the database <databasename>
    Then User reads value from database back and verifies that inserted data is matched with the provide input data into the database <databasename>
    Examples: 
    | CustomerNumber   | databasename          |
    |     3            | CAPSTONETABLEDUMMYONE |
    
   @capstone_Project_extui
   Scenario: User Logins into the Banking Application and request for new account creation
   Given User launches external google ui website
   When User provides username and password