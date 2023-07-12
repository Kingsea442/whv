package com.chj.thor.whv.page;

import com.chj.thor.whv.pojo.WorkingHolidayVisaApplicationForm;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 13:09
 */
public interface Page {
    /**
     * 页面描述，用于输出日志
     * @return
     */
    String getPageId();

    /**
     * 判断是不是当前要处理的页面
     * @return
     */
    boolean checkPage();
    /**
     * 等待页面加载完成
     */
    void initPage();

    /**
     * 处理页面
     */
    void processPage(WorkingHolidayVisaApplicationForm form);
}
