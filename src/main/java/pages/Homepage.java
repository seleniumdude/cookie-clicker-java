package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BasePageObject;
import selenium.WebDriverHandler;

public class Homepage extends BasePageObject {

    @FindBy(tagName=("h1"))
    private WebElement headerText;

    @FindBy(name=("name"))
    public WebElement nameTextbox;



    public Homepage(WebDriverHandler driverHandler) {
        super(driverHandler);
        PageFactory.initElements(driverHandler.getDriver(), this);
    }

    public String getHeaderText() {
        return headerText.getText();
    }

    public void enterName(String playerName) {
        sendKey(nameTextbox, playerName);
    }


}
