package runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/NewPlayer-HappyPath.feature"},
        glue = {"steps"},
        tags = {"@test"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}

)
public class MainRunner {

}

