Feature: DemoQA application Demo test

  Scenario Outline: Test the TextBox in application with scenario
    Given user should click the textbox optiont to navigate
    And user should enter the "<username>","<email>","<permanentaddress>","<currentaddress>" on the textbox
    When user should click on  the sumbit button
    Then user should view the listed details

    Examples: 
      | username | email           | permanentaddress | currentaddress |
      | Arjun    | Arjun@gmail.com | coimbatore       | Coimbatore     |
      | Arun     | Arun@gmail.com  | Chennai          | Chennai        |
