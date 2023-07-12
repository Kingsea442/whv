package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/10 18:58
 */
public class SubmitPage {

    @FindBy(id = "ContentPlaceHolder1_wizardPageFooter_wizardPageNavigator_submitImageButton")
    public WebElement submit;

    public SubmitPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fill(WebDriver driver, WorkingHolidayVisaApplicationForm applicationForm) {
        submit.click();
    }
}

