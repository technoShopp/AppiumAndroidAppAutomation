package Utilities;



import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import PageObjectRepository.CreateRecurringMeetingPageObjects;
import PageObjectRepository.SearchPageObjects;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Tools {
	protected static AppiumDriverLocalService service;
	protected static AndroidDriver<AndroidElement> driver;
	protected static String log4jPath = System.getProperty("user.dir")+"\\log4j.properties";
	protected static Logger log = Logger.getLogger("calenderLogger");
    protected static String nodeJSPath;
    protected static String appiumPath;
    protected static String platformName;
    protected static String platformVersion;
    protected static String automationName;
    protected static String packageName;
    protected static String activityName;
    protected static String commandTimeOut;
    protected static Set<String> hs = new HashSet<String>();
    	
	public static void loadPropertyFile() throws Throwable
	{
		Properties p= new Properties();
		FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Utilities\\global.properties");
		p.load(f);
		 nodeJSPath=p.getProperty("NODEJSPATH");
		 appiumPath=p.getProperty("APPIUMJSPATH");
		
		     platformName= p.getProperty("platformName");
		    platformVersion= p.getProperty("platformVersion");
		    automationName= p.getProperty("automationName");
		   packageName= p.getProperty("app_PackageName");
		    activityName= p.getProperty("app_activity");
		    commandTimeOut= p.getProperty("commandTimeout");
	}
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		
		try
		{
			serverSocket = new ServerSocket(port);
			serverSocket.close();
			
		}
		catch(IOException e)
		{
			isServerRunning = true;
		}
		finally
		{
			serverSocket = null;
		}
		
		return isServerRunning;
	}
	
	
	public static AndroidDriver<AndroidElement> intializeDriver(DesiredCapabilities cap) throws Throwable
	{
				
		driver =new AndroidDriver<AndroidElement>(service,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void getScreenshots(String fileName) throws Throwable
	{
	
	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\"+fileName+".png"));
	}
	
	public static void closeDriver() throws Throwable
	{
	
	driver.closeApp();
	}

	public static DayOfWeek getDay(String date)
	{
		DayOfWeek day=LocalDate.parse(                             
	             date , 
	             DateTimeFormatter.ofPattern( "dd-MM-uuuu" ) 
	         )                                    
	         .getDayOfWeek();                   
	     
				return day;
	}
	
	
	
	public static int covertToDayNumber(String day)
	{
		int dayNumber =0;
		if(day.equalsIgnoreCase("monday"))
		{
			dayNumber=1;
		}
		else if (day.equalsIgnoreCase("tuesday"))
		{
			dayNumber=2;
		}
		else if (day.equalsIgnoreCase("wednesday"))
		{
			dayNumber=3;
		}
		else if (day.equalsIgnoreCase("thursday"))
		{
			dayNumber=4;
		}
		else if (day.equalsIgnoreCase("friday"))
		{
			dayNumber=5;
		}
		else if (day.equalsIgnoreCase("saturday"))
		{
			dayNumber=6;
		}
		
		return dayNumber;
		
	}

	
	public  DesiredCapabilities setCapabilities(DesiredCapabilities cap, String device)
	{
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,device );
		System.out.println(device);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,packageName);
	    cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,activityName);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, commandTimeOut);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		return cap;
	}
	
	
	public static String covertToMonthString(String monthNumber)
	{
		String monthName =null;
		if(monthNumber.equalsIgnoreCase("01"))
		{
			monthName="January";
		}
		else if (monthNumber.equalsIgnoreCase("02"))
		{
			monthName="February";
		}
		else if (monthNumber.equalsIgnoreCase("03"))
		{
			monthName="March";
		}
		else if (monthNumber.equalsIgnoreCase("04"))
		{
			monthName="April";
		}
		else if (monthNumber.equalsIgnoreCase("05"))
		{
			monthName="May";
		}
		else if (monthNumber.equalsIgnoreCase("06"))
		{
			monthName="June";
		}
		else if (monthNumber.equalsIgnoreCase("07"))
		{
			monthName="July";
		}
		else if (monthNumber.equalsIgnoreCase("08"))
		{
			monthName="August";
		}
		else if (monthNumber.equalsIgnoreCase("09"))
		{
			monthName="September";
		}
		else if (monthNumber.equalsIgnoreCase("10"))
		{
			monthName="October";
		}
		else if (monthNumber.equalsIgnoreCase("11"))
		{
			monthName="November";
		}
		else if (monthNumber.equalsIgnoreCase("12"))
		{
			monthName="December";
		}
		
		return monthName;
		
	}
	
	
	public void setStartDate(String date,CreateRecurringMeetingPageObjects crmpo) throws Throwable
	{
		
		crmpo.getDefaultStartLabel().click();
		DayOfWeek day=Tools.getDay(date);
		//log.info("DAY  = ="+day);
		String dayS = day.toString();
		//log.info("DAY = = "+dayS);
		String datePart=date.split("-")[0];
		String monthPart=date.split("-")[1];
		String yearPart=date.split("-")[2];
		
		String desiredMonth=covertToMonthString(monthPart);
		
		int dateInt=Integer.parseInt(datePart);
		//log.info("*DATE*==="+dateInt);
		if( !dayS.equalsIgnoreCase("Sunday"))
		{
		//	log.info("****WORKING DAY***");
			crmpo.getDefaultDate().click();
			String monthYear=crmpo.getCalenderText().getText();
			String monthText=monthYear.split(" ")[0];
			String yearText=monthYear.split(" ")[1];
		//	log.info("MONTH TEXT =="+monthText);
		//	log.info("YEAR TEXT =="+yearText);
		
			selectStartDate(monthText,yearText,monthYear,crmpo,dateInt,desiredMonth,yearPart);
			
		}
		else
		{
			log.info("The STart day must not be sunday");
			//Assert.assertTrue(false);
			Assert.fail();
		}
		log.info("****Day and Time set***");
		}
	
	
	public void selectStartDate(String monthText, String yearText, String monthYear,CreateRecurringMeetingPageObjects crmpo, int dateInt, String desiredMonth, String yearPart) throws InterruptedException
	{
			while(!monthText.equalsIgnoreCase(desiredMonth) && yearText.equalsIgnoreCase(yearPart)) {
			//log.info("****NO MARCH***");
			crmpo.getNextButton().click();
		//	log.info("****CLICKED***");
			 monthYear=crmpo.getCalenderText().getText();
			monthText=monthYear.split(" ")[0];
			 yearText=monthYear.split(" ")[1];
		//	 log.info("MONTH TEXT =="+monthText);
			//	log.info("YEAR TEXT =="+yearText);
			if(monthText.equalsIgnoreCase("March") )
			{
			//	log.info("****WORKING DAY in MARCH***");
				crmpo.getDatePicker().get(dateInt+4).click();
				Thread.sleep(5000);
				break;
				
			}
		}
		
	}
	
	
	public void checkSuccessiveNonWorkingDay(String noOfDays, String days, CreateRecurringMeetingPageObjects crmpo)
	{
		int dayNo=Integer.parseInt(noOfDays);
	//	log.info("NoOfDays"+dayNo);
		int actualNo=days.split(" ").length;
	//	log.info(actualNo);
		if(dayNo==3) {
		if(dayNo==actualNo)
		{
			String day1=days.split(" ")[0];
			String day2=days.split(" ")[1];
			String day3=days.split(" ")[2];
			int a=Tools.covertToDayNumber(day1);
			int b=Tools.covertToDayNumber(day2);
			int c=Tools.covertToDayNumber(day3);
			int diffday2day1=b-a;
			int diffday3day2=c-b;
		//	log.info(a)	;
		//	log.info(b)	;
		//	log.info(c)	;
		//	log.info(diffday2day1)	;
		//	log.info(diffday3day2)	;
			
			if((!day1.equalsIgnoreCase("Sunday")) && (!day2.equalsIgnoreCase("Sunday")) && (!day3.equalsIgnoreCase("Sunday")))
			{
			if(diffday2day1>1 && diffday3day2>1  )
			{	
				driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
		                ".scrollIntoView(new UiSelector().text(\"Don't repeat\"));"));
				crmpo.getRepeatButton().click();
				crmpo.getCustomizeButton().get(5).click();
				crmpo.getWeekText().click();
				driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
		                ".scrollIntoView(new UiSelector().text(\"Forever\"));"));
				clearToggledDays(crmpo);
				clickDesiredDays(crmpo,day1,day2,day3);
			}
			else if(diffday2day1==1 || diffday3day2==1 ) {
				log.info("MEETINGS SHOULD NOT BE SCEDULED ON SUCCESSIVE DAYS");
				Assert.fail();
			}
			else {}
			crmpo.getDuration().click();
			crmpo.getNoOfOccurancesElement().click();
			crmpo.getNoOfOccurancesCount().clear();
			crmpo.getNoOfOccurancesCount().sendKeys("10");
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			}
			else {
				log.info("Please don't select SUNDAY for MEETING ");
				Assert.fail();
			}
			}
		else
		{
			log.info("The days selected does not match the days planned");
			Assert.fail();
		}
	}
		else
		{
			log.info("The no of days a week is not 3");
			Assert.fail();
		}
		}
	
	public void clearToggledDays(CreateRecurringMeetingPageObjects crmpo)
	{
		if(crmpo.getMondayButton().getAttribute("checked").equalsIgnoreCase("true"))
		{crmpo.getMondayButton().click();}
		if(crmpo.getTuesdayButton().getAttribute("checked").equalsIgnoreCase("true"))
		{crmpo.getTuesdayButton().click();}
		if(crmpo.getWednesdayButton().getAttribute("checked").equalsIgnoreCase("true"))
		{crmpo.getWednesdayButton().click();}
		if(crmpo.getThursdayButton().getAttribute("checked").equalsIgnoreCase("true"))
		{crmpo.getThursdayButton().click();}
		if(crmpo.getFridayButton().getAttribute("checked").equalsIgnoreCase("true"))
		{crmpo.getFridayButton().click();}
		if(crmpo.getSaturdayButton().getAttribute("checked").equalsIgnoreCase("true"))
		{crmpo.getSaturdayButton().click();}
	}
	
	
	public void clickDesiredDays(CreateRecurringMeetingPageObjects crmpo, String day1,String day2,String day3)
	{
		if(crmpo.getMondayButton().getAttribute("checked").equalsIgnoreCase("false")&& day1.equalsIgnoreCase("monday"))
		{crmpo.getMondayButton().click();}
		if(crmpo.getWednesdayButton().getAttribute("checked").equalsIgnoreCase("false")&& day2.equalsIgnoreCase("wednesday"))
		{crmpo.getWednesdayButton().click();}
		if(crmpo.getFridayButton().getAttribute("checked").equalsIgnoreCase("false")&& day3.equalsIgnoreCase("friday"))
		{crmpo.getFridayButton().click();}
		if(crmpo.getTuesdayButton().getAttribute("checked").equalsIgnoreCase("false")&& day1.equalsIgnoreCase("tuesday"))
		{crmpo.getTuesdayButton().click();}
		if(crmpo.getThursdayButton().getAttribute("checked").equalsIgnoreCase("false")&& day2.equalsIgnoreCase("thursday"))
		{crmpo.getThursdayButton().click();}
		if(crmpo.getSaturdayButton().getAttribute("checked").equalsIgnoreCase("false")&& day3.equalsIgnoreCase("saturday"))
		{crmpo.getSaturdayButton().click();}
	}
	
	
	public void setStartStopTime(String startEnd, String hour, String minute,CreateRecurringMeetingPageObjects crmpo ) throws InterruptedException
	{
		 String amPM=null;
			if(startEnd.equalsIgnoreCase("start"))
			{
				
				crmpo.getActualTime().get(1).click();
				Thread.sleep(3000);
				crmpo.getActualTime().get(0).sendKeys(hour);
				crmpo.getActualTime().get(1).sendKeys(minute);
				 amPM=crmpo.getAmPMText().get(3).getText().split(",")[0];
			}
			else if (startEnd.equalsIgnoreCase("end"))
		   {
			crmpo.getEndTime().click();
			crmpo.getActualTime().get(1).click();
			Thread.sleep(3000);
			crmpo.getActualTime().get(0).sendKeys(hour);
			crmpo.getActualTime().get(1).sendKeys(minute);
			 amPM=crmpo.getAmPMText().get(5).getText().split(",")[0];
			}
			else {}
			//log.info("****AMPM***** = "+amPM);
			setPMIfAMSelected(amPM,crmpo);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		}
	
	
	
	public void setPMIfAMSelected(String amPM,CreateRecurringMeetingPageObjects crmpo )
	{
		if(amPM.equalsIgnoreCase("am"))
		{
			crmpo.getPmText().click();
		}
		else {}
	}
	
	
	
	public void setInvitees(String noOfInvitees, String emailIds,CreateRecurringMeetingPageObjects crmpo ) throws InterruptedException
	{
		String [] emailIdList=emailIds.split(" ");
		int inviteesNo=emailIdList.length;
		int number = Integer.parseInt(noOfInvitees);
		int i=1;
		if(inviteesNo==number)	
		{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Invitee\").instance(0))"));
		crmpo.getInviteeElement().click();
		while(i<=inviteesNo)
		{
			crmpo.getInviteeElement().sendKeys(emailIdList[inviteesNo-number]);
			Thread.sleep(2000);
			crmpo.getAddInviteeIcon().click();
			number--;
			i++;
		}
		}
		else
		{log.info("INVITEES NAMES AND NUMBER DON't MATCH");
		//Assert.assertTrue(false);
		Assert.fail();
		
		}
		
	}
	
	public void finalValidation(String meetingTitle,CreateRecurringMeetingPageObjects crmpo,SearchPageObjects spo, String daysScheduled ) throws Throwable
	{
		Thread.sleep(3000);
		crmpo.getOpenDraw2().get(0).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"Search\"));"));
		crmpo.getSearchButton().click();
		spo= new SearchPageObjects(driver);
		spo.getSearchText().sendKeys(meetingTitle);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(3000);	
		logDaysMeetingScheduled(spo,daysScheduled);
		getValuesFromSet();
	}
	
	
	public void logDaysMeetingScheduled(SearchPageObjects spo, String daysScheduled) throws Throwable
	{
		String[] days=daysScheduled.split(",");
		String a=days[0].split(" ")[1];
		String b=days[0].split(" ")[2];
		String c=a+" "+b;
		String d=days[1].split(" ")[1];
		String e=days[1].split(" ")[2];
		String f=d+" "+e;
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.samsung.android.calendar:id/agenda_list\")).scrollIntoView(new UiSelector().textContains(\""+c+"\").instance(0))"));
		logInfo(spo);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.samsung.android.calendar:id/agenda_list\")).scrollIntoView(new UiSelector().textContains(\""+f+"\").instance(0))"));
		logInfo(spo);
	}
	
	public void logInfo(SearchPageObjects spo) {
		for(int i=0;i<spo.getTimeDateDetailsID().size();i++)
		{
			// log.info("MEETING SCHEDULED ON"+spo.getTimeDateDetailsID().get(i).getText());
			 putDatesInSet(spo,i);
		}
		
	}
	
	public void putDatesInSet(SearchPageObjects spo,int i)
	{
	  hs.add(spo.getTimeDateDetailsID().get(i).getText());
	}
	
	
	public void getValuesFromSet()
	{
		int i=0;
		Iterator<String> it=hs.iterator();
		while(it.hasNext())
		{
			log.info("MEETING SCHEDULED SUCCESSFULLY ON"+it.next());
		i++;
		}
		}
	}
	
	
	

