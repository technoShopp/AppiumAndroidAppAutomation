Feature: Create a recurring meeting using Native Android/IOS Calender App

@auto
Scenario Outline: Create a new recurring (3 days a week) meeting, and make sure it doesn't repeat on successive days 
Given I have launched the Calender App
When the "<startFromDate>" day is not a non working day
And the "<noOfDaysAWeek>" days a week meeting is not repeated on successive days for the days "<daysSelcted>"
Then I want to book a meeting with the title "<meetingTitle>"
And the "<startTime>" time hour as "<startHour>" and minutes as "<startMinute>"  
And the "<endTime>" time hour as "<endHour>" and minutes as "<endMinute>"
And I invite "<noOfInvitees>" and they are "<inviteeList>" 
And I save the meeting
And I check if the meeting with title "<meetingTitle>" is created on "<firstLastDayScheduled>" as expected


Examples:
|startTime|startHour|startMinute|endTime|endHour|endMinute|startFromDate|meetingTitle                  |noOfInvitees|  inviteeList                                   | noOfDaysAWeek|daysSelcted                    |firstLastDayScheduled        |   
#------------------------------------------------------POSITIVE SCENARIO - BUILD SUCCESS---------------------------------------------------------------------
|start    |6        |00         |end    |7      |15       |15-03-2021   |Recurring-Team Catch Up       |2           | deepak4all@gmail.com v_malini@rocketmail.com   |3             |tuesday thursday saturday      |16 March 2021,6 April 2021   |
#---------------------------------------ERROR PRONE SCENARIOS DUE TO INVALID DATA - BUILD FAILURE-------------------------------------------------------------
# NEGATIVE SCENARIOS - SUCCESSIVE DAYS NOT ACCEPTED
#|start    |6        |00         |end    |7      |15       |15-03-2021   |Recurring-Team Catch Up       |2           | deepak4all@gmail.com v_malini@rocketmail.com   |3             |tuesday wednesday saturday     |16 March 2021,6 April 2021   |
# NEGATIVE SCENARIOS - SUNDAY NOT ACCEPTED
#|start    |6        |00         |end    |7      |15       |15-03-2021   |Recurring-Team Catch Up       |2           | deepak4all@gmail.com v_malini@rocketmail.com   |3             |tuesday thursday sunday        |16 March 2021,6 April 2021   |
# NEGATIVE SCENARIOS - TITLE VALIDATION TO BE EXACTLY "Recurring-Team Catch Up"
#|start    |6        |00         |end    |7      |15       |15-03-2021   |Recurring-Team Catch Up 2     |2           | deepak4all@gmail.com v_malini@rocketmail.com   |3             |tuesday thursday saturday      |16 March 2021,6 April 2021   |
# NEGATIVE SCENARIOS - OTHER THAN 3 days a week
#|start    |6        |00         |end    |7      |15       |15-03-2021   |Recurring-Team Catch Up       |2           | deepak4all@gmail.com v_malini@rocketmail.com   |2             |tuesday thursday saturday      |16 March 2021,6 April 2021   |
# NEGATIVE SCENARIO - The days selected are not equal to 3
#|start    |6        |00         |end    |7      |15       |15-03-2021   |Recurring-Team Catch Up       |2           | deepak4all@gmail.com v_malini@rocketmail.com   |3             |tuesday thursday               |16 March 2021,6 April 2021   |
# NEGATIVE SCENARIO - The no of invitees not equal to the specified ones
#|start    |6        |00         |end    |7      |15       |15-03-2021   |Recurring-Team Catch Up       |2           | deepak4all@gmail.com                           |3             |tuesday thursday saturday      |16 March 2021,6 April 2021   |
