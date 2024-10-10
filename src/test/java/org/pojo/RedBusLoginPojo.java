package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedBusLoginPojo extends BaseClass {
	public RedBusLoginPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy
	(id = "")

}
