package steps;

import config.EnvironmentHandler;
import io.cucumber.java.en.Given;
import pages.CommonPage;
import pages.Homepage;
import pages.PageObjectManager;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

    private final PageObjectManager pageObjectManager;
    private final Homepage homepage;
    private final EnvironmentHandler environmentHandler;
    private final CommonPage commonPage;
    String urlString = "https://hamza-khan-2022-05-06.cookieclickertechtest.airelogic.com/";


    public CommonSteps(PageObjectManager pageObjectManager, Homepage homepage, EnvironmentHandler environmentHandler, CommonPage commonPage) {
        this.pageObjectManager = pageObjectManager;
        this.homepage = homepage;
        this.environmentHandler = environmentHandler;
        this.commonPage = commonPage;
    }


    @Given("I access the cookie clicker start screen")
    public void iAccessCookieClickerHomepage() throws Throwable {
        String baseurl = environmentHandler.valueOf("base.url");
        commonPage.openURL(baseurl);
        assertThat(homepage.getHeaderText()).isEqualTo("Cookie Clicker!");
    }
}
