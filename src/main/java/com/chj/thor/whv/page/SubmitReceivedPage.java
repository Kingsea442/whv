package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * https://onlineservices.immigration.govt.nz/WorkingHoliday/Application/Submit.aspx?Token=LctQ9Y5g%2b5WanrJmA6S2Wf%2bEfRwhyV1KrXmx8a9cm5KD3jQQTS50g11bCZpMZxeqgaK4Mt%2fDg2o%3d
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/10 19:55
 */
public class SubmitReceivedPage extends AbstractPage {
    public static final String pageId = "Submit.aspx?Token";
    private WebDriver driver;
    private JavascriptExecutor js;

    private String payNowId = "ContentPlaceHolder1_payAnchor";

    public SubmitReceivedPage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    @Override
    public String getPageId() {
        return pageId;
    }

    @Override
    public boolean checkPage() {
        return true;
    }

    @Override
    public void initPage() {
        driver.findElement(By.id(payNowId));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        clickById(js, payNowId);

    }
}
