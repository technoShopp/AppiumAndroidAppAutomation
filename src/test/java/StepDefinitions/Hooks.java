package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import Utilities.Tools;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Tools {
	

	@Before ("@auto")
	public void beforeScenario() throws Throwable
	{
		
		Tools.loadPropertyFile();
		PropertyConfigurator.configure(log4jPath);
	log.info("**************************************************************************");
		log.info("NODE = "+nodeJSPath);
		log.info("APPIUM = "+appiumPath);
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File(nodeJSPath));
		builder.withAppiumJS(new File(appiumPath));
		builder.usingAnyFreePort();
		service=AppiumDriverLocalService.buildService(builder);
		log.info("******URL + PORT *****"+service.getUrl());
		String x= service.getUrl().toString();
		log.info("STRING : "+x);
		String a[]=x.split(":");
		String b[]=a[2].split("/");
		log.info("URL  : "+b[0]);
		int portUsed=Integer.parseInt(b[0]);
		log.info("PORT USED  : "+portUsed);
		boolean serviceCheck=Utilities.Tools.checkIfServerIsRunning(portUsed);
		if(!serviceCheck)
		{
				service.start();
		}
		log.info("Server successfully started");
		}
	@After ("@auto")
	public void afterScenario(Scenario scenario) throws Throwable
	{
		
		if(scenario.isFailed())
		{
			Tools.getScreenshots(scenario.getName());
			log.info("failed and took screenshot");
		}
		else
		{
		log.info("passed");
		}
		Tools.closeDriver();
		service.stop();
		log.info("Server successfully stopped");
		log.info("**************************************************************************");
		}
}
