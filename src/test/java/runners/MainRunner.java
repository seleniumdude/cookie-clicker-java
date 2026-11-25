package runners;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/NewPlayer-HappyPath.feature"},
        glue = {"steps"},
        tags = "@test",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}

)
public class MainRunner {

}

