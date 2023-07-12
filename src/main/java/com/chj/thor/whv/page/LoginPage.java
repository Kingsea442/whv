package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * https://onlineservices.immigration.govt.nz/
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/7 17:20
 */
public class LoginPage extends AbstractPage{
    private static final String pageId = "LOGIN";
    private WebDriver driver;
    private JavascriptExecutor js;

    @FindBy(xpath = "/html/body/div[1]/form/div/div[3]/div/div[2]/div[1]/input")
    public WebElement userName;
    private String userNameXpath = "/html/body/div[1]/form/div/div[3]/div/div[2]/div[1]/input";

    @FindBy(xpath = "/html/body/div[1]/form/div/div[3]/div/div[2]/div[2]/input")
    public WebElement userPassword;
    private String userPasswordXpath = "/html/body/div[1]/form/div/div[3]/div/div[2]/div[2]/input";

    @FindBy(xpath = "/html/body/div[1]/form/div/div[3]/div/div[2]/div[3]/input")
    public WebElement login;
    private String loginXpath = "/html/body/div[1]/form/div/div[3]/div/div[2]/div[3]/input";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
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
        driver.findElement(By.xpath("/html/body/div[1]/form/div/div[3]/div/div[2]/div[3]/input"));
    }

    @Override
    public void processPage(WorkingHolidayVisaApplicationForm form) {
        StringBuilder sb = new StringBuilder();
        sb.append(setValueByXpathScript(userNameXpath, form.getUsername()));
        sb.append(setValueByXpathScript(userPasswordXpath, form.getPassword()));
        js.executeScript(sb.toString());

        clickByXpath(js, loginXpath);
    }
}


