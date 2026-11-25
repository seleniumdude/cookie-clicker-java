package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selenium.WebDriverHandler;


public class Hooks {
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

    private final WebDriverHandler webDriverHandler;

    public Hooks(WebDriverHandler webDriverHandler) {
        this.webDriverHandler = webDriverHandler;
    }


    @Before("@test")
    public void initWebDriver() {
        webDriverHandler.initWebDriver();
        webDriverHandler.getDriver().manage().window().maximize();
    }

    @After("@test")
    public void afterTestRun()
    {
        webDriverHandler.destroyDriver();
    }
}