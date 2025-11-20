package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = {"src/test/java/features"},
glue = {"EcommerceStepDefinitions"},
plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"},
monochrome = true,
dryRun = false)
public class Runner extends AbstractTestNGCucumberTests{

}
