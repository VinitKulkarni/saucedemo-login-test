package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauceDemoLoginTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.out.println("========== TEST STARTED ==========");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    @Test
    public void loginTest() {
        System.out.println("===== Opening SauceDemo website ======");

        driver.get("https://sarvalinks.com/sign-up/");
        
        
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("TestVinit");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("TestKulkarni");
		driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("9964384321");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vinitkkulkarni@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//button[text()='Submit »']")).click();

        System.out.println("======= SauceDemo Login Test PASSED =======");
    }

    @AfterEach
    public void tearDown() {
         System.out.println("===== Closing ======");

        if (driver != null) {
            driver.quit();
        }
    }
}
