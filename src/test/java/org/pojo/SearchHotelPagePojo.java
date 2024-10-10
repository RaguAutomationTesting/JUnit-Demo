package org.pojo;


import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPagePojo extends BaseClass {
	public SearchHotelPagePojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Submit")
	private WebElement btnSearch;
	
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	
	@FindBy(id ="continue")
	private WebElement btnContinue;

	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotels;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="room_nos")
	private WebElement noOfRooms;
	
	@FindBy(id="adult_room")
	private WebElement adultRooms;
	
	@FindBy(id="child_room")
	private WebElement childRooms;

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getAdultRooms() {
		return adultRooms;
	}

	public WebElement getChildRooms() {
		return childRooms;
	}
	
	
}
