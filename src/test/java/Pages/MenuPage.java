package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement greenTeaTitle;
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	private WebElement checkOutButtonGreenTea;
	
	public String checkGreenTeaTitle() {
		return greenTeaTitle.getText();
	}
	
	public void goToCheckOut() {
		checkOutButtonGreenTea.click();
	}
	
}
