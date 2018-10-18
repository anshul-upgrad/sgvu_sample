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

public class SignInTest {
	Initiator test;
	ConfigFileReader config;

	@BeforeClass
	public void startTest(){
		config = new ConfigFileReader();
		test = new Initiator(config.getProperty("browser"));
		test.homepage.launchApplication(config.getProperty("url"));
	}
	
	@Test
	@Severity(SeverityLevel.TRIVIAL)
	public void blank_sign_in_test(){
		test.signInModal = test.homepage.openSignInModal();
		Assert.assertEquals(test.signInModal.blankFormSignIn(), config.getProperty("error_blank_sign_in"));
		
		Reporter.log("Sign In test passed",true);
	
	}
	
	@AfterClass
	public void closeSession(){
		test.homepage.closeBrowser();
	}
}
