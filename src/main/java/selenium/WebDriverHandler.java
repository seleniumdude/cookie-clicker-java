package selenium;
import config.EnvironmentHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

import java.util.concurrent.TimeUnit;

public class WebDriverHandler {
    private static final Logger LOG = LoggerFactory.getLogger(WebDriverHandler.class);

    private final EnvironmentHandler env;

    public WebDriver driver;
    private static final long PAGE_LOAD_TIMEOUT = 10;
    private static final long IMPLICIT_WAIT = 5;

    public WebDriverHandler(EnvironmentHandler environmentHandler) {
        this.env = environmentHandler;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void initWebDriver() {
        String browserName = StringUtils.defaultIfBlank(env.valueOf("browser"), "chrome");
        System.out.println("Getting driver for " + browserName);

        WebDriver driver;
        switch (browserName) {
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                if (StringUtils.equalsIgnoreCase(env.valueOf("headless.mode"), "true")) {
                    options.addArguments("-headless");
                }
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(options);
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability("EnableNativeEvents", false);
                internetExplorerOptions.setCapability("ignoreZoomSetting", true);
                internetExplorerOptions.setAcceptInsecureCerts(true);
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;

            default:
                driver = getChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));        this.driver = driver;
    }

    private WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        if (StringUtils.equalsIgnoreCase(env.valueOf("headless.mode"), "false")) {
            options.addArguments("--headless=new");
            options.addArguments("no-sandbox");
            options.addArguments("disable-dev-shm-usage");
        }
        {
            options.setAcceptInsecureCerts(true);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            return driver;
        }
    }

    public void destroyDriver() {
        LOG.info("Quitting driver");
    if (driver!= null) {
        driver.quit();
        driver = null;
    }
}

}