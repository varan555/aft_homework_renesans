import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //, "json:target/allure-results/" {"pretty"}
        plugin = {"pretty", "json:target/allure-results/results.json"},
        glue = {"steps"},
        features = {"src/test/resources/"}
        )
public class CucumberRunner {}
