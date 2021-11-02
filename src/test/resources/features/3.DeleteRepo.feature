Feature: Create and edit GitHub repo via API

  Scenario Outline: Authorized user is able to delete existing repository
    Given User is authorized
    Then User deletes GitHub repo <repo name>
    And User deletes GitHub repo <repo name 2>

    Examples:
      | repo name | repo name 2     |
      | dzik      | ksiezycowy-dzik |

