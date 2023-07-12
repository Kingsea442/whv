package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/7 17:21
 */
public abstract class AbstractPage implements Page {
//
//    abstract void fillPageInfo(WorkingHolidayVisaApplicationForm form);

    public String setValueByXpathScript(String xpath, Object value) {
        return String.format("document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value=\"%s\";", xpath, value);
    }

    public String setValueByIdScript(String id, Object value) {
        return String.format("document.getElementById(\"%s\").value=\"%s\";", id, value);
    }

    public void setValueById(JavascriptExecutor js, String id, Object value) {
        js.executeScript(String.format("document.getElementById(\"%s\").value=\"%s\";", id, value));
    }

    public void clickById(JavascriptExecutor js, String id) {
        js.executeScript(String.format("document.getElementById(\"%s\").click();", id));
    }

    public String clickByIdScript(String id) {
        return String.format("document.getElementById(\"%s\").click();", id);
    }

    public String checkedByIdScript(String id, boolean checked) {
        return String.format("document.getElementById(\"%s\").checked=%s;", id, checked);
    }

    public void clickByXpath(JavascriptExecutor js, String xpath) {
        js.executeScript(String.format("document.evaluate(\"%s\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();", xpath));
    }
}
