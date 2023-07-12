package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * https://onlineservices.immigration.govt.nz/WorkingHoliday/Wizard/Medical1.aspx?ApplicationId=3164850&IndividualType=Primary&IndividualIndex=1
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/7 23:09
 */
public class HealthPage extends AbstractPage{
    public static final String pageId = "Medical1.aspx";
    private WebDriver driver;
    private JavascriptExecutor js;

    private String option1Id = "ContentPlaceHolder1_medicalConditions_renalDialysisDropDownList";
    private String option2Id = "ContentPlaceHolder1_medicalConditions_tuberculosisDropDownList";
    private String option3Id = "ContentPlaceHolder1_medicalConditions_cancerDropDownList";
    private String option4Id = "ContentPlaceHolder1_medicalConditions_heartDiseaseDropDownList";
    private String option5Id = "ContentPlaceHolder1_medicalConditions_disabilityDropDownList";
    private String option6Id = "ContentPlaceHolder1_medicalConditions_hospitalisationDropDownList";
    private String option7Id = "ContentPlaceHolder1_medicalConditions_residentailCareDropDownList";
    private String option8Id = "ContentPlaceHolder1_medicalConditions_tbRiskDropDownList";
    private String nextId = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_nextImageButton";

    private String tabStatusId0 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_0";
    private String tabStatusId1 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_1";
    private String tabStatusId2 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_2";
    private String tabStatusId3 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_3";
    private String submitId = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_submitImageButton";


    public HealthPage(WebDriver webDriver) {
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
        sb.append(setValueByIdScript(option2Id, "No"));
        sb.append(setValueByIdScript(option3Id, "No"));
        sb.append(setValueByIdScript(option4Id, "No"));
        sb.append(setValueByIdScript(option5Id, "No"));
        sb.append(setValueByIdScript(option6Id, "No"));
        sb.append(setValueByIdScript(option7Id, "No"));
        sb.append(setValueByIdScript(option8Id, "Yes"));
        js.executeScript(sb.toString());

        clickById(js, nextId);
    }
}
