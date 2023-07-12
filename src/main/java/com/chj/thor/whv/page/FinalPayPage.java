package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 16:03
 */
public class FinalPayPage extends AbstractPage{
    public static final String pageId = "payments.paystation";
    private WebDriver driver;
    private JavascriptExecutor js;

    private static final String cardNumberId = "cardnumber";
    private static final String expirydateId = "expirydate";
    private static final String cardverificationcodeId = "cardverificationcode";
    private static final String cardholderId = "cardholder";
    private static final String payXpath = "//*[@id=\"CREDIT_CARD\"]/form/div[4]/button";

    public FinalPayPage(WebDriver driver) {
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
        driver.findElement(By.id(cardholderId));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        StringBuilder sb = new StringBuilder();
        sb.append(setValueByIdScript(cardNumberId, form.getCardNumber()));
        sb.append(setValueByIdScript(expirydateId, form.getCardExpiryDate()));
        sb.append(setValueByIdScript(cardverificationcodeId, form.getCardVerificationCode()));
        sb.append(setValueByIdScript(cardholderId, form.getCardholder()));
        js.executeScript(sb.toString());

        driver.findElement(By.xpath(payXpath)).click();
    }
}
