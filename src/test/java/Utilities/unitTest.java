package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class unitTest {

	public static void main(String[] args) throws Throwable {
		/*Properties p= new Properties();
		FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Utilities\\global.properties");
		p.load(f);
		String nodeJSPath=p.getProperty("NODE_JS_PATH");
		String appiumPath=p.getProperty("APPIUM_JS_PATH");
		System.out.println("NODE"+nodeJSPath);
		System.out.println("NODE"+appiumPath);
		int a=covertToDayNumber("FRIDAY");
		System.out.println(a);*/
		
		String b=covertToMonthString("03");
		System.out.println(b);
	

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
		
		return dayNumber;
		
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
	
	
	
	

}
