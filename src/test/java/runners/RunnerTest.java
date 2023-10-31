package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"}, // Путь к директории с feature-файлами
        glue = {"stepDefinitions"},// Пакет, где находятся реализации шагов (step definitions)
        tags = "not @purchase"
)
public class RunnerTest {
}