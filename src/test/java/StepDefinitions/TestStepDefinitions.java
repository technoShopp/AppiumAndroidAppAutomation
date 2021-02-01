package StepDefinitions;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import PageObjectRepository.CalenderLandingPageObjects;
import PageObjectRepository.CreateRecurringMeetingPageObjects;
import PageObjectRepository.SearchPageObjects;
import Utilities.Tools;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestStepDefinitions extends Tools {
	String device;
	CalenderLandingPageObjects clpo;
	CreateRecurringMeetingPageObjects crmpo;
	SearchPageObjects spo;
	Tools t = new Tools();
	
	
	@Given("I have launched the Calender App")
	public void I_have_launched_the_Calender_App() throws Throwable {
		device= System.getProperty("deviceName");
		DesiredCapabilities cap = new DesiredCapabilities();
	    cap=t.setCapabilities(cap, device);
		driver=Tools.intializeDriver(cap);
		 log.info("Driver Initialized");
		clpo = new CalenderLandingPageObjects(driver);
		 clpo.getCreateRecurringMeeting().click();
		 crmpo= new CreateRecurringMeetingPageObjects(driver);
		

	}
	
	@Then("the {string} time hour as {string} and minutes as {string}")
	public void the_time_hour_as_and_minutes_as(String a, String b, String c) throws Throwable {
  
		t.setStartStopTime(a, b, c, crmpo);
	}
	
	@When("the {string} day is not a non working day")
	public void the_day_is_not_a_non_working_day(String date) throws Throwable
	{

		t.setStartDate(date,crmpo);
		
	}
			
	@When("the {string} days a week meeting is not repeated on successive days for the days {string}")
	public void the_days_a_week_meeting_is_not_repeated_on_successive_days_for_the_days(String noOfDays, String days)
	{
				
		t.checkSuccessiveNonWorkingDay(noOfDays,days,crmpo);
		
	}
		
	
	@Then("I want to book a meeting with the title {string}")	
	public void I_want_to_book_a_meeting_with_the_title (String title) throws Throwable
	{
		if(title.equalsIgnoreCase("Recurring-Team Catch Up"))
				{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"Title\"));"));
		crmpo.getTitleElement().sendKeys(title);
	}
	else
	{
		log.error("The Title is not Recurring-Team Catch Up");
		Assert.assertTrue(false);
		
		
	}
	}
	

	@Then("I invite {string} and they are {string}")
	public void i_invite_and_they_are(String noOfInvitees, String emailIds) throws Throwable {
	
		t.setInvitees(noOfInvitees, emailIds, crmpo);
		
	}
	@Then("I save the meeting")
	public void i_save_the_meeting() {
	crmpo.getSaveButton().click();
	}
	
	
	@Then("I check if the meeting with title {string} is created on {string} as expected")
	public void I_check_if_the_meeting_is_created_as_expected(String meetingtitle, String daysScheduled) throws Throwable
	{
	
		 
		t.finalValidation(meetingtitle, crmpo, spo,daysScheduled); 
		
	}
	
}
