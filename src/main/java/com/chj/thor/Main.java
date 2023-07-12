package com.chj.thor;

import com.google.common.base.Stopwatch;
import javafx.scene.paint.Stop;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/4 14:13
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        Stopwatch timer = Stopwatch.createStarted();
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = new ChromeDriver(chromeOptions);
        System.out.println("init=" + timer.elapsed(TimeUnit.SECONDS));


        timer.reset();
        timer.start();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.baidu.com");
        System.out.println("get=" + timer.elapsed(TimeUnit.SECONDS));

        timer.reset();
        timer.start();
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        System.out.println("find=" + timer.elapsed(TimeUnit.SECONDS));


        timer.reset();
        timer.start();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").value = \"hello\"");
        System.out.println("sendKyes1=" + timer.elapsed(TimeUnit.SECONDS));


        timer.reset();
        timer.start();
        js.executeScript("document.getElementById(\"su\").click()");
        System.out.println("sendKyes2=" + timer.elapsed(TimeUnit.SECONDS));

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Thread.sleep(10*1000);
//        driver.quit();

        /**
         * init=3
         * get=0
         * find=0
         * sendKyes1=13
         * sendKyes2=25
         *
         *
         * init=7
         * get=0
         * find=0
         * sendKyes1=0
         * sendKyes2=0
         */
    }
}