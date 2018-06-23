Feature: Wordpress SignUp/SignIn Feature

  @android
  Scenario: Wordpress Login scenario
    Given User chooses "Login" option
    Then User should see page title as "Log in to WordPress.com using an email address to manage all your WordPress sites."

  @android
  Scenario: Wordpress Signup scenario
    Given User chooses "Signup" option

  @ios
  Scenario: Wordpress Login scenario
    Given User chooses "Login" option
    Then User should see page title as "Log in to WordPress.com using an email address to manage all your WordPress sites."

  @ios
  Scenario: Wordpress Signup scenario
    Given User chooses "Signup" option

  @web
  Scenario: Wordpress Login scenario
    Given User chooses "Login" option
    Then User should see page title as "Log in to your account."

  @web
  Scenario: Wordpress Signup scenario
    Given User chooses "Signup" option

  @web @android @ios
  Scenario: Wordpress Signup scenario
    Given User chooses "Signup" option