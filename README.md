## Project:
Android Mobile App Automation using Appium 
REST API Automation using REST Assured 

## Description:
To automate the process of creating a new recurring (3 days a week) meeting through the native calender android app

## Technology Stack

*1. Appium*

*2. Cucumber*

*3. Java*

*4. Page Object Model*

*5. Logging*

*6. Maven*

*7. Cucumber -html -report*


## Installation and execution

### Following are the installations need to run the test automation suite###
**Node**
**Appium Server**
**JDK**
**Maven**


*To run the script from a command line in a Terminal window you can use the below command.*
```
mvn test verify -DdeviceName=GalaxyS10e -Dcucumber.options="--tags @auto"
```

## Reporting and Logging
**Reporting Path **
```
./target/report/cucumber-html-reports/report-feature_3867371660.html
```
**Logging Path **
```
./src/test/java/Logs/ApplicationLog
```

## Assumptions

```
1.A week cycle is from Monday to Sunday
2.Sunday is the only non working day
3.The meeting will not be scheduled on successive days and trying to do so will throw Assertion Error
4.The start date has been set to a future date 15-March-2021 for the smoother execution of the tests
5.The start and end time in hour and minute has been designed to be set
6.The daysSelcted and firstLastDayScheduled values shouls be strictly with a single space
7.The days on which the meeting has been scheduled will come up on logs
8.The tear up and tear down information will also appear on logs
9.Before running the automation script, please make sure to delete any already creayed meeting invites
```



## Happy Path
1.A recurring meeting will be scheduled on alternate 3 days a week (M, W, F or T, T, S) depending on the data provided in the feature file**


## Error Prone Scenarios
1.SUCCESSIVE DAYS NOT ACCEPTED
2.SUNDAY NOT ACCEPTED
3.TITLE VALIDATION TO BE EXACTLY "Recurring-Team Catch Up"
4.NOT 3 DAYS A WEEK MEETING
5.The days selected are not according to the no of days a week number which is 3 here
6.The no of invitees are not equal to the specified ones


## Documentation and the Working Mobile Automation Execution video

*https://github.com/technoShopp/AppiumAndroidAppAutomation/tree/master/Execution%20Instructions*


