package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Ruta al archivo .feature
    glue = "stepDefinitions", // Paquete donde están las definiciones de pasos
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-html"} // Reportes
)
public class TestRunner {
}
