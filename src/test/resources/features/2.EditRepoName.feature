Feature: Create and edit GitHub repo via API

  Scenario Outline: Authorized user is able to edit new repository
    Given User is authorized
    When User creates new GitHub repo <repo name>
    Then User edits GitHub repo name from <repo name> to <new repo name>

    Examples:
      | repo name | new repo name   |
      | dzik2     | ksiezycowy-dzik |

