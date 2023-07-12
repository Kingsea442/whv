package com.chj.thor;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.*;

/**
 * https://onlineservices.immigration.govt.nz/
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/5 20:45
 */
public class WHVDemo {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException, MalformedURLException, ExecutionException {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
//        chromeOptions.setScriptTimeout(Duration.ofSeconds(5));
        chromeOptions.addExtensions(new File("/Users/wanglianhai/sea/opt/selenium/captcha_plugin.zip"));
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://onlineservices.immigration.govt.nz/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> driver.findElement(By.xpath("/html/body/div[1]/form/div/div[3]/div/div[2]/div[1]/input")));

        List<Future> futureList = Lists.newArrayList();
        Stopwatch started = Stopwatch.createStarted();
        System.out.println("*****登陆******");
        futureList.add(executorService.submit(() -> {
            firstResult.sendKeys("xiaohei123");
        }));

        futureList.add(executorService.submit(() -> {
            driver.findElement(By.xpath("/html/body/div[1]/form/div/div[3]/div/div[2]/div[2]/input")).sendKeys(
                    "7CzSzw8#+mhAMh2");
        }));

        for (Future future : futureList) {
            future.get();
        }
        driver.findElement(By.xpath("/html/body/div[1]/form/div/div[3]/div/div[2]/div[3]/input")).click();


        futureList.clear();
        System.out.println("*****列表*****");
        // pending 页面
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> driver.findElement(By.xpath("//*[@id=\"WHS_applicationsDataGrid\"]/tbody/tr[2]/td[2]/a"))).click();



        // 中间可能会出现验证码页面
        System.out.println("*****验证码******");
        try {
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
                    Thread.sleep(200);
                }
                driver.switchTo().defaultContent();
                driver.findElement(By.id("ContentPlaceHolder1_submitImageButton")).click();
            }
        } catch (Exception e) {

        }


        // STEP 1
        System.out.println("*****STEP1******");
        driver.findElement(By.xpath("//*[@id" +
                "=\"ContentPlaceHolder1_personDetails_familyNameTextBox\"]")).sendKeys("WANG");

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_personDetails_givenName1Textbox\"]")).sendKeys("XIAOHEI");
        driver.findElement(By.xpath("//*[@id=\"select2-chosen-1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-result-label-8\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"select2-chosen-2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-result-label-14\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_personDetails_dateOfBirthDatePicker_DatePicker\"]")).sendKeys("12 May, 1991");
//        driver.findElement(By.xpath("//*[@id=\"select2-chosen-3\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"select2-result-label-301\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_addressContactDetails_address_address1TextBox\"]")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_addressContactDetails_address_suburbTextBox\"]")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_addressContactDetails_address_cityTextBox\"]")).sendKeys("3");

        driver.findElement(By.xpath("//*[@id=\"select2-chosen-4\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-result-label-51\"]")).click();

//        driver.findElement(By.xpath("//*[@id=\"select2-chosen-5\"]")).sendKeys("Yes");
//        driver.findElement(By.xpath("//*[@id=\"select2-chosen-6\"]")).sendKeys("Email");
//        driver.findElement(By.xpath("//*[@id=\"select2-chosen-7\"]")).sendKeys("Yes");

        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_nextImageButton\"]")).click();
//        WebElement ifFrame = driver.findElement(By.cssSelector("iframe[src*=\"anchor\"]"));
//        driver.switchTo().frame(ifFrame);
//        while (true) {
//            WebElement anchor = driver.findElement(By.id("recaptcha-anchor"));
//            String attribute = anchor.getAttribute("aria-checked");
//            if (Boolean.valueOf(attribute) == true) {
//                break;
//            }
//            System.out.println("当前识别状态：" + attribute);
//            Thread.sleep(1000);
//        }
//
//        driver.switchTo().defaultContent();
//        driver.findElement(By.id("recaptcha-demo-submit")).click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.quit();

        System.out.println("****END******, cost:" + started.elapsed(TimeUnit.SECONDS));
    }
}
