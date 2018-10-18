package com.sgvu.sample.initializations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.sgvu.sample.pageObjects.FlightSearchPage;
import com.sgvu.sample.pageObjects.FlightSearchResultPage;
import com.sgvu.sample.pageObjects.HomePage;
import com.sgvu.sample.pageObjects.HotelSearchPage;
import com.sgvu.sample.pageObjects.HotelSearchResultPage;
import com.sgvu.sample.pageObjects.SignInModal;
import com.sgvu.sample.utilities.ConfigFileReader;

public class Initiator {

	private WebDriver driver;
	public HomePage homepage;
	public FlightSearchPage flightSearchPage;
	public FlightSearchResultPage flighSearchResultPage;
	public HotelSearchPage hotelSearchPage;
	public HotelSearchResultPage hotelSearchResultPage;
	public SignInModal signInModal;

	private DriverCreator drFactory;
	
	
	public Initiator(String browser){
		drFactory = new DriverCreator();
		_startBrowser(browser);
		_initPageObject();
	}
	
	private void _startBrowser(String browser){
		driver = drFactory.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	private void _initPageObject(){
		homepage = new HomePage(driver);
	}
	
}
