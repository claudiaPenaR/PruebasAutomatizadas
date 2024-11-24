package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;

    @Given("el usuario se encuentra en la página de login")
    public void el_usuario_se_encuentra_en_la_página_de_login() {
        // Configuración de la ruta del ChromeDriver
    	 // Configuración de GeckoDriver
        System.setProperty("webdriver.gecko.driver", "C:/Users/HP/Drivers/geckodriver.exe"); // Cambia la ruta según corresponda

        // Opciones para Firefox (opcional)
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options); // Inicializar Firefox con las opciones

        // Abrir la URL de la página de login
        driver.get("https://the-internet.herokuapp.com/login"); // Cambia esta URL por la de tu aplicación de pruebas
    }

    @When("ingresa el nombre de usuario y la contraseña válidos")
    public void ingresa_el_nombre_de_usuario_y_la_contraseña_válidos() {
        // Datos simulados (puedes sustituirlos por datos de una base de datos si es necesario)
        String username = "usuarioValido";
        String password = "contraseñaValida";

        // Interactuar con los elementos de la página
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click(); // Botón para enviar el formulario
    }

    @Then("debe ser redirigido a la página principal")
    public void debe_ser_redirigido_a_la_página_principal() {
        // URL esperada después del login exitoso
        String expectedUrl = "https://the-internet.herokuapp.com/secure"; // Cambia esta URL según tu caso

        // Verificar que la URL actual sea la esperada
        assertEquals(expectedUrl, driver.getCurrentUrl());

        // Cerrar el navegador al finalizar
        driver.quit();
    }
}
