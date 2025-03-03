import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class ModuleTest {
    private WebDriver webDriver;

    @BeforeEach
    public void config(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Test
    public void test1(){
        webDriver.get("https://mat-tech.vstu.by/home");
        WebElement webElement = webDriver.findElement(By.linkText("Контакты"));
        webElement.click();

        String waitLink = "https://mat-tech.vstu.by/home/contacts";
        String resultLink = webDriver.getCurrentUrl();
        assertEquals(waitLink, resultLink);
        webDriver.quit();
    }

    @Test
    public void test2(){
        webDriver.get("https://mat-tech.vstu.by/home");
        WebElement webElement = webDriver.findElement(By.linkText("Этика"));
        webElement.click();

        String waitLink = "https://mat-tech.vstu.by/home/editorial_policy";
        String resultLink = webDriver.getCurrentUrl();
        assertEquals(waitLink, resultLink);
        webDriver.quit();
    }

    @Test
    public void test3(){
        webDriver.get("https://mat-tech.vstu.by/home/editorial_office");
        WebElement webElement = webDriver.findElement(By.className("login-logout-link"));
        webElement.click();

        String waitLink = "https://mat-tech.vstu.by/login";
        String resultLink = webDriver.getCurrentUrl();
        assertEquals(waitLink, resultLink);
        webDriver.quit();
    }

    @Test
    public void test4(){
        webDriver.get("https://mat-tech.vstu.by/login");
        WebElement webSubmitElement = webDriver.findElement(By.cssSelector(".btn.btn-primary"));
        webSubmitElement.click();

        String waitLink = "https://mat-tech.vstu.by/login/authenticate/concrete";
        String resultLink = webDriver.getCurrentUrl();
        assertEquals(waitLink, resultLink);
        webDriver.quit();
    }

    @Test
    public void test5() {
        webDriver.get("https://mat-tech.vstu.by/login");
        WebElement webSubmitElement = webDriver.findElement(By.cssSelector(".btn.btn-primary"));
        webSubmitElement.click();
        WebElement webCloseAlertElement = webDriver.findElement(By.className("close"));
        webCloseAlertElement.click();
        assertThrows(NoSuchElementException.class, () -> {
            webDriver.findElement(By.className("Close"));
        });

        webDriver.quit();
    }

    @Test
    public void test6() {
        webDriver.get("https://mat-tech.vstu.by/home");
        WebElement webSearchElement = webDriver.findElement(By.name("query"));
        WebElement webSubmitSearchElement = webDriver.findElement(By.name("submit"));
        webSearchElement.sendKeys("Редакция");
        webSubmitSearchElement.click();
        WebElement webResultSearchElement = null;
        try {
            webResultSearchElement = webDriver.findElement(By
                    .xpath("//a[contains(text(),'Редакция') and @href='https://mat-tech.vstu.by/home/editorial_office']"));
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден!");
        }
        assertNotNull(webResultSearchElement);
        webDriver.quit();
    }

    @Test
    public void test7(){
        webDriver.get("https://mat-tech.vstu.by/home");
        WebElement webElement = webDriver.findElement(By.id("ccm-region-flag-gb"));
        webElement.click();

        String waitLink = "https://mat-tech.vstu.by/home-eng";
        String resultLink = webDriver.getCurrentUrl();
        assertEquals(waitLink, resultLink);
        webDriver.quit();
    }

    @Test
    public void test8(){
        webDriver.get("https://mat-tech.vstu.by/home-eng");
        WebElement webSearchElement = webDriver.findElement(By.name("query"));
        WebElement webSubmitSearchElement = webDriver.findElement(By.name("submit"));
        webSearchElement.sendKeys("Ethics");
        webSubmitSearchElement.click();
        WebElement webResultSearchElement = null;
        try {
            webResultSearchElement = webDriver
                    .findElement(By.xpath("//*[contains(text(), 'There were no results found. Please try another keyword or phrase.')]"));
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден!");
        }
        assertNotNull(webResultSearchElement);
        webDriver.quit();
    }
    @Test
    public void test9() {
        webDriver.get("https://mat-tech.vstu.by/home");
        WebElement webSubmitSearchElement = webDriver.findElement(By.name("submit"));
        webSubmitSearchElement.click();
        WebElement webResultSearchElement = null;
        try {
            webResultSearchElement = webDriver
                    .findElement(By.xpath("//*[contains(text(), 'There were no results found. Please try another keyword or phrase.')]"));
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден!");
        }
        assertNotNull(webResultSearchElement);

    }

    @Test
    public void test10() throws InterruptedException {
        webDriver.get("https://mat-tech.vstu.by/home");
        Actions actions = new Actions(webDriver);
        WebElement webHiddenLinkElement = null;
        try {
            webHiddenLinkElement = webDriver
                    .findElement(By.xpath("//*[contains(text(), 'Выпуск № 1 (13), 2024')]"));
        } catch (InvalidSelectorException e) {
            System.out.println("Элемент не найден!");
        }
        assertNull(webHiddenLinkElement);
        webDriver.quit();
    }
}
