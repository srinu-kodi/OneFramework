# OneFramework
This is a generic Page Object Model which will fit for both Mobile & Web platforms.
This will serve the benefits to both native android, ios and web platforms with single framework.

We often tend to create different test frameworks for different platforms and it is very difficlut for anyone to serve all platform needs in one test automation framework.

As part of this framework I have taken Wordpress mobile app for Android & iOS mobile platforms, It's web application for web application automation. In order to create the framework, I have used below libraries/technologies.

# Libraries used:
1. Appium
2. Selenium WebDriver
3. Java
4. Cucumber-java, Cucumber-junit
5. jUnit
6. Log4j
7. Gradle

# How this framework works:
This framework is built in BDD style using cucumber framework and scenarios will be run using cucumber-junit runners.<br/>
We have 3 different runners for 3 platforms and here is how we tag those scenarios and execute them.

Scenarios tagging
* @web - for web tests
* @android - for android tests
* @ios - for ios tests
* @ignore - to ignore certain tests

Execution
+ gradle test --tests "runners.AndroidRunner"
+ gradle test --tests "runners.IOSRunner"
+ gradle test --tests "runners.WebRunner"

# Pending tasks:
1. Proper logging at each step
2. Parallel test execution
3. Integration with CI i.e. Jenkins (or) Travis (or) Circle CI (or) Go
4. Recording of test execution
5. Detailed cucumber profiling
6. Gradle tasking