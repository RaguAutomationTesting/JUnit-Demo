package org.task;

import java.io.IOException;
import java.util.Date;

 
import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pojo.BookHotelPojo;
import org.pojo.BookingConfirmPage;
import org.pojo.LoginPagePojo;
import org.pojo.SearchHotelPagePojo;

public class Question7 extends BaseClass {
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
	public void tc1() throws InterruptedException, IOException {
		String[][] data = {
				{ "Username", "Password", "Location", "Hotels", "RoomType", "Noof Rooms", "Check in Date",
						"Check Out Date", "Adult Room", "Child Room", "FirstName", "Last Name", "Address",
						"Credit Card No", "Creditcard Type", "Expiry month", "Expiry year", "CVV" },
				{ "SIRagu123", "MH1157", "New York", "Hotel Sunshine", "Standard", "1", "21/06/2023", "22/06/2023", "1",
						"0", "Arun", "Prakash", "128 perumbakkam", "1234567890123456", "VISA", "10", "2030", "456" } };

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {

				createExcelRowAndCell(i, j, data[i][j]);
			}

		}
		System.out.println("Done");

		loadBrowser("chrome");
		maximizeBrowser();
		launchUrl("http://www.adactin.com/HotelApp/");
		applyWaitToAllElements();

		LoginPagePojo l = new LoginPagePojo();

		enterText(l.getTxtUsername(), readDataFromExcel(1, 0));

		enterText(l.getTxtPassword(), readDataFromExcel(1, 1));

		clickElement(l.getBtnLogin());

		pauseExecution(3000);

		SearchHotelPagePojo s = new SearchHotelPagePojo();

		selectDropDownUsingValue(s.getLocation(), readDataFromExcel(1, 2));

		selectDropDownUsingValue(s.getHotels(), readDataFromExcel(1, 3));

		selectDropDownUsingValue(s.getRoomType(), readDataFromExcel(1, 4));

		selectDropDownUsingValue(s.getAdultRooms(), readDataFromExcel(1, 8));

		selectDropDownUsingValue(s.getChildRooms(), readDataFromExcel(1, 9));

		clickElement(s.getBtnSearch());

		pauseExecution(3000);

		SearchHotelPagePojo s1 = new SearchHotelPagePojo();

		clickElement(s1.getBtnRadio());

		clickElement(s1.getBtnContinue());

		pauseExecution(3000);

		BookHotelPojo b = new BookHotelPojo();

		enterText(b.getFirstName(), readDataFromExcel(1, 10));

		enterText(b.getLastName(), readDataFromExcel(1, 11));

		enterText(b.getAddress(), readDataFromExcel(1, 12));

		enterText(b.getCreditCardNo(), readDataFromExcel(1, 13));

		selectDropDownUsingValue(b.getCreditCardType(), readDataFromExcel(1, 14));

		selectDropDownUsingValue(b.getCreditCardMonth(), readDataFromExcel(1, 15));

		selectDropDownUsingValue(b.getCreditCardYear(), readDataFromExcel(1, 16));

		enterText(b.getCcvNo(), readDataFromExcel(1, 17));

		clickElement(b.getBtnBookNow());

		BookingConfirmPage b1 = new BookingConfirmPage();

		String data1 = getAttributeValueOfWebelement(b1.getOrderNo());

		updationInExcel(0, 18, "OrderNo");
		updationInExcel(1, 18, data1);
 
	}
}
