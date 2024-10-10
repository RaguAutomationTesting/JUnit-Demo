package org.task;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pojo.FacebookLoginPojo;

import junit.framework.Assert;

public class Question1 extends BaseClass {
	@BeforeClass
	public static void browserlaunch() {
		loadBrowser("chrome");

	}

	@AfterClass
	public static void closeBrowser() {
		quitBrowser();

	}

	@Before
	public void startTime() {
		System.out.println("Test case Starts");
		Date d = new Date();
		System.out.println(d);

	}

	@After
	public void endTime() {
		System.out.println("Test case Ends");
		System.out.println(new Date());

	}

	// Login with invalid user name and valid password
	@Test
	public void tc1() {
		launchUrl("https://www.facebook.com/");
		FacebookLoginPojo f = new FacebookLoginPojo();

		enterText(f.getTxtEmail(), "Ram@gmail.com");

		Assert.assertEquals("Expected email and actual email value are not same", "Rm@gmail.com",
				getAttributeValueOfWebelement(f.getTxtEmail()));

		enterText(f.getTxtPass(), "Ram123");
		
		Assert.assertEquals("Expected password and actual password are not same", "Ram123",
				f.getAttributeValueOfWebelement(f.getTxtPass()));
		
		clickElement(f.getBtnLogin());

	}

	// Login with vaild username and valid password
	@Test
	public void tc3() {
		launchUrl("https://www.facebook.com/");
		FacebookLoginPojo f = new FacebookLoginPojo();

		enterText(f.getTxtEmail(), "Ram@gmail.com");
		
		Assert.assertEquals("Expected email and actual email value are not same", "Ram@gmail.com",
				getAttributeValueOfWebelement(f.getTxtEmail()));
		

		enterText(f.getTxtPass(), "Ram123");
		
		Assert.assertEquals("Expected password and actual password are not same", "Ram123",
				f.getAttributeValueOfWebelement(f.getTxtPass()));

		clickElement(f.getBtnLogin());

	}

	// Login with valid username and invalid password
	@Test
	public void tc2() {
		launchUrl("https://www.facebook.com/");
		FacebookLoginPojo f = new FacebookLoginPojo();

		enterText(f.getTxtEmail(), "Ram@gmail.com");
		
		Assert.assertEquals("Expected email and actual email value are not same", "Ram@gmail.com",
				getAttributeValueOfWebelement(f.getTxtEmail()));

		enterText(f.getTxtPass(), "Ram123");
		Assert.assertEquals("Expected password and actual password are not same", "Rm123",
				f.getAttributeValueOfWebelement(f.getTxtPass()));

		clickElement(f.getBtnLogin());

	}

	// Login with invalid username and invalid password
	@Test
	public void tc4() {
		launchUrl("https://www.facebook.com/");
		FacebookLoginPojo f = new FacebookLoginPojo();

		enterText(f.getTxtEmail(), "Ram@gmail.com");

		Assert.assertEquals("Expected email and actual email value are not same", "Rm@gmail.com",
				getAttributeValueOfWebelement(f.getTxtEmail()));

		enterText(f.getTxtPass(), "Ram123");
		Assert.assertEquals("Expected password and actual password are not same", "Rm123",
				f.getAttributeValueOfWebelement(f.getTxtPass()));

		clickElement(f.getBtnLogin());

	}

}
