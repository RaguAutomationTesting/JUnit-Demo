package org.task;

import java.util.Date;

import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pojo.BookHotelPojo;
import org.pojo.BookingConfirmPage;
import org.pojo.LoginPagePojo;
import org.pojo.SearchHotelPagePojo;

public class Question6 extends BaseClass {
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

	@Test
	public void tc1() throws InterruptedException {
		maximizeBrowser();
		launchUrl("http://www.adactin.com/HotelApp/");

		LoginPagePojo login = new LoginPagePojo();

		enterText(login.getTxtUsername(), "SIRagu123");

		enterText(login.getTxtPassword(), "MH1157");

		clickElement(login.getBtnLogin());

		SearchHotelPagePojo s = new SearchHotelPagePojo();

		selectDropDownUsingValue(s.getLocation(), "New York");

		selectDropDownUsingValue(s.getHotels(), "Hotel Sunshine");

		selectDropDownUsingValue(s.getRoomType(), "Standard");

		selectDropDownUsingValue(s.getAdultRooms(), "1");

		selectDropDownUsingValue(s.getChildRooms(), "0");

		clickElement(s.getBtnSearch());

		SearchHotelPagePojo s1 = new SearchHotelPagePojo();

		clickElement(s1.getBtnRadio());

		clickElement(s1.getBtnContinue());

		BookHotelPojo b = new BookHotelPojo();

		enterText(b.getFirstName(), "Ram");

		enterText(b.getLastName(), "Prasad");

		enterText(b.getAddress(), "128 perumbakkam chennai");

		enterText(b.getCreditCardNo(), "1234567890123456");

		//enterText(b.getCreditCardType(), "VISA");
		selectDropDownUsingValue(b.getCreditCardType(), "VISA");
		//Thread.sleep(5000);
		//enterText(b.getCreditCardMonth(), "10");
		selectDropDownUsingValue(b.getCreditCardMonth(), "8");

		//enterText(b.getCreditCardYear(), "2030");
		selectDropDownUsingValue(b.getCreditCardYear(), "2030");
		enterText(b.getCcvNo(), "456");

		clickElement(b.getBtnBookNow());
		
		BookingConfirmPage b1 = new BookingConfirmPage();
		 Thread.sleep(5000);
		 WebElement orderNo = b1.getOrderNo();
		  Thread.sleep(5000);
		 String attribute = orderNo.getAttribute("value");
		 
		System.out.println("Order No: "+attribute);

	}

}
