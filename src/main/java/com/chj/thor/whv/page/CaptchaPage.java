package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 13:23
 */
public class CaptchaPage extends AbstractPage {
    public static final String pageId = "rs-captcha";
    private WebDriver driver;
    private JavascriptExecutor js;

    public CaptchaPage(WebDriver driver) {
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
        // 等待页面加载完成
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        try {
            WebElement ifFrame = driver.findElement(By.cssSelector("#ContentPlaceHolder1_preSubmitPanel > div:nth-child(3) > div > iframe"));
            if (ifFrame != null) {
                driver.switchTo().frame(ifFrame);
                clickById(js, "checkbox");
                while (true) {
                    WebElement anchor = driver.findElement(By.id("checkbox"));
                    String attribute = anchor.getAttribute("aria-checked");
                    if (Boolean.valueOf(attribute) == true) {
                        break;
                    }
                    System.out.println("当前识别状态：" + attribute);
                    Thread.sleep(10000);
                }
                driver.switchTo().defaultContent();
                clickById(js, "ContentPlaceHolder1_submitImageButton");
            }
        } catch (Exception e) {

        }
    }
}
