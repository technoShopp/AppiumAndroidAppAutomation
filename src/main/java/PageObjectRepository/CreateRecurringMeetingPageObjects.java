package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateRecurringMeetingPageObjects {
	@AndroidFindBy(id="com.samsung.android.calendar:id/start_date_time")
	private WebElement startTime;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/end_date_time")
	private WebElement endTime;
	
	@AndroidFindBy(className="android.widget.EditText")
	private List<WebElement> actualTime;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='00, Minute']")
	private WebElement actualEndTime;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/start_label")
	private WebElement defaultStartLabel;
	
	@AndroidFindBy(uiAutomator="textContains(\"Double tap to switch to calendar view.\")")
	private WebElement defaultDate;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/sesl_date_picker_calendar_header_text")
	private WebElement calenderText;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/sesl_date_picker_calendar_header_next_button")
	private WebElement nextButton;
	
	@AndroidFindBy(className="android.view.View")
	private List<WebElement> datePicker;
	
	@AndroidFindBy(className="android.widget.TextView")
	private List<WebElement> amPMText;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='pm, , ']")
	private WebElement pmText;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/repeat_text")
	private WebElement repeatButton;

	@AndroidFindBy(className="android.widget.RadioButton")
	private List<WebElement> customizeButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='week, , ']")
	private WebElement weekText;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/add_dayofweek_toggle_mon")
	private WebElement mondayButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/add_dayofweek_toggle_sat")
	private WebElement saturdayButton;
	
	public WebElement getSaturdayButton() {
		return saturdayButton;
	}

	@AndroidFindBy(xpath="//android.widget.ToggleButton")
	private List<WebElement> toggleButton;
	
	
	
	
	
	
	public List<WebElement> getToggleButton() {
		return toggleButton;
	}

	@AndroidFindBy(id="com.samsung.android.calendar:id/add_dayofweek_toggle_wed")
	private WebElement wednesdayButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/add_dayofweek_toggle_fri")
	private WebElement fridayButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/repeat_duration")
	private WebElement duration;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Forever']")
	private WebElement forScrollElement;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search']")
	private WebElement searchButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/open_drawer")
	private WebElement openDraw;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	private List<WebElement> openDraw2;
	
	
	
	
	
	
	
	
	public List<WebElement> getOpenDraw2() {
		return openDraw2;
	}







	public WebElement getOpenDraw() {
		return openDraw;
	}







	public WebElement getSearchButton() {
		return searchButton;
	}



	



	public WebElement getDuration() {
		return duration;
	}



	public WebElement getMondayButton() {
		return mondayButton;
	}



	public WebElement getWednesdayButton() {
		return wednesdayButton;
	}



	public WebElement getFridayButton() {
		return fridayButton;
	}



	public WebElement getForScrollElement() {
		return forScrollElement;
	}



	public WebElement getNoOfOccurancesElement() {
		return noOfOccurancesElement;
	}



	public WebElement getNoOfOccurancesCount() {
		return noOfOccurancesCount;
	}



	@AndroidFindBy(id="com.samsung.android.calendar:id/repeat_duration_option_end_count")
	private WebElement noOfOccurancesElement;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/repeat_duration_end_count_text")
	private WebElement noOfOccurancesCount;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/title")
	private WebElement titleElement;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/attendees")
	private WebElement inviteeElement;
	
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/add_button")
	private WebElement addInviteeIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='(GMT+11:00) Australian Eastern Daylight Time']")
	private WebElement gmtButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save']")
	private WebElement saveButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/location")
	private WebElement locationTextElement;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/add_dayofweek_toggle_tue")
	private WebElement tuesdayButton;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/add_dayofweek_toggle_thu")
	private WebElement thursdayButton;
	
	
	
	public WebElement getTuesdayButton() {
		return tuesdayButton;
	}



	public WebElement getThursdayButton() {
		return thursdayButton;
	}



	public WebElement getLocationTextElement() {
		return locationTextElement;
	}



	public void setLocationTextElement(WebElement locationTextElement) {
		this.locationTextElement = locationTextElement;
	}



	public WebElement getSaveButton() {
		return saveButton;
	}



	public WebElement getAddInviteeIcon() {
		return addInviteeIcon;
	}



	public WebElement getInviteeElement() {
		return inviteeElement;
	}



	public WebElement getTitleElement() {
		return titleElement;
	}



	public void setTitleElement(WebElement titleElement) {
		this.titleElement = titleElement;
	}



	public WebElement getWeekText() {
		return weekText;
	}



	public List<WebElement> getCustomizeButton() {
		return customizeButton;
	}



	public WebElement getRepeatButton() {
		return repeatButton;
	}



	public List<WebElement> getAmPMText() {
		return amPMText;
	}



	public WebElement getPmText() {
		return pmText;
	}



	public List<WebElement> getDatePicker() {
		return datePicker;
	}



	public WebElement getNextButton() {
		return nextButton;
	}



	public WebElement getCalenderText() {
		return calenderText;
	}



	public WebElement getDefaultDate() {
		return defaultDate;
	}



	public WebElement getDefaultStartLabel() {
		return defaultStartLabel;
	}



	public List<WebElement> getActualTime() {
		return actualTime;
	}



	public WebElement getActualEndTime() {
		return actualEndTime;
	}



	public WebElement getStartTime() {
		return startTime;
	}



	public WebElement getEndTime() {
		return endTime;
	}



	public CreateRecurringMeetingPageObjects(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

}
