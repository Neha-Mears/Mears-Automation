#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :Login to MCMView
#Feature: List of scenarios.
@TC_149410_RLAP_Mears_User_is_able_to_view_Address_documents_and_download_JPG
Feature: RLAP Mears | User is able to view Address documents and download JPG

  Background: 
    Given User Navigate to MCMView App
    And user enter valid credential "RLAPMearsuser" and "RLAPMearspassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "Test TOWN" and "Test, Test, Test Test, Test TOWN, TE1 1TE" click on the address details for new version

 @TC_149410_RLAP_Mears_User_is_able_to_view_Address_documents_and_download_JPG
  Scenario: RLAP Mears | User is able to view Address documents and download JPG
    Then Click on "Property Details" expansion button
    And user select "View Property" from drop down List and navigate to "Property"
    Then user check the number of documents available next to the address
    Then the user checks the number of documents in the folder Photos and Gas Flue
    And user validate the count displayed next to address is same as number of document in the folder
    Then user click on one of the file and download the file
   
