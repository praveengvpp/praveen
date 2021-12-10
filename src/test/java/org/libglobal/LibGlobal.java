package org.libglobal;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {

	public static WebDriver driver;

	public String getDataFromExcel(String sheet, int row, int cell) throws IOException {
		String value = null;
		File excelLoc = new File("C:\\Users\\my pc\\eclipse-workspace\\MavenCreation\\Excel\\Book 5 (1).xlsx");
		FileInputStream stream = new FileInputStream(excelLoc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType();
		if (type == 1) {
			value = c.getStringCellValue();
		}
		if (type == 0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyy");
				value = sim.format(d);
			} else {
				double cellValue = c.getNumericCellValue();
				long l = (long) cellValue;
				value = String.valueOf(l);
			}
		}
		return value;
	}

	public void writeExcel(String pathname, String data) throws IOException {
		File excelLoc = new File(pathname);
		Workbook w = new XSSFWorkbook();
		Sheet createSheet = w.createSheet("Sheet1");
		Row createRow = createSheet.createRow(0);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(excelLoc);
		w.write(stream);
	}

	public WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void loadUrl(String url) {
		driver.get(url);
	}

	public void setText(WebElement e, String data) {
		e.sendKeys(data);
	}

	public void btnClick(WebElement e) {
		e.click();
	}

	public void selectByValue(WebElement e, String data) {
		Select s = new Select(e);
		s.selectByValue(data);

	}
	
	public void selectOptionByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void thread(long l) throws InterruptedException {
		Thread.sleep(l);
	}

	public String getAttribute(WebElement e, String name) {
		String attribute = e.getAttribute(name);
		return attribute;
	}

	public void quitBrowser() {
		driver.quit();
	}
}
