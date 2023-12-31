#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@97634_166655_AASC_HM_Address_Page_Remove_the_Absconder_flag_from_a_Service_User_Done
Feature: TC_97634:AASC HM_Address Page - Remove the "Absconder" flag from a Service User - Done

  Background: 
    Given User Navigate to MCMView App

  @97634_166655_AASC_HM_Address_Page_Remove_the_"Absconder"_flag_from_a_Service_User_Done
  Scenario Outline: AASC HM_Address Page - Remove the "Absconder" flag from a Service User - Done
     And user enter valid credential "AASC_HMusername" and "AASC_HMpassword"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "Portal"
    And user select "Property Search" from drop down List and navigate to "Property Search"
    When user search "SSSA2, SOME STREET" and "SSSA2 , SOME STREET,  Gloucester,  Gloucestershire,  England,  GL13NN" click on the address details for new version
      And I click on checkbox Include closed task under Task for this Address "service-users-list__checkbox"
     Then Scroll down and click on expansion panel header button for "<username>" with ""
    #### Pre -Request##########################################
    
   And user select "Flag as Absconder" from drop down List and navigate to "Flag as Absconder"
   And user click on "Type of Note" the Drop Down List
   And user select "Covid" from dropdown for "Other"
   Then Click on "Note Documents" expansion button
   And user select "Add Document" from dropdown for "Other"
    Then user click on to upload file to Add Document "<downloadpath>"
    Then user fill details for "Notes" as "Demo test Notes Add Flag as Absconder"
    Then User click on check Box for "Enhanced Confidential Matter"
    Then user click on "Save" button
   Then user click on Cancel button
   Then user click on Close button "Successfully marked as absconded on 23/11/2023"
    And user click on Ok appointment page
    ##############################################################
   Then Scroll down and click on expansion panel header button for "<username>" with ""
    And user select "Remove Absconder Flag" from drop down List and navigate to "Remove Absconder Flag"
     And user click on "Type of Note" the Drop Down List
    And user select "Covid" from dropdown for "Other"
    Then user fill details for "Notes" as "Demo test Remove Absconder Flag"
   Then User click on check Box for "Enhanced Confidential Matter"
    Then user click on "Save" button
    Then user click on Close button "Successfully removed absconded flag"
    And user click on Ok appointment page
    Examples: 
      | username        | password        | serviceName | address                                                                  | availableslot | start_time | end_time | text                                 | updatedtext                              | message                                                | downloadpath                                                |
      | AASC_HMusername | AASC_HMpassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN | 15:00:00      |         12 |       14 | New Appointment Sent to Mears Enable | Updated Appointment Sent to Mears Enable | The appointment was successfully sent to Mears Enable. | C:/Users/neha.sain/OneDrive - Mears Group/Desktop/image.jpg |
