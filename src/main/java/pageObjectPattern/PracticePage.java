package pageObjectPattern;

import org.openqa.selenium.support.PageFactory;

import base.Base;

public class PracticePage extends Base {
	
	
	
	
	
	
	public PracticePage() {
		
		PageFactory.initElements(driver, this);
	}

}
