Feature: Searching the employee

  Background:
    When  user enters valid email and valid Password
    And click on login button
    When user clicks on PIM option


  @test4
  Scenario: Search employee by Id
    When user enters valid employee id
    And  Clicks on search button
    And  user see employee information is displayed

  @test5
  Scenario: Search Employee by Job Title
    When user select Job Title
    And  Clicks on search button
    And  user see employee information is displayed


  #Background: This is used to define all the common steps that multiple
  #            scenarios have in the same feature file, till the time flow is not broken