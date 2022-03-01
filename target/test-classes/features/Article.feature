Feature: Get Articles
  User need to get list of articles

  Scenario Template: Sent request for getting articles

    Given Get Articles "<URL>" Request
    Then Response code is: "<status>"
    Examples:
      | URL          | status |
      |articles.json | 200    |
      |              | 404    |
      |wrong.json    | 404    |


