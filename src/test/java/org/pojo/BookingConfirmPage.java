package org.pojo;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmPage extends BaseClass {
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "order_no")
	private WebElement orderNo;

	public WebElement getOrderNo() {
		return orderNo;
	}

}
