Feature: Wordpress SignUp/SignIn Feature

  @android @ios
  Scenario: Wordpress Login scenario
    Given User chooses "Login" option
    Then User should see page title as "Log in to WordPress.com using an email address to manage all your WordPress sites."

  @android @ios @web
  Scenario: Wordpress Signup scenario
    Given User chooses "Signup" option

  @web
  Scenario: Wordpress Login scenario
    Given User chooses "Login" option
    Then User should see page title as "Log in to your account."