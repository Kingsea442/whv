package com.chj.thor.whv;

import com.chj.thor.whv.page.*;
import com.chj.thor.whv.page.manager.PageManager;
import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/7 17:49
 */
public class WHVStarter {
    public static void main(String[] args) throws InterruptedException, MalformedURLException, ExecutionException {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeOptions.addExtensions(new File("/Users/wanglianhai/sea/opt/selenium/captcha_plugin.zip"));

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://onlineservices.immigration.govt.nz");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().window().maximize();
        WorkingHolidayVisaApplicationForm applicationForm = getApplicationForm();

        PageManager pageManager = new PageManager();
        // 先登录
        pageManager.process(driver, applicationForm);
        Thread.sleep(2000);

        // 跳转到申请页
        driver.navigate().to(applicationForm.getApplyUrl());

        // 开始处理申请页
        pageManager.process(driver, applicationForm);

        // 开始填充信息，直到符合结束条件才能退出
        long loopTime = 0;
        while (!checkIfShouldFinished(driver)) {
            System.out.println("loop count:" + loopTime);
            pageManager.process(driver, applicationForm);
            loopTime++;
        }

        Thread.sleep(1000 * 30);
        driver.quit();
    }

    private static boolean checkIfShouldFinished(WebDriver driver) {
        return false;
    }

    public static WorkingHolidayVisaApplicationForm getApplicationForm() {
        WorkingHolidayVisaApplicationForm form = new WorkingHolidayVisaApplicationForm();
        form.setUsername("xiaohei123");
        form.setPassword("7CzSzw8#+mhAMh2");

        form.setFamilyName("WANG LIANHAI123");
        form.setGender("Male");
        form.setDateOfBirth("12 May, 1995");
        form.setCountryOfBirth("China");

        form.setStreetName("HUILONGGUAN");
        form.setSuburb("LONGHUAYUAN");
        form.setCity("BEIJING");
        form.setCountry("China");

        form.setRepresented("No");
        form.setCommunicationMethod("Email");
        form.setCreditCard("Yes");

        form.setPassportNumber("E00000008");
        form.setPassportExpireDate("12 May, 2030");
        form.setIdentificationType("Birth Certificate");
        form.setDateDocumentIssued("12 May, 2020");
        form.setIntendTravelDate("12 May, 2024");

        form.setPayerName("WANG LIANHAI");



        return form;
    }
}
