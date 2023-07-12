package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * https://onlineservices.immigration.govt.nz/WorkingHoliday/Wizard/WorkingHolidaySpecific.aspx?ApplicationId=3164850&IndividualType=Primary&IndividualIndex=1
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/10 18:42
 */
public class WHSSpecificPage extends AbstractPage{
    public static final String pageId = "WorkingHolidaySpecific.aspx";
    private WebDriver driver;
    private JavascriptExecutor js;


    private String option1Id = "ContentPlaceHolder1_offshoreDetails_commonWHSQuestions_previousWhsPermitVisaDropDownList";
    private String option2Id = "ContentPlaceHolder1_offshoreDetails_commonWHSQuestions_sufficientFundsHolidayDropDownList";
    private String intendTravelDateId = "ContentPlaceHolder1_offshoreDetails_intendedTravelDateDatePicker_DatePicker";
    private String option3Id = "ContentPlaceHolder1_offshoreDetails_beenToNzDropDownList";
    private String option4Id = "ContentPlaceHolder1_offshoreDetails_requirementsQuestions_sufficientFundsOnwardTicketDropDownList";
    private String option5Id = "ContentPlaceHolder1_offshoreDetails_requirementsQuestions_readRequirementsDropDownList";
    private String saveId = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_validateButton";
    private String submitId = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_submitImageButton";

    private String tabStatusId0 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_0";
    private String tabStatusId1 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_1";
    private String tabStatusId2 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_2";
    private String tabStatusId3 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_3";

    public WHSSpecificPage(WebDriver webDriver) {
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
        driver.findElement(By.id(option1Id));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        WebElement element0 = driver.findElement(By.id(tabStatusId0));
        WebElement element1 = driver.findElement(By.id(tabStatusId1));
        WebElement element2 = driver.findElement(By.id(tabStatusId2));
        WebElement element3 = driver.findElement(By.id(tabStatusId3));
        String attribute0 = element0.getAttribute("title");
        String attribute1 = element1.getAttribute("title");
        String attribute2 = element2.getAttribute("title");
        String attribute3 = element3.getAttribute("title");

        if (StringUtils.equalsIgnoreCase(attribute0, "Completed")
                && StringUtils.equalsIgnoreCase(attribute1, "Completed")
                && StringUtils.equalsIgnoreCase(attribute2, "Completed")
                && StringUtils.equalsIgnoreCase(attribute3, "Completed")) {
            WebElement submit = driver.findElement(By.id(submitId));
            submit.click();
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(setValueByIdScript(option1Id, "No"));
        sb.append(setValueByIdScript(intendTravelDateId, form.getIntendTravelDate()));
        sb.append(setValueByIdScript(option2Id, "Yes"));
        sb.append(setValueByIdScript(option3Id, "No"));
        sb.append(setValueByIdScript(option4Id, "Yes"));
        sb.append(setValueByIdScript(option5Id, "Yes"));
        js.executeScript(sb.toString());

        clickById(js, saveId);
    }
}
