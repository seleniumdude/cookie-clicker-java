package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import java.util.logging.Logger;


public abstract class BasePageObject {

    protected static final Logger LOG = LoggerFactory.getLogger(BasePageObject.class);

    private final WebDriverHandler webDriverHandler;

    public BasePageObject(WebDriverHandler webDriverHandler) {
        this.webDriverHandler = webDriverHandler;
    }

    public WebDriver driver()
    {
        return this.webDriverHandler.getDriver();
    }

    public void openPage(String baseurl) {
        LOG.info("Navigating to URL: {}", baseurl);
        this.driver().get(baseurl);
        LOG.info("URL opened: " + this.driver().getCurrentUrl());
    }

//    public String getUrl() {
//        try {
//            return driver().getCurrentUrl();
//        } catch (Exception e) {
//            throw e;
//        }
//    }

    public void sendKey(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            throw e;
        }
    }
}
