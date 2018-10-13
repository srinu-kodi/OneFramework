# `OneFramework`
This is a generic Page Object Model which will fit for both Mobile & Web platforms.
This will serve the benefits to both native android, ios and web platforms with single framework.

We often tend to create different test frameworks for different platforms and it is very difficlut for anyone to serve all platform needs in one test automation framework.

<b>`If you have same application on android, ios & web platforms and you want single code base to handle the automation? This framework is for you.`</b>

<b>`FYI: I have taken WordPress app which is available on all platforms for automation.`</b>

### `Libraries used`
1. Appium
2. Selenium WebDriver
3. Java
4. Cucumber-java, Cucumber-junit
5. jUnit
6. Gradle

### `Installations Required`

JAVA 1.8<br>
Node & NPM<br>
Gradle<br>
Android<br>
iOS<br>

- Once Node & NPM is installed, install appium using below command.
``` 
 $ sudo npm install -g appium@1.9.1 --unsafe-perm=true --allow-root 
```
- Now install appium-doctor which is used to see if appium setup is correctly done or not.<br>
``` 
 $ sudo npm install -g appium-doctor --unsafe-perm=true --allow-root
```
- Now run <b>`appium-doctor`</b> to see if the setup is correct or not, and install missing things.<br>
```
$ appium-doctor
```
 
 <b>`Note: You can ignore "Bin directory for $JAVA_HOME is not set" error. But except this everything should be green when you run "appium-doctor"`</b>

### `First Time Setup`

Once all the installations are successful in above step, then you 
- Clone the repo using below command & open it in any IDE.
- Comment out the `test` task in build.gradle & make gradle sync in order to download the dependencies.
- Once dependencies are downloaded, uncomment the `test` task and run your tests.<br>

In order this framework to work on your machine, you need to setup Appium on your machine.<br>

### `How this framework works`
This framework is built in BDD style using cucumber framework and scenarios will be run using cucumber-junit runners.<br/>
We have 3 different runners for 3 platforms and here is how we tag the scenarios and execute them.

 @web - for web tests <br/>
 @android - for android tests <br/>
 @ios - for ios tests <br/>
 @ignore - to ignore certain tests <br/>
 
### `How to run tests`

```
$ gradle clean test -Pplatform=android
$ gradle clean test -Pplatform=ios
$ gradle clean test -Pplatform=web -Pbrowser=chrome
```

### `Pending tasks`
1. Proper logging at each step
2. Parallel test execution
3. Integration with CI i.e. Jenkins (or) Travis (or) Circle CI (or) Go
4. Recording of test execution
5. Gradle tasking (Created one task for running the tests, few tasks are pending)<br>

Moreover will incorporate if anything pops up in mind, going forward.<br>

### `How to contribute?`

1. Raise an issue, if you face any code related issues with this framework.<br>
2. Raise a PR, if you add any new feature or fix any issues.
