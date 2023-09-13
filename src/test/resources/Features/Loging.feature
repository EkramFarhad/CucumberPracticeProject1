Feature: Login Functionalities


  @test1
  Scenario: Valid Admin login

    When  user enters valid email and valid Password
    And click on login button
    Then user is logged in successfully


  @test2
  Scenario: Valid Admin login

    When  user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully

  @ScenarioOutline
    #Paramitirazation / Data Driven
  Scenario Outline: Login with multiple credentials using scenario

    When  user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully

    Examples:
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
     # | Ekram    | Hum@nhrm123 |
     # | admin    | abcd1234567 |

    #data Table
  @dataTable
  Scenario: Login with credentials using dataTable
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
    #  | Ekram    | Hum@nhrm123 |
     # | admin    | abcd1234567 |
