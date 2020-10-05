@tag
Feature: As a user, I want to login to GitHub site

  Scenario Outline: Attempt to login to GitHub site with invalid credentials
    Given I navigate to GitHub loginpage
    When I enter invalid username "<username>"
    And I enter invalid password "<password>"
    And I click Sign In button
    Then I should fail to login

    Examples: 
      | username        | password    |
      | test@github.com | Invalid$PWD |
