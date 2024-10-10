package org.pojo;


import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPojo extends BaseClass {
	public BookHotelPojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "cc_num")
	private WebElement creditCardNo;

	@FindBy(id = "cc_type")
	private WebElement creditCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement creditCardMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement creditCardYear;

	@FindBy(id = "cc_cvv")
	private WebElement ccvNo;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	@FindBy(id = "order_no")
	private WebElement orderNo;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditCardNo() {
		return creditCardNo;
	}

	public WebElement getCreditCardType() {
		return creditCardType;
	}

	public WebElement getCreditCardMonth() {
		return creditCardMonth;
	}

	public WebElement getCreditCardYear() {
		return creditCardYear;
	}

	public WebElement getCcvNo() {
		return ccvNo;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getOrderNo() {
		return orderNo;
	}

}
