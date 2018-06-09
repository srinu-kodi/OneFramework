Feature: Copa Airlines homepage feature validation

  @android
  Scenario: Copa Airlines Home option scenario
    Given User chooses "Home" option

  @web
  Scenario: Copa Airlines Login option scenario
    Given User chooses "Login" option

  @android @ignore
  Scenario: Copa Airlines booking option scenario
    Given User chooses "Book Flight" option

  @android @ignore
  Scenario: Copa Airlines checkin option scenario
    Given User chooses "Checkin" option

  @android @ignore
  Scenario: Copa Airlines checkin option scenario
    Given User chooses "View Reservation" option

  @android @ignore
  Scenario: Copa Airlines login e2e scenario
    Given User chooses "Book Flight" option
    And Search for "round-trip" journey with below criteria
      | From      | To       | Departure       | Return          | Adult | Child | ClassType  |
      | "Orlando" | "Panama" | "July 15, 2018" | "July 25, 2018" | 1     | 1     | "Business" |