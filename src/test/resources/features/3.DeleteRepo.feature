Feature: Create and edit GitHub repo via API

  Scenario Outline: Authorized user is able to edit new repository
    Given User is authorized
    When User creates new GitHub repo <repo name>
    Then User deletes GitHub repo <repo name>

    Examples:
      | repo name |
      | dzik3     |

