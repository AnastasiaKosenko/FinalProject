package loginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver webDriver;
    @Test
    public void validLogIn(){
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://parfums.ua/");
        System.out.println("Site was opened");

        webDriver.findElement(By.xpath(".//button[@class='profile js-profile_desktop js_profile_user_name']")).click();
        webDriver.findElement(By.xpath(".//button[@class='checkout-button-main-l--login']")).click();

        webDriver.findElement(By.xpath(".//input[@id=\'login\']")).clear();
        webDriver.findElement(By.xpath(".//input[@id=\"login\"]")).sendKeys("people.1198@gmail.com");
        System.out.println("'people.1198@gmail.com' was inputted into EmailInput");

        webDriver.findElement(By.xpath(".//input[@id=\'password\']")).clear();
        webDriver.findElement(By.xpath(".//input[@id=\'password\']")).sendKeys("finalproject");
        System.out.println("'finalproject' was inputted into InputPass");

        webDriver.findElement(By.xpath(".//button[@class='checkout-button-main-l--login']")).click();
        System.out.println("Button SignIn was clicked");


        Assert.assertTrue("Button SignOut is not displayed", isButtonSignOutVisible());
        //webDriver.quit();
    }
    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class=\'profile js-profile_desktop js_profile_user_name\']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
