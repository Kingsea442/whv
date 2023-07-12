package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/10 20:54
 */
public class OnlinePaymentPage extends AbstractPage {
    public static final String pageId = "PaymentGateway/OnLinePayment.aspx";
    private WebDriver driver;
    private JavascriptExecutor js;

    private static final String payerNameId = "_ctl0_ContentPlaceHolder1_payerNameTextBox";
    private static final String okId = "_ctl0_ContentPlaceHolder1_okButton";

    public OnlinePaymentPage(WebDriver webDriver) {
        this.driver = webDriver;
        js = (JavascriptExecutor) webDriver;
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
        driver.findElement(By.id(payerNameId));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        setValueById(js, payerNameId, form.getPayerName());
        clickById(js, okId);
    }
}
