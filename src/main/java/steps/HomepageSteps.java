package steps;

import cucumber.api.java.en.When;
import pages.CommonPage;
import pages.Homepage;

public class HomepageSteps {

private final Homepage homepage;
private final CommonPage commonPage;
String enteredPlayerName;

    public HomepageSteps(Homepage homepage, CommonPage commonPage) {
        this.homepage = homepage;
        this.commonPage = commonPage;
    }

    @When("I enter the name (.*)")
    public void iEnterName(String playerName) {
        enteredPlayerName = playerName;
        homepage.enterName(playerName);
        commonPage.startButton.click();
    }
}
