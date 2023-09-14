#Author: neha.sain@mearsgroup.co.uk
#Keywords Summary :
#Feature: List of scenarios.
@166600_AASC_HM_Complete_a_service_user_search_Active/surname_Done
Feature: TC_166600:  AASC HM_Complete a service user search - Active/surname - Done

  Background: 
    Given User Navigate to MCMView App

 @166600_AASC_HM_Complete_a_service_user_search_Active/surname_Done
  Scenario Outline: AASC HM_Add Service User - Port ref - Done
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    Then select navapp "<serviceName>"
    And user select "Service User Search" from drop down List and navigate to "Service User Search"
    Then user enter the "Wheeler" in "SurName" text box
    Then user click on Find
    Then user Select the service user "wheeler" from the list
    And user click on Ok appointment page

    Examples: 
      | username        | password        | serviceName | address |
      | AASC_HMusername | AASC_HMpassword | Portal      |         |
