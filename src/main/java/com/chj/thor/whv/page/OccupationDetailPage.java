package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * https://onlineservices.immigration.govt.nz/WorkingHoliday/Wizard/Personal3.aspx?ApplicationId=3164850&IndividualType=Primary&IndividualIndex=1
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/10 17:41
 */
public class OccupationDetailPage extends AbstractPage{
    public static final String pageId = "Personal3.aspx";
    private String nextId = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_nextImageButton";

    private WebDriver driver;
    private JavascriptExecutor js;


    public OccupationDetailPage(WebDriver webDriver) {
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
        driver.findElement(By.id(nextId));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        clickById(js, nextId);

    }

}
