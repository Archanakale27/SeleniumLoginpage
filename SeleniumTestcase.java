package Selenimuncode;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumTestcase {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 1 = open url
        driver.get("https://practice.automationtesting.in/my-account/");
        takeSreenshot("1LoginPage");

        //step 2 = login with username and password
        driver.findElement(By.id("username")).sendKeys("kalearchana2@gmail.com");

        driver.findElement(By.id("password")).sendKeys("ARCHANA#KALE");
        driver.findElement(By.name("login")).click();
        takeSreenshot("2userloginpage");

        //step 3 = click on shop page
        driver.findElement(By.linkText("Shop")).click();
        takeSreenshot("3shoppingPage");

        //step4 = click on android product
        driver.findElement(By.linkText("Android")).click();
        takeSreenshot("4AndroidPage");

        //step 5 = add to basket
        driver.findElement(By.xpath("//a[contains(@href,'android')]//following-sibling::a")).click();
        takeSreenshot("5Addto basket");

        //step 6 = click on view basket
        driver.findElement(By.linkText("View Basket")).click();
        takeSreenshot("6viewbasket");

        //step 7 = click on proceed to checkout
        driver.findElement(By.xpath("//a[contains(@href,'checkout')]")).click();
        takeSreenshot("7checkoutpage");    }
    public static void takeSreenshot(String stage) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File destination = new File("screenshots/myScreenshot" + stage + ".jpg");

        FileUtils.copyFile(file, destination);
    }

    }
