@smoke

Feature: Create new GitHub repo via API

  Scenario Outline: Authorized user is able to create new repository
    Given User is authorized
    Then User creates new GitHub repo <repo name>

    Examples:
      | repo name |
      | dzik      |
