package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/10 20:48
 */
public class PayForYourApplicationPage extends AbstractPage{
    public static final String pageId = "WorkingHoliday/Application/Pay.aspx?Token";
    private WebDriver driver;
    private JavascriptExecutor js;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_onlinePaymentAnchor2\"]/span")
    public WebElement nextStep;

    public PayForYourApplicationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
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

    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        nextStep.click();
    }
}
