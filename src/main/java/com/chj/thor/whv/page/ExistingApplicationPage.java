package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 20:41
 */
public class ExistingApplicationPage extends AbstractPage{
    public static final String pageId = "WorkingHoliday/default.aspx";
    private WebDriver driver;
    private JavascriptExecutor js;

    private static final String statusId = "ContentPlaceHolder1_applicationList_applicationsDataGrid_statusLabel_0";
    private static final String payId = "ContentPlaceHolder1_applicationList_applicationsDataGrid_payHyperLink_0";

    public ExistingApplicationPage(WebDriver webDriver) {
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
        driver.findElement(By.id(statusId));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        WebElement element = driver.findElement(By.id(statusId));
        if (StringUtils.equalsIgnoreCase(element.getText(), "Submitted")) {
            clickById(js, payId);
        }

    }
}
