import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //, "json:target/allure-results/" {"pretty"}
        plugin = {"pretty"},
        glue = {"steps"},
        features = {"src/test/resources/"}
        )
public class CucumberRunner {}
