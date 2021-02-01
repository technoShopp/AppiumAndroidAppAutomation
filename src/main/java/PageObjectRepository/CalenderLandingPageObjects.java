package PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalenderLandingPageObjects {

	@AndroidFindBy(id="com.samsung.android.calendar:id/floating_action_button")
	private WebElement createRecurringMeeting;
	
	public WebElement getCreateRecurringMeeting() {
		return createRecurringMeeting;
	}
	
	public CalenderLandingPageObjects(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

		
}
