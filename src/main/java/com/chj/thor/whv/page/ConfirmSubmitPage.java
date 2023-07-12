package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * https://onlineservices.immigration.govt.nz/WorkingHoliday/Application/Submit.aspx?ApplicationId=3164850
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/10 19:03
 */
public class ConfirmSubmitPage extends AbstractPage {
    public static final String pageId = "Submit.aspx?ApplicationId";
    private WebDriver driver;
    private JavascriptExecutor js;

    private String option1Id = "ContentPlaceHolder1_falseStatementCheckBox";
    private String option2Id = "ContentPlaceHolder1_notesCheckBox";
    private String option3Id = "ContentPlaceHolder1_circumstancesCheckBox";
    private String option4Id = "ContentPlaceHolder1_warrantsCheckBox";
    private String option5Id = "ContentPlaceHolder1_informationCheckBox";
    private String option6Id = "ContentPlaceHolder1_healthCheckBox";
    private String option7Id = "ContentPlaceHolder1_adviceCheckBox";
    private String option8Id = "ContentPlaceHolder1_registrationCheckBox";
    private String option9Id = "ContentPlaceHolder1_entitlementCheckbox";
    private String option10Id = "ContentPlaceHolder1_permitExpiryCheckBox";
    private String option11Id = "ContentPlaceHolder1_medicalInsuranceCheckBox";
    private String submitId = "ContentPlaceHolder1_submitImageButton";

    public ConfirmSubmitPage(WebDriver webDriver) {
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
        driver.findElement(By.id(submitId));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        StringBuilder sb = new StringBuilder();
        sb.append(checkedByIdScript(option1Id, true));
        sb.append(checkedByIdScript(option2Id, true));
        sb.append(checkedByIdScript(option3Id, true));
        sb.append(checkedByIdScript(option4Id, true));
        sb.append(checkedByIdScript(option5Id, true));
        sb.append(checkedByIdScript(option6Id, true));
        sb.append(checkedByIdScript(option7Id, true));
        sb.append(checkedByIdScript(option8Id, true));
        sb.append(checkedByIdScript(option9Id, true));
        sb.append(checkedByIdScript(option10Id, true));
        sb.append(checkedByIdScript(option11Id, true));
        js.executeScript(sb.toString());

        while (true) {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_preSubmitPanel\"]/table/tbody/tr[13]/td[2]/label"));
            if (StringUtils.equalsIgnoreCase(element.getText(), "Yes")) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        checkAndCaptcha(driver);
    }

    private static void checkAndCaptcha(WebDriver driver) {
        // 中间可能会出现验证码页面
        System.out.println("*****验证码******");
        try {
            WebElement ifFrame = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_preSubmitPanel\"]/div[3]/div/iframe"));
            if (ifFrame != null) {
                driver.switchTo().frame(ifFrame);
                while (true) {
                    WebElement anchor = driver.findElement(By.id("checkbox"));
                    String attribute = anchor.getAttribute("aria-checked");
                    if (Boolean.valueOf(attribute) == true) {
                        break;
                    }
                    System.out.println("当前识别状态：" + attribute);
                    Thread.sleep(200);
                }
                driver.switchTo().defaultContent();
                driver.findElement(By.id("ContentPlaceHolder1_submitImageButton")).click();
            }
        } catch (Exception e) {

        }
    }
}
