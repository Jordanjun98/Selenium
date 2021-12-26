package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

class BaseTest {

    WebDriver obj;

    @BeforeEach
    void setUp() {

        System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");

        obj = new FirefoxDriver();

    }


    @Test
    void main() {
        WebDriverWait wait = new WebDriverWait(obj, 30);
        obj.get("https://demowebshop.tricentis.com");
//        obj.findElement(By.xpath("//a[@href='/apparel-shoes']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/apparel-shoes']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/blue-and-green-sneaker']"))).click();

//        obj.findElement(By.xpath("//div[@id='add-to-cart-button-28']//a[@href='/addproducttocart/details/28/1']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id^='add-to-cart-button']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-28"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("shopping cart"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.name("itemquantity1949103"))).sendKeys("3");

        String quantity="3";

        WebElement strLocator = obj.findElement(By.xpath("//*[@class='qty-input']"));
        strLocator.sendKeys(quantity);


        wait.until(ExpectedConditions.elementToBeClickable(By.name("continueshopping"))).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/desktops']"))).click();

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@ src='http://demowebshop.tricentis.com/content/images/thumbs/0000232_notebooks_125.png']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/build-your-own-computer']"))).click();

        WebElement radio1  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_attribute_16_3_6_18")));
        radio1.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-16"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("shopping cart"))).click();

        Select countrySelect  = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CountryId"))));
        countrySelect.selectByVisibleText("Malaysia");

        Select stateSelect  = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("StateProvinceId"))));
        stateSelect.selectByValue("0");
//        countryDrop.selectByValue("52");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ZipPostalCode"))).sendKeys("43200");

        wait.until(ExpectedConditions.elementToBeClickable(By.name("estimateshipping"))).click();




        wait.until(ExpectedConditions.elementToBeClickable(By.id("termsofservice"))).click();

        WebElement option1 = obj.findElement(By.id("termsofservice"));

        System.out.println(option1.isSelected() ? "Check box is selected" : "Checkbox is not selected");


        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("BOOKS"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h2.product-title a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id^='add-to-cart-button']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("shopping cart"))).click();
        Select select  = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CountryId"))));
        select.selectByVisibleText("Malaysia");
        select.selectByValue("52");


        obj.close();


    }

    @AfterEach
    void tearDown() {
    }


}