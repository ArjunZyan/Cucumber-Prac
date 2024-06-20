package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = "src/test/java/features/textbox2.feature",
		dryRun = !true,
		glue="steps",
		snippets = SnippetType.CAMELCASE
		
		)





public class Runner extends AbstractTestNGCucumberTests{

}
