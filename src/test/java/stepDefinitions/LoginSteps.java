package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;  // Importa Duration

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;

    @Given("el usuario se encuentra en la página de login")
    public void el_usuario_se_encuentra_en_la_página_de_login() {
        System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver.exe"); // Ajusta la ruta
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("ingresa el nombre de usuario y la contraseña válidos")
    public void ingresa_el_nombre_de_usuario_y_la_contraseña_válidos() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        // Esperar hasta que el botón de login sea clickeable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));

        // Hacer clic en el botón de login
        driver.findElement(By.id("login-button")).click();
    }

    @Then("debe ser redirigido a la página principal")
    public void debe_ser_redirigido_a_la_página_principal() {
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        assertEquals(expectedUrl, driver.getCurrentUrl());
        driver.quit();
    }
}