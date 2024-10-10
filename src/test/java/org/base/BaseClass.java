package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions actions;
	public static Select select;
	public static JavascriptExecutor javscriptexecutor;
	public static File f;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fout;
	public static FileInputStream fin;

	/* This method is loading the Browser */
	public static void loadBrowser(String browserType) {
		if (browserType.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserType.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserType.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

	}

	/* This method is for maximizing the browser Window */
	public static void maximizeBrowser() {
		driver.manage().window().maximize();

	}

	/*
	 * This method is to apply Implicit wait - Dynamic wait Time applied for all
	 * Webelements
	 */
	public static void applyWaitToAllElements() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	/* To launch the Url */
	public static void launchUrl(String url) {
		driver.get(url);

	}

	/* To pause the execution for given milliseconds */
	public static void pauseExecution(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	/* To return te current Webpage Title */
	public static String getWebpageTitle() {
		String title = driver.getTitle();
		return title;

	}

	/* To return the current webpage Url */
	public static String getWebUrl() {
		return driver.getCurrentUrl();

	}

	/* To quit the browser */
	public static void quitBrowser() {
		driver.quit();

	}

	/* To close the current Window */
	public static void closeCurrentWindow() {
		driver.close();

	}

	/* To enter text into a WebElement */
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);

	}

	/* To Click a WebElement */
	public static void clickElement(WebElement element) {
		element.click();

	}

	/* To move Cursor over particular element */
	public static void moveCursorOverElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	/* To perform Drag and Drop Action */
	public static void dragAndDropElement(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();

	}

	/* To Select a Value from dropdown using visible text */
	public static void selectDropDownUsingText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);

	}

	/* To select a value from dropdown using value */
	public static void selectDropDownUsingValue(WebElement element, String text) {
		select = new Select(element);
		select.selectByValue(text);

	}

	/* To get Attribute value */
	public static String getAttributeValueOfWebelement(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	/* To scrollUp via JavascriptExecutor */
	public static void scrollUpUsingJavascriptExecutor(WebElement element) {
		javscriptexecutor = (JavascriptExecutor) driver;
		javscriptexecutor.executeScript("arguments[0]).ScrollIntoView(true)", element);

	}

	/* To scrollDown via JavascriptExecutor */
	public static void scrollDownUsingJavascriptExecutor(WebElement element) {
		javscriptexecutor = (JavascriptExecutor) driver;
		javscriptexecutor.executeScript("arguments[0]).ScrollIntoView(false)", element);

	}

	/* To get value via JavascriptExecutor */
	public static Object getAttributeUsingJavascriptExecutor(WebElement element) {
		javscriptexecutor = (JavascriptExecutor) driver;
		Object executeScript = javscriptexecutor.executeScript("return arguments[0].getAttribute('value')", element);
		return executeScript;

	}

	/* To click using JavascriptExecutor */
	public static void clickUsingJavascriptExecutor(WebElement element) {
		javscriptexecutor = (JavascriptExecutor) driver;
		javscriptexecutor.executeScript("arguments[0].click()", element);

	}

	/* To get text from WebElement */
	public static String getTextFromWebelement(WebElement element) {
		String text = element.getText();
		return text;

	}

	/* To read particular cell from excel and return value as String */
	public static String readDataFromExcel(int rowNo, int cellNo) throws IOException {
		// Mention file Folder location
		File f = new File("C:\\Users\\hp\\eclipse-workspace\\JunitTask\\Workbook\\Q1.xlsx");

		// To read a file, we need FileInputStream Class
		FileInputStream fin = new FileInputStream(f);

		// Workbook (Interface) Instanciation
		Workbook w = new XSSFWorkbook(fin);

		// To get particular Sheet from Workbook
		Sheet s = w.getSheet("Data");

		// To get each row
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);

		// To get Cells Datatype
		int type = c.getCellType();

		String cellValue = "";  // create a variable for string  if cell type is string store it in the variable

		if (type == 1) {
			// Cell contains String Type
			cellValue = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			// Cell contains Date format
			Date d = c.getDateCellValue();
			System.out.println(d);

			// To Modify date format into required format ----Simple Date Format
			// dd-MMM-yyyy to dd-MM-yyyy

			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			cellValue = sim.format(d);

		} else {
			// Cell contains Number format
			double dd = c.getNumericCellValue();

			// Typecasting--------NewDataType NewVariable=(NewDatatype)oldvariable;
			long l = (long) dd;
			// To convert any datatype into String
			cellValue = String.valueOf(l);
		}
		return cellValue;

	}

	/* To update particular cell in excel */
	public static void updationInExcel(int rowNo, int cellNo, String data) throws IOException {
		f = new File("C:\\Users\\hp\\eclipse-workspace\\JunitTask\\Workbook\\Q1.xlsx");
		fin = new FileInputStream(f);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet("Data");
		row = sheet.getRow(rowNo);
		cell = row.createCell(cellNo);
		cell.setCellValue(data);
		fout = new FileOutputStream(f);
		workbook.write(fout);
	}

	/* To write particular cell in excel */
	public static void createExcelRowAndCell(int rowNo, int cellNo, String data) throws IOException {
		f = new File("C:\\Users\\hp\\eclipse-workspace\\JunitTask\\Workbook\\Q1.xlsx");

		if (rowNo == 0 && cellNo == 0) {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Data");
			row = sheet.createRow(rowNo);
			cell = row.createCell(cellNo);

		} else if (rowNo >= 0 && cellNo > 0) {
			fin = new FileInputStream(f);
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheet("Data");
			row = sheet.getRow(rowNo);
			cell = row.createCell(cellNo);

		} else if (rowNo > 0 && cellNo == 0) {
			fin = new FileInputStream(f);
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheet("Data");
			row = sheet.createRow(rowNo);
			cell = row.createCell(cellNo);

		}
		cell.setCellValue(data);
		fout = new FileOutputStream(f);
		workbook.write(fout);

	}

}
