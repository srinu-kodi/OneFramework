Feature: Copa Airlines homepage feature validation

  @web
  Scenario: Copa Airlines homepage scenario
    Given User launches the application
    And Search for "round-trip" journey with below criteria
      | From      | To       | Departure       | Return          | Adult | Child | ClassType  |
      | "Orlando" | "Panama" | "July 15, 2018" | "July 25, 2018" | 1     | 1     | "Business" |