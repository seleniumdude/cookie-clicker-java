package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BasePageObject;
import selenium.WebDriverHandler;


public class CommonPage extends BasePageObject {

    @FindBy(xpath = "//button[contains(text(),'Start!')]")
    public WebElement startButton;

    //Constructor for connection between commonpage and basepage
    public CommonPage(WebDriverHandler webDriverHandler) {
        super(webDriverHandler);
        //initialising driver on page
        PageFactory.initElements(webDriverHandler.getDriver(), this);

    }

    public void openURL(String baseurl) {
        openPage(baseurl);
    }

}

