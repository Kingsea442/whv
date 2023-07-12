package com.chj.thor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/5 10:27
 */
public class GoogleCaptchaDemo {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
//        chromeOptions.addExtensions(new File("/Users/wanglianhai/sea/opt/selenium/captcha_plugin.zip"));
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), chromeOptions);
        driver.get("https://www.google.com/recaptcha/api2/demo");
//        driver.findElement(By.id("input1")).sendKeys("WANG");
//        driver.findElement(By.id("input2")).sendKeys("XIAOHEI");
//        driver.findElement(By.id("input3")).sendKeys("xxxxx@163.com");
//        driver.findElement(By.id("option1")).clear();

        WebElement ifFrame = driver.findElement(By.cssSelector("iframe[src*=\"anchor\"]"));
        driver.switchTo().frame(ifFrame);

        while (true) {
            WebElement anchor = driver.findElement(By.id("recaptcha-anchor"));
            String attribute = anchor.getAttribute("aria-checked");
            if (Boolean.valueOf(attribute) == true) {
                break;
            }
            System.out.println("当前识别状态：" + attribute);
            Thread.sleep(1000);
        }

        driver.switchTo().defaultContent();
        driver.findElement(By.id("recaptcha-demo-submit")).click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.quit();
    }
}
