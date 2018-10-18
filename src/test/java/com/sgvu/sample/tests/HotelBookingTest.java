package com.sgvu.sample.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sgvu.sample.utilities.ConfigFileReader;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import com.sgvu.sample.initializations.Initiator;

public class HotelBookingTest {
	
	Initiator test;
	ConfigFileReader config;

	@BeforeClass
	public void startTest(){
		config = new ConfigFileReader();
		test = new Initiator(config.getProperty("browser"));
		test.homepage.launchApplication(config.getProperty("url"));
	}
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	public void hotel_valid_search(){
		test.hotelSearchPage = test.homepage.navigateToHotelSearch();
		test.hotelSearchResultPage = test.hotelSearchPage.searchHotels(config.getProperty("city_hotel"),config.getProperty("travellers"));
		Assert.assertTrue(test.hotelSearchResultPage.isUserOnHotelSearchResultPage());
		Reporter.log("Hotel search passed",true);
	
	}
	
	@AfterClass
	public void closeSession(){
		test.homepage.closeBrowser();
	}
}
