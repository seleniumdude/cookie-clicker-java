package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BasePageObject;
import selenium.WebDriverHandler;

public class GamePage extends BasePageObject {

    @FindBy(tagName=("p"))
    private WebElement bodyText;

    @FindBy(xpath = "//button[contains(text(),'Click Cookie!')]")
    public WebElement cookieClickerButton;

    @FindBy(id = "cookies")
    public WebElement cookiesCounterValue;

    public GamePage(WebDriverHandler driverHandler) {
        super(driverHandler);
        PageFactory.initElements(driverHandler.getDriver(), this);
    }

    public String getBodyText() {
        return bodyText.getText();
    }

    public int getCookiesCounterValue() {
        return Integer.parseInt(cookiesCounterValue.getText());
    }

}
