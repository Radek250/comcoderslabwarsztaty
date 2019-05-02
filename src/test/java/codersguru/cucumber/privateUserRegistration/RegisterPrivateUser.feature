Feature: Register user
  Scenario Outline: Register Private User
  Given I open site codersguru
  When I click on register new user
  And I fill private form "<email>" "<name>" "<lastname>" "<pass>" "<city>" "<postcode>" "<street>" "<house>"
  Then User should be succesfully registered
  Examples:
  |email       |name|lastname |pass     |city   |postcode|street    |house|
  |test@test.pl|Jan |Kowalski|testujemy|Wroclaw|50-001  |Trzebnicka |20   |