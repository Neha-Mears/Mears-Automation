@167057_RLAP_Complete_a_service_user_search-Active/surname
Feature: TC_167057:  RLAP Mears_Complete a service user search - Active/surname

  Background: 
    Given User Navigate to MCMView App

  @167057_RLAP_Complete_a_service_user_search-Active/surname
  Scenario Outline: RLAP Mears_Complete a service user search - Active/surname
    And user enter valid credential "<username>" and "<password>"
    And click on LogIn
    And Click on the Menu expansion button in Home page
    Then select navapp "<serviceName>"
    And user select "Service User Search" from drop down List and navigate to "Service User Search"
    And user select the site for "AASC - Northern Ireland"
    Then user enter the "Wheeler" in "value_1" text box
    Then user click on Find
    Then user Select the service user "wheeler" from the list
    And user click on Ok appointment page

    Examples: 
      | username      | password          | serviceName | address                                                                  |
      | RLAPMearsuser | RLAPMearspassword | Portal      | SSSA10 DA  , DA STREET,  Gloucester,  Gloucestershire,  England,  GL13NN |
