package com.chj.thor;

import com.chj.thor.whv.page.CaptchaPage;
import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/5 10:27
 */
public class HCaptchaDemo {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeOptions.addExtensions(new File("/Users/wanglianhai/sea/opt/selenium/captcha_plugin.zip"));
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), chromeOptions);
        driver.get("https://onlineservices.immigration.govt.nz/rs-captcha");

        WebElement ifFrame = driver.findElement(By.cssSelector("#ContentPlaceHolder1_preSubmitPanel > div:nth-child(3) > div > iframe"));
        if (ifFrame != null) {
            driver.switchTo().frame(ifFrame);

            while (true) {
                WebElement anchor = driver.findElement(By.id("checkbox"));
                String attribute = anchor.getAttribute("aria-checked");
                if (Boolean.valueOf(attribute) == true) {
                    break;
                }
                System.out.println("当前识别状态：" + attribute);
                Thread.sleep(10000);
            }
            driver.switchTo().defaultContent();
        }

    }
}
