package com.sgvu.sample.initializations;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sun.javafx.PlatformUtil;


public class DriverCreator {
	 public static final String USERNAME = "sohitagarwal1";
	 public static final String AUTOMATE_KEY = "N9xN3iy1z59Apzi1wQp2";
	 public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	private static String browser;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriver getDriver(String browserName) {
        browser = browserName;
        
        if (browser.equals("chrome")){
        	 if (PlatformUtil.isMac()) {
             	return getChromeDriver(System.getProperty("user.dir") + File.separator+ "Resources"+ File.separator+ "chromedriver");
             }
             if (PlatformUtil.isWindows()) {
             	return getChromeDriver(System.getProperty("user.dir") + File.separator+ "Resources"+ File.separator+ "chromedriver.exe");
             }
             if (PlatformUtil.isLinux()) {
             	return getChromeDriver(System.getProperty("user.dir") + File.separator+ "Resources"+ File.separator+ "chromedriver_linux");
             	
             }
             
             System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator+ "Resources"+ File.separator+ "chromedriver");
             return new ChromeDriver(); // if something goes wrong, Chrome on OSX is default browser
       
        }else if (browser.equals("remote")){
        	DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
            capabilities.setCapability("networkConnectionEnabled", true);
            capabilities.setCapability("browserConnectionEnabled", true);

            try {
				return new RemoteWebDriver(new java.net.URL(URL), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
            
        }
        
        return null;
    }

    @SuppressWarnings("deprecation")
	private static WebDriver getChromeDriver(String driverpath) {
        System.setProperty("webdriver.chrome.driver", driverpath);
        capabilities.setJavascriptEnabled(true);
        return new ChromeDriver(capabilities);
    }


 
	
}