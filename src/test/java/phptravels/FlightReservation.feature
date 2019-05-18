Feature: Reserve a flight
  Scenario Outline: Reserve a new flight
    Given I open site phptravels.net
    When I choose flight in menu
    And I fill out form to find the flight from "Warsaw" to "New York" on "24.01.2020" and come back on "31.01.2020"
    And I choose the flight
    And I fill out contact data form by "<name>" "<lastname>" "<email>" "<mobile>" "<address>" "<country>"
    Then Flight should be reserved
    Examples:
    |name|lastname|email       |mobile   |address      |country|
    |Jan |Kowalski|test@test.pl|666555444|Wroclawska 20|Poland |