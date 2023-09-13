Feature: Dependents


  @dependents
  Scenario: Add dependents
    When  user enters valid email and valid Password
    And click on login button
    When user clicks on PIM option
    And user is clicks on add employee button
    And user enters firstname and middlename and lastname
    And user clicks on save button
    When user clicks on dependent button
    And user is clicks on add button
    And Add Dependent text confirmed
    And user enter name
    And user clicks on dropDown and select dependent
    And user select date of birth
    Then user clicks on save button

