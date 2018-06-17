Feature: Wordpress Homepage Feature

  @android
  Scenario: Wordpress Homepage Login scenario
    Given User chooses "Login" option
    Then User should see page title as "Log in to WordPress.com using an email address to manage all your WordPress sites."

  @android
  Scenario: Wordpress Homepage Signup scenario
    Given User chooses "Signup" option

  @ios
  Scenario: Wordpress Homepage Signup scenario
    Given User chooses "Signup" option

  @ios
  Scenario: Wordpress Homepage Login scenario
    Given User chooses "Login" option
    Then User should see page title as "Log in to WordPress.com using an email address to manage all your WordPress sites."