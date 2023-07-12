package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * https://onlineservices.immigration.govt.nz/WorkingHoliday/Wizard/Personal2.aspx?ApplicationId=3164850&IndividualType=Primary&IndividualIndex=1
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/9 17:03
 */
public class IdentificationPage extends AbstractPage{
    public static final String pageId = "Personal2.aspx";
    private WebDriver driver;
    private JavascriptExecutor js;

    private String passportNumberId = "ContentPlaceHolder1_identification_passportNumberTextBox";

    private String reEnterPasswordNumberId = "ContentPlaceHolder1_identification_confirmPassportNumberTextBox";

    private String expireDateId = "ContentPlaceHolder1_identification_passportExpiryDateDatePicker_DatePicker";

    private String identificationTypeId = "ContentPlaceHolder1_identification_otherIdentificationDropdownlist";

    private String issuedDocumentDateId = "ContentPlaceHolder1_identification_otherIssueDateDatePicker_DatePicker";

    private String expireDocumentDateId = "ContentPlaceHolder1_identification_otherExpiryDateDatePicker_DatePicker";

    private String nextId = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_nextImageButton";

    public IdentificationPage(WebDriver webDriver) {
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
        driver.findElement(By.id(passportNumberId));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        StringBuilder sb = new StringBuilder();
        sb.append(setValueByIdScript(passportNumberId, form.getPassportNumber()));
        sb.append(setValueByIdScript(reEnterPasswordNumberId, form.getPassportNumber()));
        sb.append(setValueByIdScript(expireDateId, form.getPassportExpireDate()));
        sb.append(setValueByIdScript(identificationTypeId, "2"));
        sb.append(setValueByIdScript(issuedDocumentDateId, form.getDateDocumentIssued()));
        js.executeScript(sb.toString());

        clickById(js, nextId);
    }
}
