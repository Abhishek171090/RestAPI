package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
   //path of feature file
   features = "src/test/resources/",
   //path of step definition file
   glue = "com.org.stepdef"
   )
public class TestRunner {

}
