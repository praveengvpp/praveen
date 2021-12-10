package PageFactory;

import org.libglobal.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LibGlobal {
	
	public LoginPage() {
		
		 PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement txtusername;
	
	@FindBy(name = "password")
	private WebElement txtpassword;
	
	@FindBy(name = "login")
	private WebElement btnlogin;
	
}
