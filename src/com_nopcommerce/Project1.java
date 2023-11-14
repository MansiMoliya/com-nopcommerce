package com_nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */
public class Project1 {
    static String browser="Chrome";
    static String baseUrl="https://demo.nopcommerce.com/";
    public static void main(String[] args){

        WebDriver driver=new ChromeDriver();
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser");
        }
        //Open the URL into Browser
        driver.get(baseUrl);
        //maximize the screen
        driver.manage().window().maximize();
        //we give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Get the title of the page.
        String title=driver.getTitle();
        System.out.println(title);
        //Print the Current URl
        System.out.println("The Current URL: "+driver.getCurrentUrl());
        //Print the page source
        System.out.println(driver.getPageSource());
        //Navigate to URL
        String loginURL="https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginURL);

        //Current Url
        System.out.println("The Current URl: "+driver.getCurrentUrl());

        //Navigate back to home page
        driver.navigate().back();
        //Navigate Login page
        driver.navigate().to(loginURL);
        //Current URl
        System.out.println("The Current URL"+driver.getCurrentUrl());
        //Refresh the page
        driver.navigate().refresh();

        //Enter the Email to email field
        WebElement emailfield=driver.findElement(By.id("Email"));
        emailfield.sendKeys("mansibhalala7@gmail.com");

        //Enter the password to password field
        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("1234@err");

        //Click on login Button
        WebElement loginButton=driver.findElement(By.cssSelector(".login-button"));
        loginButton.click();

        //System.out.println("The current Url: "+baseUrl);
        //close the browser
        driver.quit();




    }
}
