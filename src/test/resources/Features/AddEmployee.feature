Feature: Employee

  @test3
  Scenario: Adding a new Employee

    When  user enters valid email and valid Password
    And click on login button
    When user clicks on PIM option
    And user is clicks on add employee button
    And user enters firstname and middlename and lastname