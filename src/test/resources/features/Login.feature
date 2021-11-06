Feature: Login functionalities

  @wip
  Scenario Outline: Login with valid credentials
    Given the user should be on login page
    When the user enter valid "<username>" and valid "<password>"
    And the user click Oturum Aç button
    Then the user should land on home page

    Examples:
      | username                    | password   |
      | testeuromessage@outlook.com | Testtest.1 |

  @wip
  Scenario Outline: Login with invalid credentials
    Given the user should be on login page
    When the enter "<username>" and "<password>"
    And the user click Oturum Aç button
    Then the user should not be able login

    Examples:
      | username                    | password   |
      #valid username and invalid password
      | testeuromessage@outlook.com | test       |
      #invalid username and valid password
      | testeuro@outlook.com        | Testtest.1 |
      #invalid username and invalid password
      | testeuro@outlook.com        | test       |
      #blank username and valid passoword
      |                             | Testtest.1 |
      #blank username and invalid password
      |                             | test123    |
      #valid username and blank password
      | testeuromessage@outlook.com |            |
      #invalid username and blank password
      | test@outlook.com            |            |

