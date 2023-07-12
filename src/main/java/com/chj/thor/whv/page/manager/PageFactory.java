package com.chj.thor.whv.page.manager;

import com.chj.thor.whv.page.*;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domsnapshot.model.StringIndex;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 13:33
 */
public class PageFactory {
    public static Page getPage(WebDriver driver) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("get Page By url: " + currentUrl);
        if (checkIfLogingPage(driver)) {
            return new LoginPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, CaptchaPage.pageId)) {
            return new CaptchaPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, ApplyOnlinePage.pageId)) {
            return new ApplyOnlinePage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, PersonalPage.pageId)) {
            return new PersonalPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, IdentificationPage.pageId)) {
            return new IdentificationPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, OccupationDetailPage.pageId)) {
            return new OccupationDetailPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, HealthPage.pageId)) {
            return new HealthPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, CharacterPage.pageId)) {
            return new CharacterPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, WHSSpecificPage.pageId)) {
            return new WHSSpecificPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, ConfirmSubmitPage.pageId)) {
            return new ConfirmSubmitPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, SubmitReceivedPage.pageId)) {
            return new SubmitReceivedPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, PayForYourApplicationPage.pageId)) {
            return new PayForYourApplicationPage(driver);
        }


        if (StringUtils.containsIgnoreCase(currentUrl, OnlinePaymentPage.pageId)) {
            return new OnlinePaymentPage(driver);
        }

        if (StringUtils.containsIgnoreCase(currentUrl, FinalPayPage.pageId)) {
            return new FinalPayPage(driver);
        }

//        if (StringUtils.containsIgnoreCase(currentUrl, WorkHolidayPage.pageId)) {
//            return new WorkHolidayPage(driver);
//        }

        if (StringUtils.containsIgnoreCase(currentUrl, ExistingApplicationPage.pageId)) {
            return new ExistingApplicationPage(driver);
        }


        if (StringUtils.containsIgnoreCase(currentUrl, ApplicationCreatePage.pageId)) {
            return new ApplicationCreatePage(driver);
        }

        // 如果找不到page，跳转到首页重新处理
        System.out.println("not found page, url=" + currentUrl);
        return null;
    }

    private static boolean checkIfLogingPage(WebDriver driver) {
        if (StringUtils.equalsIgnoreCase(driver.getCurrentUrl(), "https://onlineservices.immigration.govt.nz/")) {
            return true;
        }
        return false;
    }
}
