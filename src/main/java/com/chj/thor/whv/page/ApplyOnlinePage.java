package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * https://onlineservices.immigration.govt.nz/?STATUS
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/7 23:35
 */
public class ApplyOnlinePage extends AbstractPage {
    public static final String pageId = "?STATUS";
    @FindBy(xpath = "//*[@id=\"WHS_applicationsDataGrid\"]/tbody/tr[2]/td[1]")
    public WebElement applicationId;
    @FindBy(xpath = "//*[@id=\"WHS_applicationsDataGrid\"]/tbody/tr[2]/td[2]/a")
    public WebElement description;
    private String descriptionId = "//*[@id=\"WHS_applicationsDataGrid\"]/tbody/tr[2]/td[2]/a";

    public ApplyOnlinePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
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
        description.click();
    }
}
