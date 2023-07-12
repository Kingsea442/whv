package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 22:27
 */
public class ApplicationCreatePage extends AbstractPage{
    public static final String pageId = "Application/Create.aspx?CountryId";
    private WebDriver driver;
    private JavascriptExecutor js;

    private static final String applyNowId = "ContentPlaceHolder1_applyNowButton";

    public ApplicationCreatePage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    @Override
    public String getPageId() {
        return pageId;
    }

    @Override
    public boolean checkPage() {
        if (StringUtils.containsIgnoreCase(driver.getCurrentUrl(), pageId)) {
            return true;
        }
        return false;
    }

    @Override
    public void initPage() {
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        if (!checkPage()) {
            return;
        }
        try {
            WebElement applyNowElement = driver.findElement(By.id(applyNowId));
            if (applyNowElement != null && applyNowElement.isDisplayed()) {
                clickById(js, applyNowId);
            }
        } catch (Exception e) {
            // 可能还没开放需要继续刷新加载重试
            System.out.println(e);
            System.out.println("no applyNowElement button");
            driver.navigate().refresh();
            processPage(form);
        }

    }
}
