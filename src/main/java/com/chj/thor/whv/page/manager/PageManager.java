package com.chj.thor.whv.page.manager;

import com.chj.thor.whv.page.AbstractPage;
import com.chj.thor.whv.page.Page;
import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;
import com.google.common.base.Stopwatch;
import javafx.scene.paint.Stop;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.StopWatch;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 13:32
 */
@Slf4j
public class PageManager {
    public void process(WebDriver driver, WorkingHolidayVisaApplicationForm form) {
        try {
            Page page = PageFactory.getPage(driver);
            Stopwatch stopwatch = Stopwatch.createStarted();
            System.out.println(String.format("%s start execute", page.getClass().getName()));
            log.info("{} start execute, at:{}", page.getClass().getName(), new Date());
            if (!page.checkPage()) {
                return;
            }
            page.initPage();
            page.processPage(form);
            System.out.println(String.format("%s start execute, cost:%s", page.getClass().getName(), stopwatch.elapsed(TimeUnit.SECONDS)));

            System.out.println(String.format("%s end execute", page.getPageId()));
        } catch (Exception e) {
            System.out.println(e);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
