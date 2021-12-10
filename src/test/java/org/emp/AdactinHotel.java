package org.emp;

import java.io.IOException;

import org.libglobal.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class AdactinHotel extends LibGlobal {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		LibGlobal lib = new LibGlobal();
		
		WebDriver driver = lib.launchBrowser();
		
		lib.loadUrl("http://adactinhotelapp.com/index.php");
		
		WebElement txtUsername = driver.findElement(By.name("username"));
		lib.setText(txtUsername, lib.getDataFromExcel("AdactinHotel", 1, 8));
		
		WebElement txtPassword = driver.findElement(By.name("password"));
		lib.setText(txtPassword, lib.getDataFromExcel("AdactinHotel", 1, 9));
		
		WebElement btnLogin = driver.findElement(By.id("login"));
		lib.btnClick(btnLogin);
		
		lib.thread(500);
		
		WebElement Location = driver.findElement(By.id("location"));
		lib.selectByValue(Location, lib.getDataFromExcel("Adactin", 3, 2));
		
		lib.thread(100);
		WebElement Hotels = driver.findElement(By.id("hotels"));
		lib.selectByValue(Hotels, lib.getDataFromExcel("Adactin", 3, 3));
		
		WebElement Roomtype = driver.findElement(By.id("room_type"));
		lib.selectByValue(Roomtype, lib.getDataFromExcel("Adactin", 3, 4));
		
		lib.thread(100);
		WebElement RoomQty = driver.findElement(By.id("room_nos"));
		lib.selectOptionByVisibleText(RoomQty,lib.getDataFromExcel("Adactin", 3, 5));
		
		WebElement numberofPerson = driver.findElement(By.id("adult_room"));
		lib.selectOptionByVisibleText(numberofPerson, lib.getDataFromExcel("Adactin", 1, 6));
		
		WebElement numberofChild = driver.findElement(By.id("child_room"));
		lib.selectOptionByVisibleText(numberofChild, lib.getDataFromExcel("Adactin", 2, 7));
		
		WebElement btnSubmit = driver.findElement(By.id("Submit"));
		lib.btnClick(btnSubmit);
		
		WebElement btnradio = driver.findElement(By.id("radiobutton_0"));
		lib.btnClick(btnradio);
		
		WebElement btnClick = driver.findElement(By.id("continue"));
		lib.btnClick(btnClick);
		
		WebElement txtFirstname = driver.findElement(By.id("first_name"));
		lib.setText(txtFirstname, lib.getDataFromExcel("Adactin", 2, 8));
		
		WebElement txtLastname = driver.findElement(By.id("last_name"));
		lib.setText(txtLastname, lib.getDataFromExcel("Adactin", 2, 9));
		
		WebElement txtAddress = driver.findElement(By.id("address"));
		lib.setText(txtAddress, lib.getDataFromExcel("Adactin", 2, 10));
		
		WebElement txtCC = driver.findElement(By.id("cc_num"));
		lib.setText(txtCC, lib.getDataFromExcel("Adactin", 1, 11));
		
		WebElement CardType = driver.findElement(By.id("cc_type"));
		lib.selectOptionByVisibleText(CardType, lib.getDataFromExcel("Adactin", 2, 12));
		
		WebElement CCMonth = driver.findElement(By.id("cc_exp_month"));
		lib.selectOptionByVisibleText(CCMonth, lib.getDataFromExcel("Adactin", 1, 13));
		
		WebElement CCYear = driver.findElement(By.id("cc_exp_year"));
		lib.selectOptionByVisibleText(CCYear, lib.getDataFromExcel("Adactin", 12, 14));
		
		WebElement txtCcvv = driver.findElement(By.id("cc_cvv"));
		lib.setText(txtCcvv, lib.getDataFromExcel("Adactin", 1, 15));
		
		WebElement btnClick2 = driver.findElement(By.id("book_now"));
		lib.btnClick(btnClick2);
		
		
		lib.thread(6000);
		WebElement txtOrderno = driver.findElement(By.id("order_no"));
		String attribute = lib.getAttribute(txtOrderno, "value");
		System.out.println(attribute);
		
		lib.thread(6000);
		lib.quitBrowser();
	}
}
