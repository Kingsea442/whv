package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.bind.Element;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 14:56
 */
public class WorkHolidayPage extends AbstractPage{
    public static final String pageId = "default.aspx";
    private WebDriver webDriver;
    private JavascriptExecutor js;

    private static final String editId = "ContentPlaceHolder1_applicationList_applicationsDataGrid_editHyperLink_0";
    private static final String submitId = "ContentPlaceHolder1_applicationList_applicationsDataGrid_submitHyperlink_0";
    private static final String payId = "ContentPlaceHolder1_applicationList_applicationsDataGrid_payHyperLink_0";

    public WorkHolidayPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        js = (JavascriptExecutor) webDriver;
    }

    @Override
    public String getPageId() {
        return pageId;
    }

    @Override
    public boolean checkPage() {
        if (StringUtils.containsIgnoreCase(webDriver.getCurrentUrl(), pageId)) {
            return true;
        }
        return false;
    }

    @Override
    public void initPage() {
        webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_applicationList_applicationsDataGrid\"]/tbody/tr[2]/td[5]"));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
//        TODO 2023年07月11日15:54:56 需要根据不同的类型处理，又不能一直阻塞等待响应
        WebElement submit = webDriver.findElement(By.id(submitId));
        if (submit != null && submit.isDisplayed()) {
            clickById(js, submitId);
        } else {
            clickById(js, editId);
        }
    }
}
