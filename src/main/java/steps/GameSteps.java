package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.GamePage;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSteps {

    private final GamePage gamePage;
    private final HomepageSteps homepageSteps;

    int cookiesCollected;

    public GameSteps(GamePage gamePage, HomepageSteps homepageSteps) {
        this.gamePage = gamePage;
        this.homepageSteps = homepageSteps;
    }

    @And("the new cookie clicker game is started")
    public void newGameScreen() {
        assertThat(gamePage.getBodyText()).isEqualTo("Hello"+ " " + homepageSteps.enteredPlayerName);
    }

    @When("the cookie clicker button receives \"{int}\"")
    public void iClickCookieClicker(int numberOfClicks) throws InterruptedException {
        cookiesCollected = numberOfClicks;
        for (int i = 0; i < numberOfClicks; i++){
            //click the button
           gamePage.cookieClickerButton.click();
            //wait 2 seconds
            java.util.concurrent.TimeUnit.SECONDS.sleep(1);
    }}
    @When("the Cookies counter is updated accordingly")
    public void cookiesCounterUpdated()  {
        assertThat(gamePage.getCookiesCounterValue()).isEqualTo(cookiesCollected);
        }

}



