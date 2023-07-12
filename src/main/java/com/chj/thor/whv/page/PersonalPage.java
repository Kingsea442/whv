package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/7 16:39
 */
public class PersonalPage extends AbstractPage{
    public static final String pageId = "Personal1.aspx";
    private WebDriver driver;
    private JavascriptExecutor js;


    private String familyNameId = "ContentPlaceHolder1_personDetails_familyNameTextBox";

    private String genderId = "ContentPlaceHolder1_personDetails_genderDropDownList";

    private String countryOfBirthId = "ContentPlaceHolder1_personDetails_CountryDropDownList";

    private String dateOfBirthId = "ContentPlaceHolder1_personDetails_dateOfBirthDatePicker_DatePicker";

    private String streetNameId = "ContentPlaceHolder1_addressContactDetails_address_address1TextBox";

    private String suburbId = "ContentPlaceHolder1_addressContactDetails_address_suburbTextBox";

    private String cityId = "ContentPlaceHolder1_addressContactDetails_address_cityTextBox";

    private String addressCountryId = "ContentPlaceHolder1_addressContactDetails_address_countryDropDownList";

    private String representedId = "ContentPlaceHolder1_hasAgent_representedByAgentDropdownlist";

    private String communicationMethodId = "ContentPlaceHolder1_communicationMethod_communicationMethodDropDownList";

    private String hasPaymentCardId = "ContentPlaceHolder1_hasCreditCard_hasCreditCardDropDownlist";

    private String nextId = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_nextImageButton";

    private String tabStatusId0 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_0";
    private String tabStatusId1 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_1";
    private String tabStatusId2 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_2";
    private String tabStatusId3 = "ContentPlaceHolder1_wizardPageHeader_nav_sectionTabs_TabHeaders_statusImage_3";

    private String submitId = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_submitImageButton";


    public PersonalPage(WebDriver webDriver) {
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
        driver.findElement(By.id(familyNameId));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        fill(js, form);
    }

    public void fill(JavascriptExecutor js, WorkingHolidayVisaApplicationForm form) {
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
        sb.append(setValueByIdScript(familyNameId, form.getFamilyName()));
        sb.append(setValueByIdScript(genderId, "M"));
        sb.append(setValueByIdScript(countryOfBirthId, "45"));
        sb.append(setValueByIdScript(dateOfBirthId, form.getDateOfBirth()));
        sb.append(setValueByIdScript(streetNameId, form.getStreetName()));
        sb.append(setValueByIdScript(suburbId, form.getSuburb()));
        sb.append(setValueByIdScript(cityId, form.getCity()));
        sb.append(setValueByIdScript(addressCountryId, "45"));
        sb.append(setValueByIdScript(representedId, "No"));
        sb.append(setValueByIdScript(communicationMethodId, "1"));
        sb.append(setValueByIdScript(hasPaymentCardId, "Yes"));
        js.executeScript(sb.toString());

        clickById(js, nextId);
    }

//    public void fill(WebDriver driver, WorkingHolidayVisaApplicationForm applicationForm) {
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("document.getElementById(\"ContentPlaceHolder1_personDetails_genderDropDownList\").style.display='block';\n" +
//                "document.getElementById(\"ContentPlaceHolder1_personDetails_CountryDropDownList\").style.display='block';\n" +
//                "document.getElementById(\"ContentPlaceHolder1_addressContactDetails_address_countryDropDownList\").style.display='block';\n" +
//                "document.getElementById(\"ContentPlaceHolder1_hasAgent_representedByAgentDropdownlist\").style.display='block';\n" +
//                "document.getElementById(\"ContentPlaceHolder1_communicationMethod_communicationMethodDropDownList\").style.display='block';\n" +
//                "document.getElementById(\"ContentPlaceHolder1_hasCreditCard_hasCreditCardDropDownlist\").style.display='block';");
//
//
//        if (StringUtils.isNotBlank(applicationForm.getFamilyName())) {
//            familyName.sendKeys(applicationForm.getFamilyName());
//        }
//
//        genderSelect.selectByVisibleText(applicationForm.getGender());
//        countryOfBirthSelect.selectByVisibleText(applicationForm.getCountryOfBirth());
//        dateOfBirth.sendKeys(applicationForm.getDateOfBirth());
//
//        streetName.sendKeys(applicationForm.getStreetName());
//        suburb.sendKeys(applicationForm.getSuburb());
//        city.sendKeys(applicationForm.getCity());
//        addressCountrySelect.selectByVisibleText(applicationForm.getCountry());
//
//        representedSelect.selectByValue(applicationForm.getRepresented());
//        communicationMethodSelect.selectByVisibleText(applicationForm.getCommunicationMethod());
//        hasPaymentCardSelect.selectByVisibleText(applicationForm.getCreditCard());
//
//        next.click();
//    }

}
