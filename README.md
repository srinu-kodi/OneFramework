# `OneFramework`
This is a generic Page Object Model which will fit for both Mobile & Web platforms.
This will serve the benefits to both native android, ios and web platforms with single framework.

We often tend to create different test frameworks for different platforms and it is very difficult for anyone to serve all platform needs in one test automation framework.

<b>`If you want to to automate the same application on android, ios & web platforms and you want single code base to handle the automation? This framework is for you.`</b>

<b>`FYI: I have taken WordPress app which is available on all platforms for automation.`</b>

## Contents:

* [Features](#features)
* [Libraries Used](#libraries-used)
* [Prerequisites Installations](#prerequisites-installations)
* [Appium Setup](#appium-setup)
* [How To This Framework Works](#how-this-framework-works)
* [How To Run Tests](#how-to-run-tests)
* [Pending Tasks](#pending-tasks)
* [How To Contribute?](#how-to-contribute)

## Features:

* Cross platform(mobile & web) support with single codebase
* Page Object Model
* TestNG integration
* Image Comparison
* Allure Reporting
* Robust in nature

## Libraries Used:

1. Appium
2. Selenium WebDriver
3. Java
4. TestNG
5. Gradle
6. WebDriverManager
7. AShot
8. Allure Report

## Prerequisites Installations:

1. `JAVA 1.8`<br>
    Install Java and set the JAVA_HOME path on your machine.
2. `Node & NPM`<br>
    Download Node from `https://nodejs.org/en/download/` and install it on your machine.
3. `Gradle`<br>
    Install gradle
4.  `Android`<br>
    Install Android Studio & set the android environment properly which includes<br>
    -  Downloading the Android SDK
    -  Download the Android SDK tools such as 
       1. Build tools
       2. Platform tools
       3. Android Emulator
       4. Intel HAXM installer etc.....
5.  `iOS`<br>
    Install XCode on your machine and download required iPhone/iPad simulators
6.  `Allure Report`<br>
    Install Allure Report library on your machine. Please follow below link to install
    https://docs.qameta.io/allure/#_installing_a_commandline

## Appium Setup:

- Once Node is installed, install appium using below command.<br>
<b>`Note: Since Appium is a node server, so you need appium(node package) installed on your machine and below is the command for the same.`</b>
``` 
 $ sudo npm install -g appium@1.9.1 --unsafe-perm=true --allow-root 
```
- Install <b>`appium-doctor`</b> which is used to see if appium setup is correctly done or not. Below is the command for the same.<br>
``` 
 $ sudo npm install -g appium-doctor --unsafe-perm=true --allow-root
```
- Run <b>`appium-doctor`</b> and fix the issues in setup<br>
```
$ appium-doctor
```
 
<b>`Note: You may ignore "Bin directory for $JAVA_HOME is not set" error, if it shows up. But except this everything should OKAY`</b>

## How This Framework Works:

This framework is built in Page Object Model style using TestNG framework.<br>
We have "testng.xml" file which has tests for each and every platform in cross browser/device testing fashion.
 
###### Here are the minimal things you have to do:
 
 - Create your tests 
 - Create Page Object classes with your Application page names (I already created some org.oneframework.pageObjects, you can take the reference)
 - Page Object locators (You need to follow this framework notation when defining the locators for each platform)
 - Set Android driver details (Like API version, emulator name, APK path etc...) in Android Builder
 - Set iPhone/iPad driver details (Like OS version, simulator name, UDID, App path etc...) in iPhone Builder
 - You need to set your android, iphone emulator/simulator details in respective builder files
 - Set web app URL
 
## How To Run Tests:

- Clone the repo using below command & open<br>
    `https://github.com/srinu-kodi/OneFramework.git`

```
$ gradle clean build
$ java -jar build/libs/Automation-1.0-SNAPSHOT.jar
```
Once test execution is complete, allure-results directory gets generated.
## How To See Allure Result Report:

I assume you have already installed allure on your machine. If not, install it. If yes, run below command to see the report.
```
$ allure serve <allure-results path>
```

## Pending Tasks:

1. Image masking on certain co-ordinates
2. Proper logging at each step
3. Parallel test execution
4. Integration with CI i.e. Jenkins (or) Travis (or) Circle CI (or) Go
5. Recording of test execution

Moreover I will incorporate if anything pops up in mind, going forward.<br>

## How To Contribute?

1. Raise a PR, if you already add any new feature or fix any issues in this framework.
2. Raise an issue, if you face any code related issues(genuine ones) with this framework.<br>