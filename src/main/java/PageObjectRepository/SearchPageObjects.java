package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPageObjects {
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	private WebElement searchText;
	
	@AndroidFindBy(className="android.widget.TextView")
	private List<WebElement> timeDateDetails;
	
	@AndroidFindBy(id="com.samsung.android.calendar:id/date")
	private List<WebElement> timeDateDetailsID;
	
	
	public List<WebElement> getTimeDateDetailsID() {
		return timeDateDetailsID;
	}





	@AndroidFindBy(id="com.samsung.android.calendar:id/agenda_list")
	private List<WebElement> agendaList;
	
	@AndroidFindBy(xpath="android.widget.Toast[1]")
	private WebElement toastMessage;

	
	public WebElement getToastMessage() {
		return toastMessage;
	}

	public List<WebElement> getAgendaList() {
		return agendaList;
	}

	public WebElement getSearchText() {
		return searchText;
	}
	
	public List<WebElement> getTimeDateDetails() {
		return timeDateDetails;
	}


	


	public SearchPageObjects(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

}
